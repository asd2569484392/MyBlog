package xyz.yangchaojie.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.yangchaojie.service.BlogService;
/***
 * 
 * @author ���Ϳ��Ʋ㣬ǰ̨չʾ
 *
 */
@Controller
@RequestMapping("blogControl")
public class BlogControl {
	/***
	 * ע�벩��ҵ���
	 */
	@Resource
	BlogService blogService;
	/***
	 * ��ȡ��ǰ���ͷ�ҳ
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping("blogPage")
	public String blogPage(Model m,HttpServletRequest request){
		Map<String, Object> blogPageMap = blogService.getBlogAttribute(request,request.getParameter("tag"));
		m.addAttribute("blogList", blogPageMap.get("BlogList"));
		m.addAttribute("pageCount", blogPageMap.get("PageCount"));
		m.addAttribute("currentPageNum", blogPageMap.get("CurrentPageNum"));
		return "Blog/technologyBlog";
	}
	/***
	 * ����id��ѯ���Ͳ�չʾ
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping("readBlog")
	public String readBlog(Model m,HttpServletRequest request){
		m.addAttribute("blog",blogService.getBlog(Integer.valueOf(request.getParameter("id"))));
		return "/Blog/readBlog";
		
		
	}
}
