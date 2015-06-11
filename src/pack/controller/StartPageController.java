package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.pojo.Administrator;
import pack.pojo.LowUser;
import pack.pojo.PowerUser;
import pack.pojo.User;
import pack.security.HibernateUserDetails;

import pack.abstractdao.AbstractAdministratorDAO;
import pack.abstractdao.AbstractLowUserDAO;
import pack.abstractdao.AbstractPowerUserDAO;
import pack.abstractdao.AbstractUserDAO;

public class StartPageController implements Controller {
	
	private AbstractUserDAO userDAO;
	public void setUserDAO(AbstractUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	private AbstractAdministratorDAO adminsDAO;
	public void setAdminsDAO(AbstractAdministratorDAO adminsDAO) {
		this.adminsDAO = adminsDAO;
	}
	private AbstractPowerUserDAO powerUserDAO;
	public void setPowerUserDAO(AbstractPowerUserDAO powerUserDAO) {
		this.powerUserDAO = powerUserDAO;
	}
	private AbstractLowUserDAO lowUserDAO;
	public void setLowUserDAO(AbstractLowUserDAO lowUserDAO) {
		this.lowUserDAO = lowUserDAO;
	}
	
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails)obj).getUsername();
		Long id = ((HibernateUserDetails)obj).getId();
		String name = "Unknown";
		User user = userDAO.findById(id);
		if (user instanceof Administrator) {
			name = adminsDAO.findById(id).getAdminsName();
		}
		if (user instanceof PowerUser) {
			name = powerUserDAO.findById(id).getImporterName();
		}
		if (user instanceof LowUser) {
			name = lowUserDAO.findById(id).getCustomerName();
		}
		ModelAndView mav = new ModelAndView("/WEB-INF/jsp/startPage.jsp");
		mav.addObject("name", name);
		return mav;
	}	
	
}
