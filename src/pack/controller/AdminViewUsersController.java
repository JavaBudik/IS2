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
 * Controller for view users of system.
 * @author kfidria
 *
 */
public class AdminViewUsersController implements Controller {
	/** admins DAO. */
	private AbstractAdministratorDAO adminsDAO = null;
	/** customers DAO. */
	private AbstractLowUserDAO lowUserDAO = null;
	/** importers DAO. */
	private AbstractPowerUserDAO powerUserDAO = null;

	/**
	 * @param request HTTP request
	 * @param response HTTP response
	 * @return ModelAndView("/WEB-INF/jsp/admin_view_users.jsp")
	 * @throws Exception except
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView(
				"/WEB-INF/jsp/admin_view_users.jsp");
		OldUsers users = viewUsers();
		modelAndView.addObject("users", users);

		return modelAndView;

	}

	/**
	 * 
	 * @return users of system
	 */
	public final OldUsers viewUsers() {
		OldUsers users = new OldUsers();
				
		users.setAdmins(adminsDAO.findAllOld());
		users.setLowUser(lowUserDAO.findAllOld());
		users.setPowerUser(powerUserDAO.findAllOld());		
		return users;
	}
	
	/**
	 * 
	 * @param dao sets from applicationContent
	 */
	public void setLowUserDAO(final AbstractLowUserDAO dao) {
		this.lowUserDAO = dao;
	}
	
	/**
	 * @param dao sets from applicationContent
	 */
	public void setPowerUserDAO(final AbstractPowerUserDAO dao) {
		this.powerUserDAO = dao;
	}

	/**
	 * @param dao sets from applicationContent
	 */
	public void setAdminsDAO(final AbstractAdministratorDAO dao) {
		this.adminsDAO = dao;
	}
}
