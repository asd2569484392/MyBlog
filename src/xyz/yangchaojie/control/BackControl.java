package xyz.yangchaojie.control;

import java.io.IOException;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import xyz.yangchaojie.entity.Article;
import xyz.yangchaojie.entity.Blog;
import xyz.yangchaojie.entity.Drafts;
import xyz.yangchaojie.entity.InformalEssay;
import xyz.yangchaojie.entity.Transform;
import xyz.yangchaojie.service.ArticleService;
import xyz.yangchaojie.service.BackIndexService;
import xyz.yangchaojie.service.BlogService;
import xyz.yangchaojie.service.CalenderService;
import xyz.yangchaojie.service.DraftsService;
import xyz.yangchaojie.service.InformalEssayService;
import xyz.yangchaojie.service.ShowLogService;
import xyz.yangchaojie.util.ImageUploadUtil;

/***
 * 后台控制层
 * 
 * @author 杨超杰
 */
@Controller
@RequestMapping("back")
public class BackControl {
	/***
	 * 后台主页业务层
	 */
	@Resource
	BackIndexService backIndexService;
	/***
	 * 文章业务层
	 */
	@Resource
	ArticleService articleService;
	/***
	 * 博客业务层
	 */
	@Resource
	BlogService blogService;
	/***
	 * 随笔业务层
	 */
	@Resource
	InformalEssayService informalEssayService;
	/***
	 * 草稿业务层
	 */
	@Resource
	DraftsService draftsService;
	/***
	 * 日志业务层
	 */
	@Resource
	ShowLogService logService;
	/***
	 * 留言业务层
	 */
	@Resource
	CalenderService calenderService;
	/***
	 * 图片存放路径
	 */
	private final String IMGPATH = "images/";
	/***
	 * 全局变量，用于存放log日志的行数
	 */
	public static int LineNumber = 0;
	/***
	 * 全局变量,用于存放log日志的名称
	 */
	public static String logName = null;
	
	/***
	 * 
	 * @param request
	 *            当前请求
	 * @return 返回主页的:请求数量,文章总数，博客总数，草稿总数
	 */
	@RequestMapping("index_getSumList_Ajax")
	@ResponseBody
	public String getSumList(HttpServletRequest request) {
		return backIndexService.backIndex_getSumList(request);
	}

