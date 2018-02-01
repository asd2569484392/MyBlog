package xyz.yangchaojie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.Drafts;

/***
 * 草稿持久层
 * 
 * @author 杨超杰
 * 
 */
public interface DraftsDAO {
	/***
	 * 
	 * @return 返回草稿总数
	 */
	public int getDraftsSum();

	/***
	 * 
	 * @return 返回数据库倒序截取ID最大的三条数据集合
	 */
	public List<Drafts> getThreeRecentDrafts();

	/***
	 * 
	 * @param pageNow
	 *            当前页
	 * @param size
	 *            每页长度
	 * @return 草稿集合
	 */
	public List<Drafts> getDraftsList_Page(@Param("pageNow") int pageNow,
			@Param("size") int size);

	/***
	 * 添加草稿
	 * 
	 * @param draft
	 *            添加的草稿类
	 */
	public void insertDraft(Drafts draft);

	/**
	 * 通过类型获取草稿分页集合
	 * 
	 * @return 草稿List
	 */
	public List<Drafts> getDraftsList_PageByType(@Param("pageNow") int pageNow,
			@Param("size") int size, @Param("type") String type);
	/***
	 * 获取草稿
	 * @param id 
	 * @return 草稿
	 */
	public Drafts getDraft(int id);
	/***
	 * 更新草稿
	 * @param drafts
	 */
	public void updateDraft(Drafts drafts);
	/***
	 * 删除草稿
	 */
	public void removeDraft(int id);
	/**
	 * 获取草稿类型
	 * @return
	 */
	public Drafts getTypeAndPhotoName(int id);
	
}
