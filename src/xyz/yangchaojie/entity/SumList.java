package xyz.yangchaojie.entity;
/***
 * ��������JSON���ϣ��������ͣ����£��ݸ�ļ��ϵĵ�������
 * @author ���
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
