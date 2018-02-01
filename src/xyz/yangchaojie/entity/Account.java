package xyz.yangchaojie.entity;
/***
 * 用户类
 * @author 杨超杰
 * @category Account bean
 *
 */
public class Account {
	//用户名
	private	String userName;
	//密码
	private	String passWord;
	//角色(权限)
	private	String role;
	
	
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	

	public Account(String userName, String passWord, String role) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}


	public Account() {
		super();
	}


	@Override
	public String toString() {
		return "Account [userName=" + userName + ", passWord=" + passWord
				+ ", role=" + role + "]";
	}

	
	
	
}
