package xyz.yangchaojie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.Article;

	/**
	 *���³־ò�ӿ� 
	 * @author ���
	 *
	 */
public interface ArticleDAO {
	/**
	 * <b>��ȡ��������</b> 
	 * @return ������������
	 */
	public int getArticleSum();
	/**
	 * <p>�������</p>
	 * @param ������������
	 * @return ����Boolean���ͣ���ӳɹ���ʧ��
	 */
	public boolean insertNewArticle(Article article);
	/**
	 * <b>ɾ������</b>
	 * @param id ����idɾ������
	 * @return ����Boolean���ͣ�ɾ���ɹ���ʧ��
	 */
	public boolean removeArticle(int id);
	/**
	 * <b>��������</b>
	 * @param article������������
	 * @return ���������Ƿ��޸ĳɹ�
	 */
	public boolean UpdataArticle(Article article);
	/***
	 * 
	 * @return �������ݿ⵹���ȡID�����������ݼ���
	 */
	public List<Article> getThreeRecentArticles();
	/***
	 * ��ȡ��ҳ������¼���
	 * @param pageNow ���ڵ�ҳ��
	 * @param size ��ҳ����
	 * @return �������·�ҳ��ļ���
	 */
	public List<Article> getArticleList_Page(@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * ����id��ѯ����
	 * @param id 
	 * @return ����
	 */
	public Article getArticleById(int id);
	/***
	 * ��ȡͼƬ����
	 * @param id
	 */
	public String getArticlePhotoName(int id);
	/***
	 * ���ݱ�ǩ��ѯ
	 * @param tag
	 * @return
	 */
	public List<Article> getArticleListByTag(@Param("tag")String tag,@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * ������ҳ�������ȡһ������
	 * @return
	 */
	public Article getRandomArticle();
}
