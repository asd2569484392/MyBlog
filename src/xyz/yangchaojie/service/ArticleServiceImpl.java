package xyz.yangchaojie.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import xyz.yangchaojie.dao.ArticleDAO;
import xyz.yangchaojie.entity.Article;
import xyz.yangchaojie.entity.Transform;
import xyz.yangchaojie.util.ImageUploadUtil;
import xyz.yangchaojie.util.TimeUtil;

/***
 * @see ArticleService 的实现类
 * @author 杨超杰
 * 
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	/***
	 * 注入文章持久层接口
	 */
	@Resource
	ArticleDAO articleDAO;

	/**
	 * 文章路径
	 */
	public static final String ARTICLEIMGPATH = "ArticleImg/";

	/***
	 * 
	 * @param request
	 *            当前请求
	 * @param article_title
	 *            文章标题
	 * @param article_intro
	 *            文章简介
	 * @param article_keyword
	 *            文章标签
	 * @param article_content
	 *            文章内容
	 */
	public void insertNewArticle(HttpServletRequest request,
			String article_title, String article_intro, String article_keyword,
			String article_content) {

		try {
			// 图片上传并返回图片名称
			String imgName = ImageUploadUtil.upload(request, ARTICLEIMGPATH);
			// 添加
			articleDAO.insertNewArticle(new Article(0, article_title,
					article_intro, article_content, "杨超杰", TimeUtil
							.getMM_yyyy(), imgName, article_keyword));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Map<String, Object> getArticleAttribute(HttpServletRequest request,String tag) {
		String p = request.getParameter("p");
		// 当前页
		int page;

		if (p == null) {
			page = 1;
		} else {
			page = Integer.parseInt(p);
		}
		// 每页长度为8
		int size = 8;

		// 获取文章总数
		int count = articleDAO.getArticleSum();

		// 总页数
		int pageCount;

		if (count % size == 0) {
			pageCount = count / 8;
		} else {
			pageCount = count / 8 + 1;
		}
		// 获取当前分页集合
		List<Article> articleList;
		if(tag==null){
			articleList = articleDAO.getArticleList_Page((page - 1)
				* size, size);
		}else{
			articleList = articleDAO.getArticleListByTag(tag, (page-1)*size, size);
		}
		// 使用MAP集合将需要返回的数据添加
		Map<String, Object> Map = new HashMap<String, Object>();
		// 添加文章集合
		Map.put("AritcleList", articleList);
		// 添加总页数
		Map.put("PageCount", pageCount);
		// 添加当前页数
		Map.put("CurrentPageNum", page);
		// 返回MAP
		return Map;
	}

	@Override
	public String getArticlePath() {
		return ARTICLEIMGPATH;
	}

	@Override
	public Article getArticle(int id) {
		return articleDAO.getArticleById(id);
	}

	@Override
	public void updateArticle(Transform transfrom) {
		articleDAO.UpdataArticle(new Article(
				Integer.parseInt(transfrom.getId()), transfrom.getTitle(),
				transfrom.getIntro(), transfrom.getContent(), transfrom
						.getKeyword()));
	}

	@Override
	public void deleteArticle(String PROJECTPATH, int id) {
		String imgName = "\\"+articleDAO.getArticlePhotoName(id);
		File img = new File(PROJECTPATH+imgName);
		if(img.exists()){
			img.delete();
			System.out.println("删除成功!\t"+"当前文章id为:"+id+"\n图片名为:"+img);
		}
		articleDAO.removeArticle(id);
	}
	
}