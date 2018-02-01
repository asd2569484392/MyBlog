package xyz.yangchaojie.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import xyz.yangchaojie.dao.CalenderDAO;
import xyz.yangchaojie.entity.Calender;
@Service
public class CalenderImpl implements CalenderService{
	/***
	 * ◊¢»Î¡Ù—‘dao
	 */
	@Resource
	CalenderDAO calenderDAO;
	
	@Override
	public void addCalender(Calender calender) {
		calenderDAO.insrrtCalender(calender);
	}
	@Override
	public List<Calender> getCalenderAll() {
		return calenderDAO.queryAll();
	}

}
