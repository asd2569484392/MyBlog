package xyz.yangchaojie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import xyz.yangchaojie.entity.Article;
import xyz.yangchaojie.entity.Transform;


/***
 * ����ҵ���ӿ�
 * @see ArticleServiceImpl ʵ��
 * @author ���
 *
 */
public interface ArticleService {
	/**
	 * �������
	 * 
	 */
	
	
	public void insertNewArticle(HttpServletRequest request,
			String article_title,String article_intro,String article_keyword,
			String article_content);
	
	/***
	 * ���·�ҳ����
	 * @return MAP������ʽ��List���ϣ�����ҳ�͵�ǰҳ
	 */
	public Map<String,Object> getArticleAttribute(HttpServletRequest request,String tag);
	/***
	 * ��ȡ����ͼƬ·��
	 * @return PATH
	 */
	public String getArticlePath();
	/***
	 * ��ȡ����
	 * @return
	 */
	public Article getArticle(int id);
	/***
	 * ��������
	 * @param transform �м��� 
	 */
	public void updateArticle(Transform transfrom);
	/***
	 *ɾ������
	 * @param PROJECTPATH ����·��
	 * @param id
	 */
	public void deleteArticle(String PROJECTPATH,int id);
	
}
