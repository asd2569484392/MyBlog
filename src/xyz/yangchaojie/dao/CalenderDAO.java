package xyz.yangchaojie.dao;

import java.util.List;

import xyz.yangchaojie.entity.Calender;

/***
 * ����dao�ӿ�
 * @author ���
 *
 */
public interface CalenderDAO {
		/**
		 * �������
		 * @param calender
		 */
	public void insrrtCalender(Calender calender);
	/**
	 * ��ѯȫ������
	 * @return
	 */
	public List<Calender> queryAll();
}
