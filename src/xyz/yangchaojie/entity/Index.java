package xyz.yangchaojie.entity;
/**
 * 
 * @author Ñî³¬½Ü
 *
 */
public class Index {
	
	private	int id;
	
	private	String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Index(int id, String url) {
		super();
		this.id = id;
		this.url = url;
	}

	public Index() {
		super();
	}
	
	
}
