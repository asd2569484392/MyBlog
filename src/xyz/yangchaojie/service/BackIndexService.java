package xyz.yangchaojie.service;

import javax.servlet.http.HttpServletRequest;

/***
 * @see BackIndexServiceImpl ʵ��
 * @author ��̨��ҳҵ���
 *
 */
public interface BackIndexService {
	/***
	 * ���ں�̨��ҳ�е�����չʾ���������ͣ����£��ݸ壬��������ϣ���JSON��ʽ����
	 * @return ����JSON��ʽ�ַ���
	 * @param request  ��ǰ����
	 */
	public String backIndex_getSumList(HttpServletRequest request);
	/**
	 * ���ں�̨��ҳ��������չʾ���������£����ͣ���ʵļ���
	 * @return ����JSON��ʽ�ַ���
	 */
	public String backIndex_getTableList();
	
}
