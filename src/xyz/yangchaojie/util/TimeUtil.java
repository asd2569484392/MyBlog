package xyz.yangchaojie.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/***
 * 日期工具类
 * @author 杨超杰
 *
 */
public class TimeUtil {
	
	
	public static String getMM_yyyy(){
		//获取日历单例
		Calendar c = Calendar.getInstance();
		//格式化
		SimpleDateFormat f = new SimpleDateFormat("MM,yyyy");
		//截取
		String time = f.format(c.getTime());
		return time;
	}
	public static String getyyyyMMdd(){
		//获取日历单例
		Calendar c = Calendar.getInstance();
		//格式化
		SimpleDateFormat f = new SimpleDateFormat("yyyy,MM,dd");
		//截取
		String time = f.format(c.getTime());
		return time;
	}
	public static String getyyyyMMdd_zh(){
		//获取日历单例
		Calendar c = Calendar.getInstance();
		//格式化
		SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
		//截取
		String time = f.format(c.getTime());
		return time;
	}
	
	public static String getyyyyMMddLog(){
		//获取日历单例
		Calendar c = Calendar.getInstance();
		//格式化
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		//截取
		String time = f.format(c.getTime());
		return time;
	}
	
}
