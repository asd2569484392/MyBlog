package xyz.yangchaojie.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.yangchaojie.service.CalenderService;
import xyz.yangchaojie.service.IndexToJsonService;
/***
 * 用于展示主页的随机数据
 * @author 杨超杰
 *
 */
@Controller
@RequestMapping("indexControl")
public class IndexControl {
	/**
	 * 注入主页业务层
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
