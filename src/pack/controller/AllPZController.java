package pack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.abstractdao.AbstractPZDAO;
import pack.abstractdao.AbstractStorageDAO;
import pack.pojo.PZ;
import pack.pojo.Storage;

public class AllPZController implements Controller {
	
	private AbstractPZDAO pzDAO;
	public void setPzDAO(AbstractPZDAO pzDAO) {
		this.pzDAO = pzDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		List<PZ> one = pzDAO.findByProperty("scale", "one");
		List<PZ> small = pzDAO.findByProperty("scale", "small");
		List<PZ> big = pzDAO.findByProperty("scale", "big");				
		ModelAndView mav = new ModelAndView("/WEB-INF/jsp/allPZ.jsp");
		mav.addObject("one", one);
		mav.addObject("small", small);
		mav.addObject("big", big);		
		return mav;
	}
}
