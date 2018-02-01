package xyz.yangchaojie.entity;
/**
 * 为了方便修改的中间类
 * @author 杨超杰
 *
 */
public class Transform {
	
	private		String	id;
	private		String 	title;
	private		String 	intro;
	private		String 	content;
	private		String 	type;
	private		String  keyword;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Transform(String id, String title, String intro, String content,
			String type, String keyword) {
		super();
		this.id = id;
		this.title = title;
		this.intro = intro;
		this.content = content;
		this.type = type;
		this.keyword = keyword;
	}
	public Transform() {
		super();
	}
	

	
}
