package pack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.abstractdao.AbstractStorageDAO;
import pack.abstractdao.AbstractUserDAO;
import pack.pojo.Storage;

public class AllStorageController implements Controller {
	
	private AbstractStorageDAO storageDAO;
	public void setStorageDAO(AbstractStorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		List<Storage> ssd = storageDAO.findByProperty("type", "SSD");
		List<Storage> hdd = storageDAO.findByProperty("type", "HDD");
		List<Storage> odd = storageDAO.findByProperty("type", "ODD");
		List<Storage> mdd = storageDAO.findByProperty("type", "MDD");		
		ModelAndView mav = new ModelAndView("/WEB-INF/jsp/allStorage.jsp");
		mav.addObject("ssd", ssd);
		mav.addObject("hdd", hdd);
		mav.addObject("odd", odd);
		mav.addObject("mdd", mdd);
		return mav;
	}
}
