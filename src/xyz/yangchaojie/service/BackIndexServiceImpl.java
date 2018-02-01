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
 * @see BackIndexServiceImpl 的实现类
 * 
 * @author 杨超杰
 *
 */
@Service
public class BackIndexServiceImpl implements BackIndexService{
	/***
	 * 注入文章持久层
	 */
	@Resource
	ArticleDAO articleDAO;
	/***
	 * 注入博客持久层
	 */
	@Resource
	BlogDAO blogDAO;
	/***
	 * 注入草稿持久层
	 */
	@Resource
	DraftsDAO draftsDAO;
	/***
	 * 注入随笔持久层
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
		//IP总数
		int ipSum = 0;
		//获取ServletContext全局对象
		ServletContext context = request.getServletContext();
		// 获取SessionAttribute,返回MAP集合
		Map<String, Integer> ipMap = (Map<String, Integer>) context.getAttribute("ipMap");
		// 使用迭代器遍历IP数量
		Iterator<Entry<String, Integer>> it = ipMap.entrySet().iterator();
		//循环遍历输出参数，并叠加ipSum
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			ipSum = entry.getValue();
		}
		//获取GSON
		Gson gson = new Gson();
		/***
		 * 声明SumList，属性(name,number)
		 */
		SumList sl;
		//new出ArrayList集合，泛型为SumList
		List<SumList> sumList = new ArrayList<SumList>();
		//一共四条数据，循环四次,每次循环new一个SumList对象存放不同类型的数据
		for (int i = 0; i < 4; i++) {
			sl = new SumList();
			//当i = 0 当前SumList为IP的数据，并添加进ArrayList
			if (i == 0) {
				sl.setName("ipSum");
				sl.setNumber(ipSum);
				sumList.add(sl);
		    //当i = 1 当前SumList为文章数量的数据，并添加进ArrayList
			} else if (i == 1) {
				sl.setName("articleSum");
				sl.setNumber(articleDAO.getArticleSum());
				sumList.add(sl);
			//当i = 2 当前SumList为博客数量的数据，并添加进ArrayList
			} else if (i == 2) {
				sl.setName("blogSum");
				sl.setNumber(blogDAO.getBlogSum());
				sumList.add(sl);
		    //ELSE为草稿数据，并添加进ArrayList
			} else {
				sl.setName("draftsSum");
				sl.setNumber(draftsDAO.getDraftsSum());
				sumList.add(sl);
			}
		}//循环结束
		// 将List集合转化为JSON对象
		String sumListJson = gson.toJson(sumList);		
		//返回
		return sumListJson;
	}
	
	@Override
	public String backIndex_getTableList() {
		//获取GSON
		Gson gson = new Gson();
		TableList tList = new TableList();
		//将三个表的集合分别添加
		tList.setArticleList(articleDAO.getThreeRecentArticles());
		tList.setBlogList(blogDAO.getThreeRecentBlogs());
		tList.setDraftsList(draftsDAO.getThreeRecentDrafts());
		tList.setInformalEssay(informalEssayDAO.getThreeRecentInformalEssays());
		//转化为JSON格式
		String tableList = gson.toJson(tList);	
		//返回
		return tableList;
	}

	
	
}
