package xyz.yangchaojie.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/***
 * ���ڹ�����
 * @author ���
 *
 */
public class TimeUtil {
	
	
	public static String getMM_yyyy(){
		//��ȡ��������
		Calendar c = Calendar.getInstance();
		//��ʽ��
		SimpleDateFormat f = new SimpleDateFormat("MM,yyyy");
		//��ȡ
		String time = f.format(c.getTime());
		return time;
	}
	public static String getyyyyMMdd(){
		//��ȡ��������
		Calendar c = Calendar.getInstance();
		//��ʽ��
		SimpleDateFormat f = new SimpleDateFormat("yyyy,MM,dd");
		//��ȡ
		String time = f.format(c.getTime());
		return time;
	}
	public static String getyyyyMMdd_zh(){
		//��ȡ��������
		Calendar c = Calendar.getInstance();
		//��ʽ��
		SimpleDateFormat f = new SimpleDateFormat("yyyy��MM��dd��");
		//��ȡ
		String time = f.format(c.getTime());
		return time;
	}
	
	public static String getyyyyMMddLog(){
		//��ȡ��������
		Calendar c = Calendar.getInstance();
		//��ʽ��
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		//��ȡ
		String time = f.format(c.getTime());
		return time;
	}
	
}
