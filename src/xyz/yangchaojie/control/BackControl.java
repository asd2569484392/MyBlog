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
 * ��̨���Ʋ�
 * 
 * @author ���
 */
@Controller
@RequestMapping("back")
public class BackControl {
	/***
	 * ��̨��ҳҵ���
	 */
	@Resource
	BackIndexService backIndexService;
	/***
	 * ����ҵ���
	 */
	@Resource
	ArticleService articleService;
	/***
	 * ����ҵ���
	 */
	@Resource
	BlogService blogService;
	/***
	 * ���ҵ���
	 */
	@Resource
	InformalEssayService informalEssayService;
	/***
	 * �ݸ�ҵ���
	 */
	@Resource
	DraftsService draftsService;
	/***
	 * ��־ҵ���
	 */
	@Resource
	ShowLogService logService;
	/***
	 * ����ҵ���
	 */
	@Resource
	CalenderService calenderService;
	/***
	 * ͼƬ���·��
	 */
	private final String IMGPATH = "images/";
	/***
	 * ȫ�ֱ��������ڴ��log��־������
	 */
	public static int LineNumber = 0;
	/***
	 * ȫ�ֱ���,���ڴ��log��־������
	 */
	public static String logName = null;
	
	/***
	 * 
	 * @param request
	 *            ��ǰ����
	 * @return ������ҳ��:��������,���������������������ݸ�����
	 */
	@RequestMapping("index_getSumList_Ajax")
	@ResponseBody
	public String getSumList(HttpServletRequest request) {
		return backIndexService.backIndex_getSumList(request);
	}

	/***
	 * 
	 * @return ���غ�̨��ҳindex.jsp,����,����,�ݸ�����������JSON����
	 */
	@RequestMapping(value = "index_getTableList_Ajax", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getTableList() {
		return backIndexService.backIndex_getTableList();
	}

	/***
	 * ͼƬ�ϴ�
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
	 * �����������
	 * 
	 * @param file
	 *            :ͼƬ
	 * @param request
	 *            :��ǰ����
	 * @param title
	 *            :����
	 * @param intro
	 *            :���
	 * @param keyword
	 *            :�ؼ���
	 * @param type
	 *            :����
	 * @param editor1
	 *            :����
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
	 * ���·�ҳ
	 * 
	 * @param request
	 *            ��ǰ����
	 * @param m
	 *            ģ��
	 * @return ��ͼ
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
	 * ���ͷ�ҳ
	 * 
	 * @param request
	 *            ��ǰ����
	 * @param m
	 *            ģ��
	 * @return ��ͼ
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
	 * ��ʷ�ҳ
	 * 
	 * @param request
	 *            ��ǰ����
	 * @param m
	 *            ģ��
	 * @return ��ͼ
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
	 * �ݸ��ҳ
	 * 
	 * @param request
	 *            ��ǰ����
	 * @param m
	 *            ģ��
	 * @return ��ͼ
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
	 * ��ѯ���£�������ת��Ϊͨ��Transform���ͷ���
	 * 
	 * @param m
	 *            ģ��
	 * @param id
	 *            ����id
	 * @return ������ͼ
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

	// һ�γɹ���д��ע����ףһ��
	/***
	 * �޸�
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
	 * ��ѯ���ͣ�������ת��Ϊͨ��Transform���ͷ���
	 * 
	 * @param m
	 *            ģ��
	 * @param id
	 *            ����id
	 * @return ������ͼ
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
	 * ��ѯ��ʣ������ת��Ϊͨ��Transform���ͷ���
	 * 
	 * @param m
	 *            ģ��
	 * @param id
	 *            ���id
	 * @return ������ͼ
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
	 * ��ѯ�ݸ壬���ݸ�ת��Ϊͨ��Transform���ͷ���
	 * 
	 * @param m
	 *            ģ��
	 * @param id
	 *            �ݸ�id
	 * @return ������ͼ
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
	 * ɾ������
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
	 * ɾ������
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
	 * ɾ�����
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
	 * ɾ���ݸ�
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
	 * ��ȡlog��־
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
	 * ɾ����¼��Ϣ
	 * @param request
	 * @return
	 */
	@RequestMapping("loginOut")
	public String removeSession(HttpServletRequest request){
		request.getSession().removeAttribute("LoginOK");
		return "Login/Login";
		
	}
	/***
	 * ��ѯȫ�����Բ�ת��
	 * @param m
	 * @return
	 */
	@RequestMapping("readCalender")
	public String readCalender(Model m){
		m.addAttribute("calenderList", calenderService.getCalenderAll());
		return "/Back/Calender";
	}
}
