package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.abstractdao.AbstractStorageDAO;
import pack.pojo.Storage;

public class GetStorageController implements Controller {
	private AbstractStorageDAO storageDAO;
	public void setStorageDAO(AbstractStorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		Long id = Long.parseLong(req.getParameter("str"));
		Storage storage = storageDAO.findById(id);
		ModelAndView mav = new ModelAndView("/WEB-INF/jsp/storage_info.jsp");
		mav.addObject("storage", storage);
		return mav;
	}

}
