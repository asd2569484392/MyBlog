package xyz.yangchaojie.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import xyz.yangchaojie.dao.ArticleDAO;
import xyz.yangchaojie.dao.BlogDAO;
import xyz.yangchaojie.dao.DraftsDAO;
import xyz.yangchaojie.dao.InformalEssayDAO;
import xyz.yangchaojie.entity.InformalEssay;
import xyz.yangchaojie.entity.SumList;
import xyz.yangchaojie.entity.TableList;

import com.google.gson.Gson;
/**
 * @see BackIndexServiceImpl ��ʵ����
 * 
 * @author ���
 *
 */
@Service
public class BackIndexServiceImpl implements BackIndexService{
	/***
	 * ע�����³־ò�
	 */
	@Resource
	ArticleDAO articleDAO;
	/***
	 * ע�벩�ͳ־ò�
	 */
	@Resource
	BlogDAO blogDAO;
	/***
	 * ע��ݸ�־ò�
	 */
	@Resource
	DraftsDAO draftsDAO;
	/***
	 * ע����ʳ־ò�
	 */
	@Resource
	InformalEssayDAO informalEssayDAO;
	/***
	 * @see BackIndexService
	 * @param request 
	 * @return
	 */
	
	@Override
	public String backIndex_getSumList(HttpServletRequest request) {
		//IP����
		int ipSum = 0;
		//��ȡServletContextȫ�ֶ���
		ServletContext context = request.getServletContext();
		// ��ȡSessionAttribute,����MAP����
		Map<String, Integer> ipMap = (Map<String, Integer>) context.getAttribute("ipMap");
		// ʹ�õ���������IP����
		Iterator<Entry<String, Integer>> it = ipMap.entrySet().iterator();
		//ѭ���������������������ipSum
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			ipSum = entry.getValue();
		}
		//��ȡGSON
		Gson gson = new Gson();
		/***
		 * ����SumList������(name,number)
		 */
		SumList sl;
		//new��ArrayList���ϣ�����ΪSumList
		List<SumList> sumList = new ArrayList<SumList>();
		//һ���������ݣ�ѭ���Ĵ�,ÿ��ѭ��newһ��SumList�����Ų�ͬ���͵�����
		for (int i = 0; i < 4; i++) {
			sl = new SumList();
			//��i = 0 ��ǰSumListΪIP�����ݣ�����ӽ�ArrayList
			if (i == 0) {
				sl.setName("ipSum");
				sl.setNumber(ipSum);
				sumList.add(sl);
		    //��i = 1 ��ǰSumListΪ�������������ݣ�����ӽ�ArrayList
			} else if (i == 1) {
				sl.setName("articleSum");
				sl.setNumber(articleDAO.getArticleSum());
				sumList.add(sl);
			//��i = 2 ��ǰSumListΪ�������������ݣ�����ӽ�ArrayList
			} else if (i == 2) {
				sl.setName("blogSum");
				sl.setNumber(blogDAO.getBlogSum());
				sumList.add(sl);
		    //ELSEΪ�ݸ����ݣ�����ӽ�ArrayList
			} else {
				sl.setName("draftsSum");
				sl.setNumber(draftsDAO.getDraftsSum());
				sumList.add(sl);
			}
		}//ѭ������
		// ��List����ת��ΪJSON����
		String sumListJson = gson.toJson(sumList);		
		//����
		return sumListJson;
	}
	
	@Override
	public String backIndex_getTableList() {
		//��ȡGSON
		Gson gson = new Gson();
		TableList tList = new TableList();
		//��������ļ��Ϸֱ����
		tList.setArticleList(articleDAO.getThreeRecentArticles());
		tList.setBlogList(blogDAO.getThreeRecentBlogs());
		tList.setDraftsList(draftsDAO.getThreeRecentDrafts());
		tList.setInformalEssay(informalEssayDAO.getThreeRecentInformalEssays());
		//ת��ΪJSON��ʽ
		String tableList = gson.toJson(tList);	
		//����
		return tableList;
	}

	
	
}
