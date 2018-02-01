package xyz.yangchaojie.dao;

import java.util.List;

import xyz.yangchaojie.entity.Calender;

/***
 * 留言dao接口
 * @author 杨超杰
 *
 */
public interface CalenderDAO {
		/**
		 * 添加留言
		 * @param calender
		 */
	public void insrrtCalender(Calender calender);
	/**
	 * 查询全部留言
	 * @return
	 */
	public List<Calender> queryAll();
}
