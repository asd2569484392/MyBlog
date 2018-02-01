package xyz.yangchaojie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import xyz.yangchaojie.entity.Blog;
import xyz.yangchaojie.entity.Transform;

/***
 * 博客业务层
 * @see BlogServiceImpl
 * @author 杨超杰
 *
 */
public interface BlogService {
	/***
	 * 
	 * @param reuest 当前请求
	 * @param blog_title 博客标题
	 * @param blog_intro 博客简介
	 * @param blog_keyword 博客标签
	 * @param blog_content 博客内容
	 */
	public void insertNewBlog(HttpServletRequest reuest,String blog_title,String blog_intro,String blog_keyword,
			String blog_content);
	/***
	 * 博客分页内部实现，返回控制层需要的AttributeMAP集合
	 * @param request
	 * @return MAP
	 */
	public Map<String, Object> getBlogAttribute(HttpServletRequest request,String tag);
	
	/***
	 * 获取博客图片路径
	 * @return BLOGPATH
	 */
	public String getBlogPath();
	/***
	 * 获取博客
	 * @param id
	 * @return Blog
	 */
	public Blog getBlog(int id);
	/***
	 * 更新博客
	 * @param transform
	 */
	public void updateBlog(Transform transform);
	/***
	 * 删除博客
	 * @param id
	 * @return
	 */
	public void deleteBlog(String PROJECTPATH,int id);
}
