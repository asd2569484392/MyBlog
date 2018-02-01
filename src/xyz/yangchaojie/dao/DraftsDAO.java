package xyz.yangchaojie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.Drafts;

/***
 * �ݸ�־ò�
 * 
 * @author ���
 * 
 */
public interface DraftsDAO {
	/***
	 * 
	 * @return ���زݸ�����
	 */
	public int getDraftsSum();

	/***
	 * 
	 * @return �������ݿ⵹���ȡID�����������ݼ���
	 */
	public List<Drafts> getThreeRecentDrafts();

	/***
	 * 
	 * @param pageNow
	 *            ��ǰҳ
	 * @param size
	 *            ÿҳ����
	 * @return �ݸ弯��
	 */
	public List<Drafts> getDraftsList_Page(@Param("pageNow") int pageNow,
			@Param("size") int size);

	/***
	 * ��Ӳݸ�
	 * 
	 * @param draft
	 *            ��ӵĲݸ���
	 */
	public void insertDraft(Drafts draft);

	/**
	 * ͨ�����ͻ�ȡ�ݸ��ҳ����
	 * 
	 * @return �ݸ�List
	 */
	public List<Drafts> getDraftsList_PageByType(@Param("pageNow") int pageNow,
			@Param("size") int size, @Param("type") String type);
	/***
	 * ��ȡ�ݸ�
	 * @param id 
	 * @return �ݸ�
	 */
	public Drafts getDraft(int id);
	/***
	 * ���²ݸ�
	 * @param drafts
	 */
	public void updateDraft(Drafts drafts);
	/***
	 * ɾ���ݸ�
	 */
	public void removeDraft(int id);
	/**
	 * ��ȡ�ݸ�����
	 * @return
	 */
	public Drafts getTypeAndPhotoName(int id);
	
}