	/***
	 * 
	 * @return 返回后台主页index.jsp,文章,博客,草稿表各三条数据JSON集合
	 */
	@RequestMapping(value = "index_getTableList_Ajax", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getTableList() {
		return backIndexService.backIndex_getTableList();
	}

	/***
	 * 图片上传
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("imgUpload")
	public void imgUpload(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ImageUploadUtil.ckeditor(request, response, IMGPATH);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/***
	 * 根据类型添加
	 * 
	 * @param file
	 *            :图片
	 * @param request
	 *            :当前请求
	 * @param title
	 *            :标题
	 * @param intro
	 *            :简介
	 * @param keyword
	 *            :关键字
	 * @param type
	 *            :类型
	 * @param editor1
	 *            :内容
	 * @return
	 */
	@RequestMapping("insert")
	public String insert(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, String title, String intro,
			String keyword, String type, String editor1, String draft) {
		String flag = draft;
		if (type.equals("Blog") && flag.equals("false")) {
			blogService.insertNewBlog(request, title, intro, keyword, editor1);
			return "";
		} else if (type.equals("InformalEssay") && flag.equals("false")) {
			informalEssayService.insertNewInformalEssay(request, title, intro,
					keyword, editor1);
			return "";
		} else if (type.equals("Article") && flag.equals("false")) {
			articleService.insertNewArticle(request, title, intro, keyword,
					editor1);
			return "";
		} else if (flag.equals("true")) {
			draftsService.insertToDraft(request, title, intro, keyword,
					editor1, type);
		}
		return "";

	}

	/***
	 * 文章分页
	 * 
	 * @param request
	 *            当前请求
	 * @param m
	 *            模型
	 * @return 视图
	 */
	@RequestMapping("articlePage")
	public String articlePage(HttpServletRequest request, Model m) {
		Map<String, Object> articlePageMap = articleService
				.getArticleAttribute(request,null);
		m.addAttribute("articleList", articlePageMap.get("AritcleList"));
		m.addAttribute("pageCount", articlePageMap.get("PageCount"));
		m.addAttribute("currentPageNum", articlePageMap.get("CurrentPageNum"));

		return "Back/articleTable";
	}

	/***
	 * 博客分页
	 * 
	 * @param request
	 *            当前请求
	 * @param m
	 *            模型
	 * @return 视图
	 */
	@RequestMapping("blogPage")
	public String blogPage(HttpServletRequest request, Model m) {
		Map<String, Object> blogPageMap = blogService.getBlogAttribute(request,null);
		m.addAttribute("blogList", blogPageMap.get("BlogList"));
		m.addAttribute("pageCount", blogPageMap.get("PageCount"));
		m.addAttribute("currentPageNum", blogPageMap.get("CurrentPageNum"));
		return "Back/blogTable";
	}

	/***
	 * 随笔分页
	 * 
	 * @param request
	 *            当前请求
	 * @param m
	 *            模型
	 * @return 视图
	 */
	@RequestMapping("informalEssayPage")
	public String informalEssayPage(HttpServletRequest request, Model m) {
		Map<String, Object> informalEssayeMap = informalEssayService
				.getInformalEssayAttribute(request,null);
		m.addAttribute("informalEssayList",
				informalEssayeMap.get("InformalEssayList"));
		m.addAttribute("pageCount", informalEssayeMap.get("PageCount"));
		m.addAttribute("currentPageNum",
				informalEssayeMap.get("CurrentPageNum"));
		return "Back/informalEssayTable";
	}

	/***
	 * 草稿分页
	 * 
	 * @param request
	 *            当前请求
	 * @param m
	 *            模型
	 * @return 视图
	 */
	@RequestMapping("draftsPage")
	public String draftsPage(HttpServletRequest request, Model m) {
		Map<String, Object> draftsMap = draftsService
				.getDraftsAttribute(request);
		m.addAttribute("draftsList", draftsMap.get("DraftsList"));
		m.addAttribute("pageCount", draftsMap.get("PageCount"));
		m.addAttribute("currentPageNum", draftsMap.get("CurrentPageNum"));
		return "Back/draftsTable";
	}

	/**
	 * 查询文章，将文章转化为通用Transform类型返回
	 * 
	 * @param m
	 *            模型
	 * @param id
	 *            文章id
	 * @return 返回视图
	 */
	@RequestMapping("updateArticle")
	public String updateArticle(Model m, HttpServletRequest request) {
		Article article = articleService.getArticle(Integer.parseInt(request
				.getParameter("id")));
		m.addAttribute(
				"update",
				new Transform(String.valueOf(article.getId()), article
						.getArticle_title(), article.getArticle_intro(),
						article.getArticle_content(), "Article", article
								.getArticle_keyword()));
		return "Back/Update";
	}

	// 一次成功，写个注释庆祝一下
	/***
	 * 修改
	 * 
	 * @param transform
	 * @return
	 */
	@RequestMapping("submitUpdate")
	public String submitUpdateArticle(Transform transform) {
		if (transform.getType().equals("Article")) {
			articleService.updateArticle(transform);
		} else if (transform.getType().equals("Blog")) {
			blogService.updateBlog(transform);
		} else if (transform.getType().equals("InformalEssay")) {
			informalEssayService.updateInformalEssay(transform);
		}else if(transform.getType().equals("Draft")){
			draftsService.updateDraft(transform);
		}
		return "";
	}

	/**
	 * 查询博客，将博客转化为通用Transform类型返回
	 * 
	 * @param m
	 *            模型
	 * @param id
	 *            博客id
	 * @return 返回视图
	 */
	@RequestMapping("UpdateBlog")
	public String UpdateBlog(HttpServletRequest request, Model m) {
		Blog blog = blogService.getBlog(Integer.parseInt(request
				.getParameter("id")));
		m.addAttribute(
				"update",
				new Transform(String.valueOf(blog.getId()), blog
						.getBlog_title(), blog.getBlog_intro(), blog
						.getBlog_content(), "Blog", blog.getBlog_keyword()));
		return "Back/Update";
	}

	/**
	 * 查询随笔，将随笔转化为通用Transform类型返回
	 * 
	 * @param m
	 *            模型
	 * @param id
	 *            随笔id
	 * @return 返回视图
	 */
	@RequestMapping("UpdateInformalEssay")
	public String UpdateInformalEssay(Model m, HttpServletRequest request) {
		InformalEssay informal = informalEssayService.getInformalEssay(Integer
				.parseInt(request.getParameter("id")));
		m.addAttribute(
				"update",
				new Transform(String.valueOf(informal.getId()), informal
						.getInformalessay_title(), informal
						.getInformalessay_intro(), informal
						.getInformalessay_content(), "InformalEssay", informal
						.getInformalessay_keyword()));

		return "Back/Update";

	}
	/**
	 * 查询草稿，将草稿转化为通用Transform类型返回
	 * 
	 * @param m
	 *            模型
	 * @param id
	 *            草稿id
	 * @return 返回视图
	 */
	@RequestMapping("UpdateDraft")
	public String UpdateInformalEssay(HttpServletRequest request, Model m) {
		Drafts draft = draftsService.getDraft(Integer.parseInt(request
				.getParameter("id")));
		m.addAttribute(
				"update",
				new Transform(String.valueOf(draft.getId()), draft
						.getDraft_title(), draft.getDraft_intro(), draft
						.getDraft_content(), "Draft", draft.getDraft_keyword()));

		return "Back/Update";
	}
	
	/***
	 * 删除文章
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping("removeArticle")
	public String removeArticle(HttpServletRequest request){
		String PROJECTPATH = request.getSession().getServletContext().getRealPath("\\ArticleImg");
		articleService.deleteArticle(PROJECTPATH, Integer.parseInt(request.getParameter("id")));
		return "redirect:articlePage.do";
	}
	/***
	 * 删除博客
	 * @param request
	 * @return
	 */
	@RequestMapping("removeBlog")
	public String removeBlog(HttpServletRequest request){
		String PROJECTPATH = request.getSession().getServletContext().getRealPath("\\BlogImg");
		blogService.deleteBlog(PROJECTPATH, Integer.parseInt(request.getParameter("id")));
		return "redirect:blogPage.do";
	}
	
	/***
	 * 删除随笔
	 * @param request
	 * @return
	 */
	@RequestMapping("removeInformalEssay")
	public String removeInformal(HttpServletRequest request){
		String PROJECTPATH = request.getSession().getServletContext().getRealPath("\\InformalEssayImg");
		informalEssayService.deleteInformalEssay(PROJECTPATH, Integer.parseInt(request.getParameter("id")));
		return "redirect:informalEssayPage.do";
	}
	/***
	 * 删除草稿
	 * @param request
	 * @return
	 */
	@RequestMapping("removeDraft")
	public String removeDraft(HttpServletRequest request){
		String PROJECTPATH = request.getSession().getServletContext().getRealPath("\\");
		draftsService.deleteDraft(PROJECTPATH, Integer.parseInt(request.getParameter("id")));
		return "redirect:draftsPage.do";
	}
	/***
	 * 获取log日志
	 * @param request
	 * @return
	 */
	@RequestMapping("getLog4j")
	@ResponseBody
	public String getLog(HttpServletRequest request){
		String PROJECTPATH = request.getSession().getServletContext().getRealPath("\\");
		String tomcatPath = PROJECTPATH.substring(0, PROJECTPATH.indexOf("w"));
		Map<String,Object> logMap = logService.getLog(LineNumber, logName, tomcatPath);
		if(logMap.get("error")==null&&logMap!=null){
			LineNumber = (Integer) logMap.get("lineNumber");
			logName = (String) logMap.get("logPath");
			return (String) logMap.get("content");
		}else{
			
		return (String) logMap.get("error");
		
		}
		
	}
	/**
	 * 删除登录信息
	 * @param request
	 * @return
	 */
	@RequestMapping("loginOut")
	public String removeSession(HttpServletRequest request){
		request.getSession().removeAttribute("LoginOK");
		return "Login/Login";
		
	}
	/***
	 * 查询全部留言并转发
	 * @param m
	 * @return
	 */
	@RequestMapping("readCalender")
	public String readCalender(Model m){
		m.addAttribute("calenderList", calenderService.getCalenderAll());
		return "/Back/Calender";
	}
}
