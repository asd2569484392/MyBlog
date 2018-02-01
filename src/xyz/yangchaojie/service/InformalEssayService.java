package xyz.yangchaojie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import xyz.yangchaojie.entity.InformalEssay;
import xyz.yangchaojie.entity.Transform;

/***
 * ���ҵ���ӿ�
 * 
 * @see InformalEssayServiceImpl
 * @author ���
 * 
 */
public interface InformalEssayService {
	/***
	 * 
	 * @param request
	 *            ��ǰ����
	 * @param informalEssay_title
	 *            ��ʱ���
	 * @param informalEssay_intro
	 *            ��ʼ��
	 * @param informalEssay_keyword
	 *            ��ʱ�ǩ
	 * @param informalEssay_content
	 *            �������
	 */
	public void insertNewInformalEssay(HttpServletRequest request,
			String informalEssay_title, String informalEssay_intro,
			String informalEssay_keyword, String informalEssay_content);

	/***
	 * ��ȡ��ʷ�ҳ���Ʋ���Ҫ��AttributeMAP����
	 * 
	 * @param request��ǰ����
	 * @return ����MAP����
	 */
	public Map<String, Object> getInformalEssayAttribute(
			HttpServletRequest request,String tag);

	/***
	 * ��ȡ���ͼƬ·��
	 * 
	 * @return INFORMALESSAYPATH
	 */
	public String getInformalEssayPath();

	/***
	 * ��ȡInformalEssay
	 * 
	 * @param id
	 * @return ���
	 */
	public InformalEssay getInformalEssay(int id);

	/***
	 * �޸����
	 * 
	 * @param informalEssay
	 */
	public void updateInformalEssay(Transform transform);
	/***
	 * ɾ�����
	 * @param PROJECTPATH
	 * @param id
	 */
	public void deleteInformalEssay(String PROJECTPATH,int id);
}
