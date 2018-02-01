package xyz.yangchaojie.entity;
/***
 * 方便阅读的中间类
 * @author 杨超杰
 *
 */
public class Transform_Read {
	
	private		String 	title;
	private		String 	intro;
	private		String 	content;
	private		String 	time;
	private		String 	url;
	private		String  keyword;
	public Transform_Read(String title, String intro, String content,
			String time, String url, String keyword) {
		super();
		this.title = title;
		this.intro = intro;
		this.content = content;
		this.time = time;
		this.url = url;
		this.keyword = keyword;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "Transform_Read [title=" + title + ", intro=" + intro
				+ ", content=" + content + ", time=" + time + ", url=" + url
				+ ", keyword=" + keyword + "]";
	}
	public Transform_Read() {
		super();
	}

}
