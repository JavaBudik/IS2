package pack.controller;

import java.util.ArrayList;
import java.util.List;

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
import pack.pojo.LowUser;
import pack.pojo.PowerUser;
import pack.pojo.User;
import pack.security.HibernateUserDetails;

public class RegLowUserController extends SimpleFormController {
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
		String email = regCommand.getEmail();
		String phone = regCommand.getPhone();
		String firstName = regCommand.getFirstName();
		String middleName = regCommand.getMiddleName();
		String surname = regCommand.getSurname();
		String city = regCommand.getCity();
		String country = regCommand.getCountry();
		String address = regCommand.getAddress();
			
		LowUser customer = new LowUser();
		customer.setLogin(login);
		customer.setPassword(password);
		customer.setQuestion(question);
		customer.setAnswer(answer);
		customer.setPhone(phone);
		customer.setCustomerName(firstName);
		customer.setCustomerMiddleName(middleName);
		customer.setCustomerSurname(surname);
		customer.setCustomerCity(city);
		customer.setCustomerCountry(country);
		customer.setCustomerAddress(address);
		customer.setStatus("Checked");
		userDAO.save(customer);
			
		HibernateUserDetails userDetails = new HibernateUserDetails(customer);
		//String pass = userDetails.getPassword();
		ReflectionSaltSource saltSource = new ReflectionSaltSource();
		saltSource.setUserPropertyToUse("login");
		Object salt = saltSource.getSalt(userDetails);
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder();
		customer.setPassword(passwordEncoder.encodePassword(password, salt));
		
		userDAO.save(customer);		
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
	protected void onBind(HttpServletRequest request, Object command)
			throws Exception {
		RegisterCommand regCommand = (RegisterCommand) command;
		String parametr = request.getParameter("control");
		if (parametr != null && parametr.equals("Зареєструватися як Low")) {
		    //RegisterCommand command = new RegisterCommand();
		    regCommand.setRole("LowUser");	
		    command = regCommand;
		}
		    
		super.onBind(request, command);
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
	
	/*@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		    UserCommand command = new UserCommand();
		    	    
			return command;
			}*/	
	
}
