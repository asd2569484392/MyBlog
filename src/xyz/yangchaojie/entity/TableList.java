package xyz.yangchaojie.entity;

import java.util.List;
/**
 * 用作转化为JSON返回
 * @author 杨超杰
 *
 */
public class TableList {
	
	private	List<InformalEssay> informalEssay;
	
	private	List<Article> articleList;
	
	private	List<Blog> BlogList;
	
	private	List<Drafts> draftsList;

	public List<InformalEssay> getInformalEssay() {
		return informalEssay;
	}

	public void setInformalEssay(List<InformalEssay> informalEssay) {
		this.informalEssay = informalEssay;
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}

	public List<Blog> getBlogList() {
		return BlogList;
	}

	public void setBlogList(List<Blog> blogList) {
		BlogList = blogList;
	}

	public List<Drafts> getDraftsList() {
		return draftsList;
	}

	public void setDraftsList(List<Drafts> draftsList) {
		this.draftsList = draftsList;
	}

	public TableList(List<InformalEssay> informalEssay,
			List<Article> articleList, List<Blog> blogList,
			List<Drafts> draftsList) {
		super();
		this.informalEssay = informalEssay;
		this.articleList = articleList;
		BlogList = blogList;
		this.draftsList = draftsList;
	}

	public TableList() {
		super();
	}

	@Override
	public String toString() {
		return "TableList [informalEssay=" + informalEssay + ", articleList="
				+ articleList + ", BlogList=" + BlogList + ", draftsList="
				+ draftsList + "]";
	}

	
	
}
