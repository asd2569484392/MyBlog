package xyz.yangchaojie.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import xyz.yangchaojie.dao.ArticleDAO;
import xyz.yangchaojie.entity.Article;
import xyz.yangchaojie.entity.Transform;
import xyz.yangchaojie.util.ImageUploadUtil;
import xyz.yangchaojie.util.TimeUtil;

/***
 * @see ArticleService ��ʵ����
 * @author ���
 * 
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	/***
	 * ע�����³־ò�ӿ�
	 */
	@Resource
	ArticleDAO articleDAO;

	/**
	 * ����·��
	 */
	public static final String ARTICLEIMGPATH = "ArticleImg/";

	/***
	 * 
	 * @param request
	 *            ��ǰ����
	 * @param article_title
	 *            ���±���
	 * @param article_intro
	 *            ���¼��
	 * @param article_keyword
	 *            ���±�ǩ
	 * @param article_content
	 *            ��������
	 */
	public void insertNewArticle(HttpServletRequest request,
			String article_title, String article_intro, String article_keyword,
			String article_content) {

		try {
			// ͼƬ�ϴ�������ͼƬ����
			String imgName = ImageUploadUtil.upload(request, ARTICLEIMGPATH);
			// ���
			articleDAO.insertNewArticle(new Article(0, article_title,
					article_intro, article_content, "���", TimeUtil
							.getMM_yyyy(), imgName, article_keyword));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Map<String, Object> getArticleAttribute(HttpServletRequest request,String tag) {
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
		int count = articleDAO.getArticleSum();

		// ��ҳ��
		int pageCount;

		if (count % size == 0) {
			pageCount = count / 8;
		} else {
			pageCount = count / 8 + 1;
		}
		// ��ȡ��ǰ��ҳ����
		List<Article> articleList;
		if(tag==null){
			articleList = articleDAO.getArticleList_Page((page - 1)
				* size, size);
		}else{
			articleList = articleDAO.getArticleListByTag(tag, (page-1)*size, size);
		}
		// ʹ��MAP���Ͻ���Ҫ���ص��������
		Map<String, Object> Map = new HashMap<String, Object>();
		// ������¼���
		Map.put("AritcleList", articleList);
		// �����ҳ��
		Map.put("PageCount", pageCount);
		// ��ӵ�ǰҳ��
		Map.put("CurrentPageNum", page);
		// ����MAP
		return Map;
	}

	@Override
	public String getArticlePath() {
		return ARTICLEIMGPATH;
	}

	@Override
	public Article getArticle(int id) {
		return articleDAO.getArticleById(id);
	}

	@Override
	public void updateArticle(Transform transfrom) {
		articleDAO.UpdataArticle(new Article(
				Integer.parseInt(transfrom.getId()), transfrom.getTitle(),
				transfrom.getIntro(), transfrom.getContent(), transfrom
						.getKeyword()));
	}

	@Override
	public void deleteArticle(String PROJECTPATH, int id) {
		String imgName = "\\"+articleDAO.getArticlePhotoName(id);
		File img = new File(PROJECTPATH+imgName);
		if(img.exists()){
			img.delete();
			System.out.println("ɾ���ɹ�!\t"+"��ǰ����idΪ:"+id+"\nͼƬ��Ϊ:"+img);
		}
		articleDAO.removeArticle(id);
	}
	
}