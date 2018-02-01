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
 * @author 博客控制层，前台展示
 *
 */
@Controller
@RequestMapping("blogControl")
public class BlogControl {
	/***
	 * 注入博客业务层
	 */
	@Resource
	BlogService blogService;
	/***
	 * 获取当前博客分页
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
	 * 根据id查询博客并展示
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
