package xyz.yangchaojie.entity;
//����ʵ����
public class Blog {
	private int id;
	//���ͱ���
	private	String blog_title;
	//���ͼ��
	private	String blog_intro;	
	//��������
	private	String blog_content;
	//����
	private	String blog_author;
	//ʱ��
	private	String blog_time;
	//ͼƬ��ַ
	private	String blog_photourl;
	//�ؼ���
	private	String blog_keyword;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public String getBlog_intro() {
		return blog_intro;
	}

	public void setBlog_intro(String blog_intro) {
		this.blog_intro = blog_intro;
	}

	public String getBlog_content() {
		return blog_content;
	}

	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}

	public String getBlog_author() {
		return blog_author;
	}

	public void setBlog_author(String blog_author) {
		this.blog_author = blog_author;
	}

	public String getBlog_time() {
		return blog_time;
	}

	public void setBlog_time(String blog_time) {
		this.blog_time = blog_time;
	}

	public String getBlog_photourl() {
		return blog_photourl;
	}

	public void setBlog_photourl(String blog_photourl) {
		this.blog_photourl = blog_photourl;
	}

	public String getBlog_keyword() {
		return blog_keyword;
	}

	public void setBlog_keyword(String blog_keyword) {
		this.blog_keyword = blog_keyword;
	}

	public Blog(int id, String blog_title, String blog_intro,
			String blog_content, String blog_author, String blog_time,
			String blog_photourl, String blog_keyword) {
		super();
		this.id = id;
		this.blog_title = blog_title;
		this.blog_intro = blog_intro;
		this.blog_content = blog_content;
		this.blog_author = blog_author;
		this.blog_time = blog_time;
		this.blog_photourl = blog_photourl;
		this.blog_keyword = blog_keyword;
	}
	
	public Blog() {
		super();
	}

	public Blog(int id, String blog_title, String blog_intro,
			String blog_content, String blog_keyword) {
		super();
		this.id = id;
		this.blog_title = blog_title;
		this.blog_intro = blog_intro;
		this.blog_content = blog_content;
		this.blog_keyword = blog_keyword;
	}
	
	
	
}
