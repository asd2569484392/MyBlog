package xyz.yangchaojie.service;

import javax.servlet.http.HttpServletRequest;

/***
 * @see BackIndexServiceImpl 实现
 * @author 后台主页业务层
 *
 */
public interface BackIndexService {
	/***
	 * 用于后台主页中的数据展示，包含博客，文章，草稿，浏览量集合，以JSON形式返回
	 * @return 返回JSON格式字符串
	 * @param request  当前请求
	 */
	public String backIndex_getSumList(HttpServletRequest request);
	/**
	 * 用于后台主页表格的数据展示，包含文章，博客，随笔的集合
	 * @return 返回JSON格式字符串
	 */
	public String backIndex_getTableList();
	
}
