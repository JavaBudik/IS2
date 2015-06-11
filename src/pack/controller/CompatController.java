package pack.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.abstractdao.AbstractCompatibilityDAO;
import pack.abstractdao.AbstractPZDAO;
import pack.abstractdao.AbstractStorageDAO;
import pack.pojo.Compat;
import pack.pojo.Compatibility;
import pack.pojo.PZ;
import pack.pojo.Storage;

public class CompatController implements Controller {
	private AbstractStorageDAO storageDAO;
	private AbstractPZDAO pzDAO;
	private AbstractCompatibilityDAO compatibilityDAO;
	

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Compatibility> compat = compatibilityDAO.findAll();
		List<Compat> list = new ArrayList<Compat>();		
		for (Compatibility comp: compat) {
			Compat temp = new Compat();
			temp.setPzId(comp.getPz().getPzId());
			temp.setPzName(comp.getPz().getName());
			temp.setStorageId(comp.getStorage().getIdStorage());
			temp.setStorageName(comp.getStorage().getName());
			temp.setCompatibility(comp.getCompatibility());
			list.add(temp);
		}
		ModelAndView mav = new ModelAndView("/WEB-INF/jsp/compat.jsp");
		mav.addObject("compat", list);

		return mav;
	}


	public void setStorageDAO(AbstractStorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}


	public void setPzDAO(AbstractPZDAO pzDAO) {
		this.pzDAO = pzDAO;
	}


	public void setCompatibilityDAO(AbstractCompatibilityDAO compatibilityDAO) {
		this.compatibilityDAO = compatibilityDAO;
	}

}
