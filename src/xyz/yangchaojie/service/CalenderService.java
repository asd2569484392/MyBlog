package xyz.yangchaojie.service;

import java.util.List;

import xyz.yangchaojie.entity.Calender;

/***
 * ����
 * @author ���
 *
 */
public interface CalenderService {
	
	public void addCalender(Calender calender);
	
	public List<Calender> getCalenderAll();
}
