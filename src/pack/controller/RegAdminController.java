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
import pack.pojo.Administrator;
import pack.security.HibernateUserDetails;

public class RegAdminController extends SimpleFormController {
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
		String question = regCommand.getQuestion();
		String answer = regCommand.getAnswer();
		String phone = regCommand.getPhone();
		String firstName = regCommand.getFirstName();
		String middleName = regCommand.getMiddleName();
		String surname = regCommand.getSurname();
		String address = regCommand.getAddress();		
		regCommand.setRole("Admin");
		
		Administrator admin = new Administrator();
		admin.setLogin(login);
		admin.setPassword(password);
		admin.setQuestion(question);
		admin.setAnswer(answer);
		admin.setPhone(phone);
		admin.setAdminsName(firstName);
		admin.setAdminsMiddleName(middleName);
		admin.setAdminsSurname(surname);
		admin.setAdminsAddress(address);		
		admin.setStatus("Unchecked");
		userDAO.save(admin);
		HibernateUserDetails userDetails = new HibernateUserDetails(admin);
		//String pass = userDetails.getPassword();
		ReflectionSaltSource saltSource = new ReflectionSaltSource();
		saltSource.setUserPropertyToUse("login");
		Object salt = saltSource.getSalt(userDetails);
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		admin.setPassword(passwordEncoder.encodePassword(password, salt));
		
		userDAO.save(admin);				
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
	
	/*
	protected ModelAndView processFormSubmission(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		String parametr = request.getParameter("control");
		if (parametr != null && parametr.equals("Register as admin")) {
			RegisterCommand regCommand = (RegisterCommand)command;
			regCommand.setRole("Admin");
			command = regCommand;
		}
		return super.processFormSubmission(request, response, command, errors);
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		String req  = request.getRequestURI();
		
		String parametr = request.getParameter("control");
		if (parametr != null && parametr.equals("Register as admin")) {
		    RegisterCommand command = new RegisterCommand();
		    command.setRole("Admin");	
		    return command;		    
			}	return new RegisterCommand();
	}
*/
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
		if (parametr != null && parametr.equals("Зареєструватися як адмін")) {
		    //RegisterCommand command = new RegisterCommand();
		    regCommand.setRole("Admin");	
		    command = regCommand;
		}
		    
		super.onBind(request, command);
	}
	
}
