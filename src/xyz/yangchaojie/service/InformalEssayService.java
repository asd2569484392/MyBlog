package xyz.yangchaojie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import xyz.yangchaojie.entity.InformalEssay;
import xyz.yangchaojie.entity.Transform;

/***
 * 随笔业务层接口
 * 
 * @see InformalEssayServiceImpl
 * @author 杨超杰
 * 
 */
public interface InformalEssayService {
	/***
	 * 
	 * @param request
	 *            当前请求
	 * @param informalEssay_title
	 *            随笔标题
	 * @param informalEssay_intro
	 *            随笔简介
	 * @param informalEssay_keyword
	 *            随笔标签
	 * @param informalEssay_content
	 *            随笔内容
	 */
	public void insertNewInformalEssay(HttpServletRequest request,
			String informalEssay_title, String informalEssay_intro,
			String informalEssay_keyword, String informalEssay_content);

	/***
	 * 获取随笔分页控制层需要的AttributeMAP集合
	 * 
	 * @param request当前请求
	 * @return 返回MAP集合
	 */
	public Map<String, Object> getInformalEssayAttribute(
			HttpServletRequest request,String tag);

	/***
	 * 获取随笔图片路径
	 * 
	 * @return INFORMALESSAYPATH
	 */
	public String getInformalEssayPath();

	/***
	 * 获取InformalEssay
	 * 
	 * @param id
	 * @return 随笔
	 */
	public InformalEssay getInformalEssay(int id);

	/***
	 * 修改随笔
	 * 
	 * @param informalEssay
	 */
	public void updateInformalEssay(Transform transform);
	/***
	 * 删除随笔
	 * @param PROJECTPATH
	 * @param id
	 */
	public void deleteInformalEssay(String PROJECTPATH,int id);
}
