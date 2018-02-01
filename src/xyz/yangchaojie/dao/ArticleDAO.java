package xyz.yangchaojie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.Article;

	/**
	 *文章持久层接口 
	 * @author 杨超杰
	 *
	 */
public interface ArticleDAO {
	/**
	 * <b>获取文章总数</b> 
	 * @return 返回文章总数
	 */
	public int getArticleSum();
	/**
	 * <p>添加文章</p>
	 * @param 传入文章类型
	 * @return 返回Boolean类型，添加成功或失败
	 */
	public boolean insertNewArticle(Article article);
	/**
	 * <b>删除文章</b>
	 * @param id 根据id删除文章
	 * @return 返回Boolean类型，删除成功或失败
	 */
	public boolean removeArticle(int id);
	/**
	 * <b>更新文章</b>
	 * @param article传入文章类型
	 * @return 返回文章是否修改成功
	 */
	public boolean UpdataArticle(Article article);
	/***
	 * 
	 * @return 返回数据库倒序截取ID最大的三条数据集合
	 */
	public List<Article> getThreeRecentArticles();
	/***
	 * 获取分页后的文章集合
	 * @param pageNow 现在的页数
	 * @param size 分页长度
	 * @return 返回文章分页后的集合
	 */
	public List<Article> getArticleList_Page(@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * 根据id查询文章
	 * @param id 
	 * @return 文章
	 */
	public Article getArticleById(int id);
	/***
	 * 获取图片名称
	 * @param id
	 */
	public String getArticlePhotoName(int id);
	/***
	 * 根据标签查询
	 * @param tag
	 * @return
	 */
	public List<Article> getArticleListByTag(@Param("tag")String tag,@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * 用于主页，随机获取一条数据
	 * @return
	 */
	public Article getRandomArticle();
}
