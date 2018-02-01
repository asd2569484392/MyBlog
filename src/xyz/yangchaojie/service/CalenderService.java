package xyz.yangchaojie.service;

import java.util.List;

import xyz.yangchaojie.entity.Calender;

/***
 * ¡Ù—‘
 * @author —Ó≥¨Ω‹
 *
 */
public interface CalenderService {
	
	public void addCalender(Calender calender);
	
	public List<Calender> getCalenderAll();
}
