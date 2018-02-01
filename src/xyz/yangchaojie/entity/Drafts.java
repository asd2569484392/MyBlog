package xyz.yangchaojie.entity;
//草稿箱
public class Drafts {
	private	int id;
	//草稿标题
	private	String draft_title;
	//草稿简介
	private	String draft_intro;
	//草稿内容
	private	String draft_content;
	//草稿作者
	private	String draft_author;
	//草稿时间
	private	String draft_time;
	//图片地址，可以为空
	private	String draft_photoURL;
	//关键字
	private String draft_keyword;
	//类型
	private String draft_type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDraft_title() {
		return draft_title;
	}
	public void setDraft_title(String draft_title) {
		this.draft_title = draft_title;
	}
	public String getDraft_intro() {
		return draft_intro;
	}
	public void setDraft_intro(String draft_intro) {
		this.draft_intro = draft_intro;
	}
	public String getDraft_content() {
		return draft_content;
	}
	public void setDraft_content(String draft_content) {
		this.draft_content = draft_content;
	}
	public String getDraft_author() {
		return draft_author;
	}
	public void setDraft_author(String draft_author) {
		this.draft_author = draft_author;
	}
	public String getDraft_time() {
		return draft_time;
	}
	public void setDraft_time(String draft_time) {
		this.draft_time = draft_time;
	}
	public String getDraft_photoURL() {
		return draft_photoURL;
	}
	public void setDraft_photoURL(String draft_photoURL) {
		this.draft_photoURL = draft_photoURL;
	}
	public String getDraft_keyword() {
		return draft_keyword;
	}
	public void setDraft_keyword(String draft_keyword) {
		this.draft_keyword = draft_keyword;
	}
	public String getDraft_type() {
		return draft_type;
	}
	public void setDraft_type(String draft_type) {
		this.draft_type = draft_type;
	}
	public Drafts(int id, String draft_title, String draft_intro,
			String draft_content, String draft_author, String draft_time,
			String draft_photoURL, String draft_keyword, String draft_type) {
		super();
		this.id = id;
		this.draft_title = draft_title;
		this.draft_intro = draft_intro;
		this.draft_content = draft_content;
		this.draft_author = draft_author;
		this.draft_time = draft_time;
		this.draft_photoURL = draft_photoURL;
		this.draft_keyword = draft_keyword;
		this.draft_type = draft_type;
	}
	public Drafts() {
		super();
	}
	@Override
	public String toString() {
		return "Drafts [id=" + id + ", draft_title=" + draft_title
				+ ", draft_intro=" + draft_intro + ", draft_content="
				+ draft_content + ", draft_author=" + draft_author
				+ ", draft_time=" + draft_time + ", draft_photoURL="
				+ draft_photoURL + ", draft_keyword=" + draft_keyword
				+ ", draft_type=" + draft_type + "]";
	}
	public Drafts(int id, String draft_title, String draft_intro,
			String draft_content, String draft_keyword) {
		super();
		this.id = id;
		this.draft_title = draft_title;
		this.draft_intro = draft_intro;
		this.draft_content = draft_content;
		this.draft_keyword = draft_keyword;
	}
	public Drafts(String draft_photoURL, String draft_type) {
		super();
		this.draft_photoURL = draft_photoURL;
		this.draft_type = draft_type;
	}
	
	
	
}