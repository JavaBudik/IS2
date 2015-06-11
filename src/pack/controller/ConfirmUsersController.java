package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.abstractdao.AbstractAdministratorDAO;
import pack.abstractdao.AbstractPowerUserDAO;
import pack.abstractdao.AbstractLowUserDAO;
import pack.pojo.Administrator;
import pack.pojo.LowUser;
import pack.pojo.PowerUser;

/**
 * Controller to confirm or delete users.
 * @author kfidria
 */
public class ConfirmUsersController implements Controller {
	/** admins DAO. */
	private AbstractAdministratorDAO adminsDAO = null;
	/** importers DAO. */
	private AbstractPowerUserDAO powerUserDAO = null;
	/** Status of user. */
	private static final String STATUS = "Checked";
	
	/**
	 * @param request HTTP request
	 * @param respone HTTP response
	 * @return ModelAndView
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse respone) throws Exception {

		ModelAndView modelAndView = new ModelAndView(
				"redirect:admin_view_new_users.htm");
		try {
			makeChanges(request);
		} catch (Exception re) {
			ModelAndView errorPage = new ModelAndView("/WEB-INF/jsp/error.jsp");
			errorPage.addObject("errorMessage", new String(
					"User is already deleted or confirmed by another" 
					+ " administrator"));
			return errorPage;
		}

		return modelAndView;
	}

	/**
	 * @param dao sets from applicationContent
	 */
	public void setAdminsDAO(final AbstractAdministratorDAO dao) {
		this.adminsDAO = dao;
	}

	/**
	 * @param dao sets from applicationContent
	 */
	public void setPowerUserDAO(final AbstractPowerUserDAO dao) {
		this.powerUserDAO = dao;
	}

	/**
	 * @param request HTTP request
	 * @throws AddressException exception in address of mail
	 * @throws MessagingException exception in mail
	 */
	
	public final void makeChanges(HttpServletRequest request)
			throws AddressException, MessagingException {
		String button = request.getParameter("control");
		//String role = request.getParameterNames().nextElement().toString()
		//System.out.println("role = "+role);
		String role = "";
		Map map = new HashMap();
		map = request.getParameterMap();
		for (Object obj: map.keySet()) {
			if (!obj.toString().equals("control")) {
			role = obj.toString();
			}
			System.out.println("maps keys = "+obj);						
		}	
		System.out.println("rolemap = "+role);
		String[] toDelete = request.getParameterValues(role);
		for (int i = 0; i < toDelete.length; i++) {
			if (role.equals("checkedImporters")) {
				if (button.equals("Delete")) {
					PowerUser importer = powerUserDAO.findById(Long
							.parseLong(toDelete[i]));
					powerUserDAO.delete(importer);
				} else {
					PowerUser importer = powerUserDAO.findById(Long
							.parseLong(toDelete[i]));
					importer.setStatus(STATUS);
					powerUserDAO.save(importer);					
				}
			}

			if (role.equals("checkedAdmins")) {
				if (button.equals("Delete")) {
					Administrator admin = adminsDAO.findById(Long
							.parseLong(toDelete[i]));
					adminsDAO.delete(admin);
				} else {
					Administrator admin = adminsDAO.findById(Long
							.parseLong(toDelete[i]));
					admin.setStatus(STATUS);
					adminsDAO.save(admin);					
				}
			}
		}
	}
}
