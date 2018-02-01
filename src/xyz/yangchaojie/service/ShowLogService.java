package xyz.yangchaojie.service;

import java.util.Map;

/***
 * 日志业务层
 * ShowLogServiceImpl 为实现类
 * @author Administrator
 *
 */
public interface ShowLogService {
	/**
	 * 获取log日志
	 * @param time
	 * @param Line
	 * @return
	 */
	public Map<String,Object> getLog(int LineNum,String logName,String PATH);
}
