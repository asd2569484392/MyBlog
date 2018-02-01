package xyz.yangchaojie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import xyz.yangchaojie.entity.Drafts;
import xyz.yangchaojie.entity.Transform;

/***
 * 草稿业务层接口
 * @see DraftsServiceImple
 * @author 杨超杰
 *
 */
public interface DraftsService {
	/***
	 * 获取控制层草稿AttributeMAP集合
	 * @param request 当前请求
	 * @return 返回MAP集合
	 */
	public Map<String,Object> getDraftsAttribute(HttpServletRequest request);
	
	/***
	 * 添加到草稿
	 * @param request 当前请求
	 * @param draft_title 草稿标题
	 * @param draft_intro 草稿简介
	 * @param draft_keyword 标签
	 * @param draft_content 内容
	 * @param draft_type 类型
	 */
	public void insertToDraft(HttpServletRequest request,
			String draft_title,String draft_intro,String draft_keyword,
			String draft_content,String draft_type);
	/***
	 * 获取草稿id
	 * @param id
	 * @return 返回草稿
	 */
	public Drafts getDraft(int id);
	/***
	 * 修改草稿内容
	 * @param 草稿类
	 */
	public void updateDraft(Transform transform);
	/**
	 * 删除草稿
	 * @return
	 */
	public void deleteDraft(String PROJECTPATH,int id);
}
