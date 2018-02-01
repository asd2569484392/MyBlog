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
 * @see BlogService ��ʵ����
 * @author ���
 * 
 */
@Service
public class BlogServiceImpl implements BlogService {

	// ����ͼƬ���·��
	public static final String BLOGIMGPATH = "BlogImg/";
	/***
	 * ע�벩�ͳ־ò�
	 */
	@Resource
	BlogDAO blogDAO;

	@Override
	public void insertNewBlog(HttpServletRequest reuest, String blog_title,
			String blog_intro, String blog_keyword, String blog_content) {
		try {
			// ͼƬ�ϴ�
			String imgName = ImageUploadUtil.upload(reuest, BLOGIMGPATH);
			blogDAO.insertNewBlog(new Blog(0, blog_title, blog_intro,
					blog_content, "���", TimeUtil.getMM_yyyy(), imgName,
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
		// ��ǰҳ
		int page;

		if (p == null) {
			page = 1;
		} else {
			page = Integer.parseInt(p);
		}
		// ÿҳ����Ϊ8
		int size = 8;

		// ��ȡ��������
		int count = blogDAO.getBlogSum();

		// ��ҳ��
		int pageCount;

		if (count % size == 0) {
			pageCount = count / 8;
		} else {
			pageCount = count / 8 + 1;
		}
		List<Blog> blogList;
		// ��ȡ��ǰ��ҳ����
		if(tag==null){
			blogList = blogDAO.getBlogList_Page((page - 1) * size, size);
		// ʹ��MAP���Ͻ���Ҫ���ص��������
		}else{
			blogList = blogDAO.getBlogByTag(tag, (page - 1) * size, size);
		}
		Map<String, Object> Map = new HashMap<String, Object>();
		// ������¼���
		Map.put("BlogList", blogList);
		// �����ҳ��
		Map.put("PageCount", pageCount);
		// ��ӵ�ǰҳ��
		Map.put("CurrentPageNum", page);
		// ����MAP
		return Map;
	}
	
	//���ز���ͼƬ���·��
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
			System.out.println("ɾ�����ͳɹ�!\t"+"��ǰ����idΪ:"+id+"\nͼƬ��Ϊ:"+img);
		}
		blogDAO.removeBlog(id);
	}

}
