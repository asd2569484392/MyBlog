package xyz.yangchaojie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import xyz.yangchaojie.entity.Drafts;
import xyz.yangchaojie.entity.Transform;

/***
 * �ݸ�ҵ���ӿ�
 * @see DraftsServiceImple
 * @author ���
 *
 */
public interface DraftsService {
	/***
	 * ��ȡ���Ʋ�ݸ�AttributeMAP����
	 * @param request ��ǰ����
	 * @return ����MAP����
	 */
	public Map<String,Object> getDraftsAttribute(HttpServletRequest request);
	
	/***
	 * ��ӵ��ݸ�
	 * @param request ��ǰ����
	 * @param draft_title �ݸ����
	 * @param draft_intro �ݸ���
	 * @param draft_keyword ��ǩ
	 * @param draft_content ����
	 * @param draft_type ����
	 */
	public void insertToDraft(HttpServletRequest request,
			String draft_title,String draft_intro,String draft_keyword,
			String draft_content,String draft_type);
	/***
	 * ��ȡ�ݸ�id
	 * @param id
	 * @return ���زݸ�
	 */
	public Drafts getDraft(int id);
	/***
	 * �޸Ĳݸ�����
	 * @param �ݸ���
	 */
	public void updateDraft(Transform transform);
	/**
	 * ɾ���ݸ�
	 * @return
	 */
	public void deleteDraft(String PROJECTPATH,int id);
}
