package pack.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.providers.dao.salt.ReflectionSaltSource;
import org.springframework.security.providers.encoding.ShaPasswordEncoder;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import pack.abstractdao.AbstractUserDAO;
import pack.command.RegisterCommand;
import pack.pojo.PowerUser;
import pack.security.HibernateUserDetails;

public class RegPowerUserController extends SimpleFormController {
private AbstractUserDAO userDAO;
	
	public void setUserDAO(AbstractUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, 
			HttpServletResponse response, Object command, 
			BindException errors) throws ServletException {
				
		RegisterCommand regCommand = (RegisterCommand) command;
		String login = regCommand.getLogin();
		
		if (!unique(login)) {
			return new ModelAndView("redirect:index.jsp");
		}
		
		String password = regCommand.getPassword();
		String name = regCommand.getFirstName();
		String question = regCommand.getQuestion();
		String answer = regCommand.getAnswer();
		String phone = regCommand.getPhone();
		String city = regCommand.getCity();
		String country = regCommand.getCountry();
		//String styleDetails = regCommand.getStyleDetails();
		
		PowerUser importer = new PowerUser();
		importer.setImporterName(name);
		importer.setLogin(login);
		importer.setPassword(password);
		importer.setQuestion(question);
		importer.setAnswer(answer);
		importer.setPhone(phone);
		importer.setImporterCity(city);
		importer.setImporterCountry(country);
		importer.setStatus("Unchecked");
		userDAO.save(importer);
			
		HibernateUserDetails userDetails = new HibernateUserDetails(importer);
		//String pass = userDetails.getPassword();
		ReflectionSaltSource saltSource = new ReflectionSaltSource();
		saltSource.setUserPropertyToUse("login");
		Object salt = saltSource.getSalt(userDetails);
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		importer.setPassword(passwordEncoder.encodePassword(password, salt));
		
		userDAO.save(importer);		
		return new ModelAndView("redirect:regSuccess.jsp");		
	}
	
	public boolean unique(String login) {
		try {
			userDAO.findByProperty("login", login).get(0);			
		}
		catch (IndexOutOfBoundsException e)
		{
			return true;
		}		
			return false;				
	}
	
	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		String parametr = request.getParameter("back");
		
		if (parametr != null && parametr.equals("<< Назад")) {
			
			return new ModelAndView("redirect:register.htm");
		}
		
		return super.processFormSubmission(request, response, command, errors);
	}
	
	@Override
	protected void onBind(HttpServletRequest request, Object command)
			throws Exception {
		RegisterCommand regCommand = (RegisterCommand) command;
		String parametr = request.getParameter("control");
		if (parametr != null && parametr.equals("Зареєструватися як Power")) {
		    //RegisterCommand command = new RegisterCommand();
		    regCommand.setRole("PowerUser");	
		    command = regCommand;
		}		    
		super.onBind(request, command);
	}
	
	/*@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		    UserCommand command = new UserCommand();
		    	    
			return command;
			}*/	
}