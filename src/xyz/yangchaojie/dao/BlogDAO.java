package xyz.yangchaojie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.Blog;
/***
 * 博客持久层
 * @author 杨超杰
 *
 */
public interface BlogDAO {
	
	/**
	 * 获取博客总数
	 * @return 返回博客总数
	 */
	public int getBlogSum();
	/***
	 * 
	 * @return 返回数据库倒序截取ID最大的三条数据集合
	 */
	public List<Blog> getThreeRecentBlogs();
	
	/***
	 * 添加博客
	 * @param blog
	 */
	public void insertNewBlog(Blog blog);
	/***
	 * 获取分页后的博客集合
	 * @param pageNow 现在的页数
	 * @param size 分页长度
	 * @return 返回博客分页后的集合
	 */
	public List<Blog> getBlogList_Page(@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * 根据id查询博客
	 * @param id 
	 * @return 博客
	 */
	public Blog getBlog(int id);
	/***
	 * 更新文章
	 * @param blog
	 */
	public void updateBlog(Blog blog);
	/**
	 * 删除博客
	 */
	public void removeBlog(int id);
	/***
	 * 获取图片名称
	 * @param id
	 * @return 
	 */
	public String getBlogPhotoName(int id);
	/***
	 * 根据标签查询
	 * @param tag
	 * @return
	 */
	public List<Blog> getBlogByTag(@Param("tag")String tag,@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * 获取随机的一个博客
	 * @return
	 */
	public Blog getRnadomBlog();
}
