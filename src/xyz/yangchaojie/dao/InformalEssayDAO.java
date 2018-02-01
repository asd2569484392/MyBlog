package xyz.yangchaojie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.InformalEssay;

/***
 * 随笔DAO接口
 * @author 杨超杰
 *
 */
public interface InformalEssayDAO {
	
	/***
	 * 添加新随笔
	 */
	public void insertNewInformalEssay(InformalEssay informalEssay);
	/***
	 * 返回随笔最新三条数据
	 * @return 返回随笔集合
	 */
	public List<InformalEssay> getThreeRecentInformalEssays();
	/***
	 * 
	 * @param pageNow 当前页
	 * @param size 每页长度
	 * @return 返回当前页面集合
	 */
	public List<InformalEssay> getInformalEssayList_Page(@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * 获取随笔总数
	 * @return  返回int类型随笔总数
	 */ 
	public int getInformalEssaySum();
	/***
	 * 获取随笔
	 * @param id
	 * @return InformalEssay
	 */
	public InformalEssay getInformalEssay(int id);
	/***
	 * 修改随笔
	 * @param 传入一个随笔类 
	 */
	public void updateInformalEssay(InformalEssay informalEssay);
	/**
	 * 删除随笔
	 * @param id
	 */
	public void removeInformalEssay(int id);
	/***
	 * 获取随笔封面名称
	 * @param id
	 * @return
	 */
	public String getInformalEssayPhotoName(int id);
	/***
	 * 根据标签查询随笔分页
	 * @return
	 */
	public List<InformalEssay> getInformalEssayByTag(@Param("tag")String tag,@Param("pageNow")int pageNow,@Param("size")int size);
	/***
	 * 获取随机随笔
	 */
	public InformalEssay getRandomInformalEssay();
}