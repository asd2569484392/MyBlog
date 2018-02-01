package xyz.yangchaojie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import xyz.yangchaojie.entity.Blog;
import xyz.yangchaojie.entity.Transform;

/***
 * ����ҵ���
 * @see BlogServiceImpl
 * @author ���
 *
 */
public interface BlogService {
	/***
	 * 
	 * @param reuest ��ǰ����
	 * @param blog_title ���ͱ���
	 * @param blog_intro ���ͼ��
	 * @param blog_keyword ���ͱ�ǩ
	 * @param blog_content ��������
	 */
	public void insertNewBlog(HttpServletRequest reuest,String blog_title,String blog_intro,String blog_keyword,
			String blog_content);
	/***
	 * ���ͷ�ҳ�ڲ�ʵ�֣����ؿ��Ʋ���Ҫ��AttributeMAP����
	 * @param request
	 * @return MAP
	 */
	public Map<String, Object> getBlogAttribute(HttpServletRequest request,String tag);
	
	/***
	 * ��ȡ����ͼƬ·��
	 * @return BLOGPATH
	 */
	public String getBlogPath();
	/***
	 * ��ȡ����
	 * @param id
	 * @return Blog
	 */
	public Blog getBlog(int id);
	/***
	 * ���²���
	 * @param transform
	 */
	public void updateBlog(Transform transform);
	/***
	 * ɾ������
	 * @param id
	 * @return
	 */
	public void deleteBlog(String PROJECTPATH,int id);
}
