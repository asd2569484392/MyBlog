package xyz.yangchaojie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.InformalEssay;

/***
 * ���DAO�ӿ�
 * @author ���
 *
 */
public interface InformalEssayDAO {
	
	/***
	 * ��������
	 */
	public void insertNewInformalEssay(InformalEssay informalEssay);
	/***
	 * �������������������
	 * @return ������ʼ���
	 */
	public List<InformalEssay> getThreeRecentInformalEssays();
	/***
	 * 
	 * @param pageNow ��ǰҳ
	 * @param size ÿҳ����
	 * @return ���ص�ǰҳ�漯��
	 */
	public List<InformalEssay> getInformalEssayList_Page(@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * ��ȡ�������
	 * @return  ����int�����������
	 */ 
	public int getInformalEssaySum();
	/***
	 * ��ȡ���
	 * @param id
	 * @return InformalEssay
	 */
	public InformalEssay getInformalEssay(int id);
	/***
	 * �޸����
	 * @param ����һ������� 
	 */
	public void updateInformalEssay(InformalEssay informalEssay);
	/**
	 * ɾ�����
	 * @param id
	 */
	public void removeInformalEssay(int id);
	/***
	 * ��ȡ��ʷ�������
	 * @param id
	 * @return
	 */
	public String getInformalEssayPhotoName(int id);
	/***
	 * ���ݱ�ǩ��ѯ��ʷ�ҳ
	 * @return
	 */
	public List<InformalEssay> getInformalEssayByTag(@Param("tag")String tag,@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * ��ȡ������
	 */
	public InformalEssay getRandomInformalEssay();
}