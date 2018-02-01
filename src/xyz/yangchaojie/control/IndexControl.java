package xyz.yangchaojie.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.yangchaojie.service.CalenderService;
import xyz.yangchaojie.service.IndexToJsonService;
/***
 * ����չʾ��ҳ���������
 * @author ���
 *
 */
@Controller
@RequestMapping("indexControl")
public class IndexControl {
	/**
	 * ע����ҳҵ���
	 */
	@Resource
	IndexToJsonService indexToJsonService;
	@Resource
	CalenderService calenderService;
	@RequestMapping("initIndex_Ajax")
	@ResponseBody
	public String initIndex(){
		return indexToJsonService.getIndexDate();	
	}
	
	@RequestMapping("calender")
	public String Calender(xyz.yangchaojie.entity.Calender calender){
		calenderService.addCalender(calender);
		return "/index/index";
		
	}
}
