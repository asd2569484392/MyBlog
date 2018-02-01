package xyz.yangchaojie.entity;
/***
 * 随笔类
 * 
 * @author 杨超杰
 *
 */
public class InformalEssay {
    
	private	 int id;
	//标题
	private	 String informalessay_title;
	//简介
	private	 String informalessay_intro;
	//内容
	private	 String informalessay_content;
	//作者
	private	 String informalessay_author;
	//时间
	private	 String informalessay_time;
	//图片名称
	private String informalessay_photourl;
	//关键字
	private	 String informalessay_keyword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInformalessay_title() {
		return informalessay_title;
	}

	public void setInformalessay_title(String informalessay_title) {
		this.informalessay_title = informalessay_title;
	}

	public String getInformalessay_intro() {
		return informalessay_intro;
	}

	public void setInformalessay_intro(String informalessay_intro) {
		this.informalessay_intro = informalessay_intro;
	}

	public String getInformalessay_content() {
		return informalessay_content;
	}

	public void setInformalessay_content(String informalessay_content) {
		this.informalessay_content = informalessay_content;
	}

	public String getInformalessay_author() {
		return informalessay_author;
	}

	public void setInformalessay_author(String informalessay_author) {
		this.informalessay_author = informalessay_author;
	}

	public String getInformalessay_time() {
		return informalessay_time;
	}

	public void setInformalessay_time(String informalessay_time) {
		this.informalessay_time = informalessay_time;
	}

	public String getInformalessay_photourl() {
		return informalessay_photourl;
	}

	public void setInformalessay_photourl(String informalessay_photourl) {
		this.informalessay_photourl = informalessay_photourl;
	}

	public String getInformalessay_keyword() {
		return informalessay_keyword;
	}

	public void setInformalessay_keyword(String informalessay_keyword) {
		this.informalessay_keyword = informalessay_keyword;
	}

	public InformalEssay() {
		super();
	}

	public InformalEssay(int id, String informalessay_title,
			String informalessay_intro, String informalessay_content,
			String informalessay_author, String informalessay_time,
			String informalessay_photourl, String informalessay_keyword) {
		super();
		this.id = id;
		this.informalessay_title = informalessay_title;
		this.informalessay_intro = informalessay_intro;
		this.informalessay_content = informalessay_content;
		this.informalessay_author = informalessay_author;
		this.informalessay_time = informalessay_time;
		this.informalessay_photourl = informalessay_photourl;
		this.informalessay_keyword = informalessay_keyword;
	}

	@Override
	public String toString() {
		return "InformalEssay [id=" + id + ", informalessay_title="
				+ informalessay_title + ", informalessay_intro="
				+ informalessay_intro + ", informalessay_content="
				+ informalessay_content + ", informalessay_author="
				+ informalessay_author + ", informalessay_time="
				+ informalessay_time + ", informalessay_photourl="
				+ informalessay_photourl + ", informalessay_keyword="
				+ informalessay_keyword + "]";
	}

	public InformalEssay(int id, String informalessay_title,
			String informalessay_intro, String informalessay_content,
			String informalessay_keyword) {
		super();
		this.id = id;
		this.informalessay_title = informalessay_title;
		this.informalessay_intro = informalessay_intro;
		this.informalessay_content = informalessay_content;
		this.informalessay_keyword = informalessay_keyword;
	}
	
	
	
	
	
	
}
