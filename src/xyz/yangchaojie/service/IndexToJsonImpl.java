package xyz.yangchaojie.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;


import xyz.yangchaojie.dao.ArticleDAO;
import xyz.yangchaojie.dao.BlogDAO;
import xyz.yangchaojie.dao.InformalEssayDAO;
import xyz.yangchaojie.entity.Article;
import xyz.yangchaojie.entity.Blog;
import xyz.yangchaojie.entity.Index;
import xyz.yangchaojie.entity.InformalEssay;

@Service
public class IndexToJsonImpl implements IndexToJsonService{
	/***
	 * 注入文章dao
	 */
	@Resource
	ArticleDAO articleDAO;
	/**
	 * 注入博客dao
	 */
	@Resource 
	BlogDAO blogDAO;
	//注入随笔dao
	@Resource
	InformalEssayDAO essayDAO;
	
	
	@Override
	public String getIndexDate() {
		List<Index> listIndex = new ArrayList<Index>();
		Article article = articleDAO.getRandomArticle();
		Blog blog = blogDAO.getRnadomBlog();
		Blog blog_1 = blogDAO.getRnadomBlog();
		InformalEssay informal = essayDAO.getRandomInformalEssay();
		
		listIndex.add(new Index(article.getId(), article.getArticle_photoURL()));
		listIndex.add(new Index(blog.getId(), blog.getBlog_photourl()));
		listIndex.add(new Index(blog_1.getId(), blog_1.getBlog_photourl()));
		listIndex.add(new Index(informal.getId(), informal.getInformalessay_photourl()));
		Gson gson = new Gson();
		
		return   gson.toJson(listIndex);
	}

}
