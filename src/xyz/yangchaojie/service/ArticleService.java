package xyz.yangchaojie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import xyz.yangchaojie.entity.Article;
import xyz.yangchaojie.entity.Transform;


/***
 * 文章业务层接口
 * @see ArticleServiceImpl 实现
 * @author 杨超杰
 *
 */
public interface ArticleService {
	/**
	 * 添加文章
	 * 
	 */
	
	
	public void insertNewArticle(HttpServletRequest request,
			String article_title,String article_intro,String article_keyword,
			String article_content);
	
	/***
	 * 文章分页功能
	 * @return MAP集合形式的List集合，多少页和当前页
	 */
	public Map<String,Object> getArticleAttribute(HttpServletRequest request,String tag);
	/***
	 * 获取文章图片路径
	 * @return PATH
	 */
	public String getArticlePath();
	/***
	 * 获取文章
	 * @return
	 */
	public Article getArticle(int id);
	/***
	 * 更新文章
	 * @param transform 中间类 
	 */
	public void updateArticle(Transform transfrom);
	/***
	 *删除文章
	 * @param PROJECTPATH 工程路径
	 * @param id
	 */
	public void deleteArticle(String PROJECTPATH,int id);
	
}
