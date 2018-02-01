package xyz.yangchaojie.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import xyz.yangchaojie.dao.BlogDAO;
import xyz.yangchaojie.entity.Blog;
import xyz.yangchaojie.entity.Transform;
import xyz.yangchaojie.util.ImageUploadUtil;
import xyz.yangchaojie.util.TimeUtil;

/***
 * @see BlogService 的实现类
 * @author 杨超杰
 * 
 */
@Service
public class BlogServiceImpl implements BlogService {

	// 博客图片存放路径
	public static final String BLOGIMGPATH = "BlogImg/";
	/***
	 * 注入博客持久层
	 */
	@Resource
	BlogDAO blogDAO;

	@Override
	public void insertNewBlog(HttpServletRequest reuest, String blog_title,
			String blog_intro, String blog_keyword, String blog_content) {
		try {
			// 图片上传
			String imgName = ImageUploadUtil.upload(reuest, BLOGIMGPATH);
			blogDAO.insertNewBlog(new Blog(0, blog_title, blog_intro,
					blog_content, "杨超杰", TimeUtil.getMM_yyyy(), imgName,
					blog_keyword));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> getBlogAttribute(HttpServletRequest request,String tag) {
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
		int count = blogDAO.getBlogSum();

		// 总页数
		int pageCount;

		if (count % size == 0) {
			pageCount = count / 8;
		} else {
			pageCount = count / 8 + 1;
		}
		List<Blog> blogList;
		// 获取当前分页集合
		if(tag==null){
			blogList = blogDAO.getBlogList_Page((page - 1) * size, size);
		// 使用MAP集合将需要返回的数据添加
		}else{
			blogList = blogDAO.getBlogByTag(tag, (page - 1) * size, size);
		}
		Map<String, Object> Map = new HashMap<String, Object>();
		// 添加文章集合
		Map.put("BlogList", blogList);
		// 添加总页数
		Map.put("PageCount", pageCount);
		// 添加当前页数
		Map.put("CurrentPageNum", page);
		// 返回MAP
		return Map;
	}
	
	//返回博客图片存放路径
	@Override
	public String getBlogPath() {
		return BLOGIMGPATH;
	}
	
	
	@Override
	public Blog getBlog(int id) {
		return blogDAO.getBlog(id);
	}

	@Override
	public void updateBlog(Transform transform) {
		blogDAO.updateBlog(new Blog(Integer.parseInt(transform.getId()),
				transform.getTitle(), transform.getIntro(), transform
						.getContent(), transform.getKeyword()));
	}

	@Override
	public void deleteBlog(String PROJECTPATH, int id) {
		String imgName = "\\"+blogDAO.getBlogPhotoName(id);
		File img = new File(PROJECTPATH+imgName);
		if(img.exists()){
			img.delete();
			System.out.println("删除博客成功!\t"+"当前博客id为:"+id+"\n图片名为:"+img);
		}
		blogDAO.removeBlog(id);
	}

}
