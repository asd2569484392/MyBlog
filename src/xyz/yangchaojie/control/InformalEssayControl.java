package xyz.yangchaojie.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.yangchaojie.service.InformalEssayService;

/***
 * ���ǰ̨չʾ���Ʋ�
 * 
 * @author ���
 * 
 */
@Controller
@RequestMapping("informalEssayControl")
public class InformalEssayControl {
	/**
	 * ע�����ҵ���
	 */
	@Resource
	InformalEssayService informalEssayService;

	@RequestMapping("informalEssayPage")
	public String informalEssayPage(Model m, HttpServletRequest request) {
		Map<String, Object> informalEssayeMap = informalEssayService
				.getInformalEssayAttribute(request, request.getParameter("tag"));
		m.addAttribute("informalEssayList",
				informalEssayeMap.get("InformalEssayList"));
		m.addAttribute("pageCount", informalEssayeMap.get("PageCount"));
		m.addAttribute("currentPageNum",
				informalEssayeMap.get("CurrentPageNum"));
		return "Blog/informalEssay";

	}

	@RequestMapping("readInformalEssay")
	public String readInformalEssay(Model m, HttpServletRequest request) {
		m.addAttribute("informalEssay", informalEssayService
				.getInformalEssay(Integer.valueOf(request.getParameter("id"))));
		return "/Blog/readInformalEssay";

	}
}
