package xyz.yangchaojie.entity;
/***
 * ÁôÑÔ
 * @author Ñî³¬½Ü
 *
 */
public class Calender {
	
	private	int id;
	//ĞÕÃû
	private	String name;
	//email
	private	String email;
	//Ö÷Ìâ
	private	String subject;
	//ÄÚÈİ
	private	String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Calender(int id, String name, String email, String subject,
			String content) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.content = content;
	}
	public Calender() {
		super();
	}
	
	
	
}