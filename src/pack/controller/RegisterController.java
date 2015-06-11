package pack.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import pack.command.RegisterCommand;

public class RegisterController extends SimpleFormController {
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, 
			HttpServletResponse response, Object command, 
			BindException errors) throws ServletException {
		RegisterCommand rCommand = (RegisterCommand) command;
		String role = rCommand.getRole();
		if (role==null) return new ModelAndView("redirect:register.htm"); 
		if (role.equals("LowUser")) {
			return new ModelAndView("redirect:registerLowUser.htm");			
		} else {
			if (role.equals("PowerUser")) {
				return new ModelAndView("redirect:registerPowerUser.htm");				
			} else return new ModelAndView("redirect:registerAdmin.htm");
			
		}
	}	
	@Override
	protected ModelAndView processFormSubmission(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		String parametr = request.getParameter("back");
		
		if (parametr != null && parametr.equals("<< Повернутися")) {
			
			return new ModelAndView("redirect:login.jsp");
		}
		
		return super.processFormSubmission(request, response, command, errors);
	}
}
