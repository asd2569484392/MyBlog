package xyz.yangchaojie.control;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.yangchaojie.service.ArticleService;
/***
 * 
 * @author 文章展示
 *
 */
@Controller
@RequestMapping("articleControl")
public class ArticleControl {
	/***
	 * 注入文章业务层
	 */
	@Resource
	ArticleService articleService;
	/***
	 * 获取当前页面内容
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping("articlePage")
	public String articlePage(Model m,HttpServletRequest request){
		Map<String, Object> articlePageMap = articleService
				.getArticleAttribute(request,request.getParameter("tag"));
		m.addAttribute("articleList", articlePageMap.get("AritcleList"));
		m.addAttribute("pageCount", articlePageMap.get("PageCount"));
		m.addAttribute("currentPageNum", articlePageMap.get("CurrentPageNum"));
		
		
		return "Blog/article";
		
	}
	/***
	 * 获取阅读的文章
	 */
	@RequestMapping("readArticle")
	public String readArticle(Model m,HttpServletRequest request){
		m.addAttribute("article", articleService.getArticle(Integer.valueOf(request.getParameter("id"))));
		
		return "Blog/readArticle";
		
	}
}
