package xyz.yangchaojie.service;

import java.util.Map;

/***
 * ��־ҵ���
 * ShowLogServiceImpl Ϊʵ����
 * @author Administrator
 *
 */
public interface ShowLogService {
	/**
	 * ��ȡlog��־
	 * @param time
	 * @param Line
	 * @return
	 */
	public Map<String,Object> getLog(int LineNum,String logName,String PATH);
}
