package pack.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.abstractdao.AbstractAdministratorDAO;
import pack.abstractdao.AbstractLowUserDAO;
import pack.abstractdao.AbstractPowerUserDAO;
import pack.pojo.Administrator;
import pack.pojo.LowUser;
import pack.pojo.PowerUser;

public class DeleteUsersController implements Controller {
	private final static String STATUS = "Deleted";
	AbstractAdministratorDAO adminsDAO = null;
	AbstractLowUserDAO lowUserDAO = null;
	AbstractPowerUserDAO powerUserDAO = null;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(
				"redirect:admin_view_users.htm");
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
			if (role.equals("checkedCustomers")) {
				LowUser customer = lowUserDAO.findById(Long
						.parseLong(toDelete[i]));
				lowUserDAO.delete(customer);				
			}			
			if (role.equals("checkedImporters")) {
				PowerUser importer = powerUserDAO.findById(Long
						.parseLong(toDelete[i]));
				powerUserDAO.delete(importer);				
			}
			if (role.equals("checkedAdmins")) {
				Administrator admin = adminsDAO.findById(Long
						.parseLong(toDelete[i]));
				adminsDAO.delete(admin);				
			}
		}
		return modelAndView;
	}

	public void setLowUserDAO(AbstractLowUserDAO customersDAO) {
		this.lowUserDAO = customersDAO;
	}	
	public void setPowerUserDAO(AbstractPowerUserDAO importersDAO) {
		this.powerUserDAO = importersDAO;
	}
	public void setAdminsDAO(AbstractAdministratorDAO adminsDAO) {
		this.adminsDAO = adminsDAO;
	}
}
