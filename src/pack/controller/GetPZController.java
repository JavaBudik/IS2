package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.abstractdao.AbstractControlDAO;
import pack.abstractdao.AbstractManipulationDAO;
import pack.abstractdao.AbstractPZDAO;
import pack.pojo.PZ;


public class GetPZController implements Controller {
	private AbstractPZDAO pzDAO;
	private AbstractManipulationDAO manipulationDAO;
	private AbstractControlDAO controlDAO;
	
	public void setPzDAO(AbstractPZDAO pzDAO) {
		this.pzDAO = pzDAO;
	}
	public void setManipulationDAO(AbstractManipulationDAO manipulationDAO) {
		this.manipulationDAO = manipulationDAO;
	}
	public void setControlDAO(AbstractControlDAO controlDAO) {
		this.controlDAO = controlDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		Long id = Long.parseLong(req.getParameter("str"));
		PZ pz = pzDAO.findById(id);
		String copy = pz.getManipulation().getCopy();
		String cipher = pz.getManipulation().getCipher();
		String compress = pz.getManipulation().getCompress();
		String report = pz.getControl().getReport();
		String validation = pz.getControl().getValidation();
		String log = pz.getControl().getLog();
		String monitoring = pz.getControl().getMonitoring();
		ModelAndView mav = new ModelAndView("/WEB-INF/jsp/pz_info.jsp");
		mav.addObject("pz", pz);
		mav.addObject("copy", copy);
		mav.addObject("cipher", cipher);
		mav.addObject("compress", compress);
		mav.addObject("report", report);
		mav.addObject("validation", validation);
		mav.addObject("log", log);
		mav.addObject("monitoring", monitoring);		
		return mav;
	}

}
