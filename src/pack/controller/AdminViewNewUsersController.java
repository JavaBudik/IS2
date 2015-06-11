package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import pack.abstractdao.AbstractAdministratorDAO;
import pack.abstractdao.AbstractLowUserDAO;
import pack.abstractdao.AbstractPowerUserDAO;
import pack.pojo.OldUsers;


/**
 * Controller for view New users that are waiting for registration.
 * @author kfidria
 *
 */
public class AdminViewNewUsersController implements Controller {
	/** admins DAO. */
	private AbstractAdministratorDAO adminsDAO = null;
	/** customers DAO. */
	private AbstractLowUserDAO lowUserDAO = null;
	/** importers DAO. */
	private AbstractPowerUserDAO powerUserDAO = null;

	/**
	 * @param request HTTP Request
	 * @param response HTTP Response
	 * @throws Exception exceptopn
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(
				"/WEB-INF/jsp/admin_view_new_users.jsp");
		OldUsers users = getUsers();
		
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	/**
	 * @param dao sets from applicationContent.
	 */
	public void setLowUserDAO(final AbstractLowUserDAO dao) {
		this.lowUserDAO = dao;
	}

	/**
	 * @param dao sets from applicationContent.
	 */
	public void setPowerUserDAO(AbstractPowerUserDAO dao) {
		this.powerUserDAO = dao;
	}

	/**
	 * @param dao sets from applicationContent.
	 */
	public void setAdminsDAO(AbstractAdministratorDAO dao) {
		this.adminsDAO = dao;
	}

	/**
	 * @return OldUsers 
	 */
	public final OldUsers getUsers() {
		OldUsers users = new OldUsers();
		users.setAdmins(adminsDAO.findAllNew());
		users.setPowerUser(powerUserDAO.findAllNew());
		users.setLowUser(lowUserDAO.findAllNew());			
		return users;
	}
}
