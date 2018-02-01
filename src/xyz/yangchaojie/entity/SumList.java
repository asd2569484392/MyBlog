package xyz.yangchaojie.entity;
/***
 * 用作返回JSON集合，包含博客，文章，草稿的集合的单个基类
 * @author 杨超杰
 *
 */
public class SumList {
	
	
	private	String name;
	
	private int number;
	
	public SumList(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	
	public SumList() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
