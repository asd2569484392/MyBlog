package xyz.yangchaojie.entity;
//����ʵ����
public class Article {
	//����id,����
	private	int id;
	//���±���
	private	String article_title;
	//���¼��
	private	String article_intro;
	//��������
	private	String article_content;
	//��������
	private	String article_author;
	//����ʱ��
	private	String article_time;
	//ͼƬ��ַ������Ϊ��
	private	String article_photoURL;
	//�ؼ���
	private String article_keyword;
	//ȫ�ι���
	public Article(int id, String article_title, String article_intro,
			String article_content, String article_author, String article_time,
			String article_photo, String article_keyword) {
		super();
		this.id = id;
		this.article_title = article_title;
		this.article_intro = article_intro;
		this.article_content = article_content;
		this.article_author = article_author;
		this.article_time = article_time;
		this.article_photoURL = article_photo;
		this.article_keyword = article_keyword;
	}
	
	//�޲ι���
	public Article() {
		super();
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", article_title=" + article_title
				+ ", article_intro=" + article_intro + ", article_content="
				+ article_content + ", article_author=" + article_author
				+ ", article_time=" + article_time + ", article_photo="
				+ article_photoURL + ", article_keyword=" + article_keyword + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_intro() {
		return article_intro;
	}

	public void setArticle_intro(String article_intro) {
		this.article_intro = article_intro;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public String getArticle_author() {
		return article_author;
	}

	public void setArticle_author(String article_author) {
		this.article_author = article_author;
	}

	public String getArticle_time() {
		return article_time;
	}

	public void setArticle_time(String article_time) {
		this.article_time = article_time;
	}

	public String getArticle_photoURL() {
		return article_photoURL;
	}

	public void setArticle_photoURL(String article_photoURL) {
		this.article_photoURL = article_photoURL;
	}

	public String getArticle_keyword() {
		return article_keyword;
	}

	public void setArticle_keyword(String article_keyword) {
		this.article_keyword = article_keyword;
	}

	public Article(int id, String article_title, String article_intro,
			String article_content, String article_keyword) {
		super();
		this.id = id;
		this.article_title = article_title;
		this.article_intro = article_intro;
		this.article_content = article_content;
		this.article_keyword = article_keyword;
	}


	







}
	