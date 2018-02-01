package xyz.yangchaojie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.Blog;
/***
 * ���ͳ־ò�
 * @author ���
 *
 */
public interface BlogDAO {
	
	/**
	 * ��ȡ��������
	 * @return ���ز�������
	 */
	public int getBlogSum();
	/***
	 * 
	 * @return �������ݿ⵹���ȡID�����������ݼ���
	 */
	public List<Blog> getThreeRecentBlogs();
	
	/***
	 * ��Ӳ���
	 * @param blog
	 */
	public void insertNewBlog(Blog blog);
	/***
	 * ��ȡ��ҳ��Ĳ��ͼ���
	 * @param pageNow ���ڵ�ҳ��
	 * @param size ��ҳ����
	 * @return ���ز��ͷ�ҳ��ļ���
	 */
	public List<Blog> getBlogList_Page(@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * ����id��ѯ����
	 * @param id 
	 * @return ����
	 */
	public Blog getBlog(int id);
	/***
	 * ��������
	 * @param blog
	 */
	public void updateBlog(Blog blog);
	/**
	 * ɾ������
	 */
	public void removeBlog(int id);
	/***
	 * ��ȡͼƬ����
	 * @param id
	 * @return 
	 */
	public String getBlogPhotoName(int id);
	/***
	 * ���ݱ�ǩ��ѯ
	 * @param tag
	 * @return
	 */
	public List<Blog> getBlogByTag(@Param("tag")String tag,@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * ��ȡ�����һ������
	 * @return
	 */
	public Blog getRnadomBlog();
}
