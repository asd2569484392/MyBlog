package xyz.yangchaojie.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import xyz.yangchaojie.dao.InformalEssayDAO;
import xyz.yangchaojie.entity.InformalEssay;
import xyz.yangchaojie.entity.Transform;
import xyz.yangchaojie.util.ImageUploadUtil;
import xyz.yangchaojie.util.TimeUtil;

/***
 * @see InformalEssayServiceImpl 的实现类
 * @author 杨超杰
 * 
 */
@Service
public class InformalEssayServiceImpl implements InformalEssayService {

	/***
	 * 随笔图片路径
	 */
	public static final String INFORMALESSAYIMGPATH = "InformalEssayImg/";

	/**
	 * 注入随笔持久层
	 */
	@Resource
	InformalEssayDAO informalEssayDAO;

	@Override
	public void insertNewInformalEssay(HttpServletRequest request,
			String informalEssay_title, String informalEssay_intro,
			String informalEssay_keyword, String informalEssay_content) {
		try {
			// 图片上传
			String imgName = ImageUploadUtil.upload(request,
					INFORMALESSAYIMGPATH);
			// 添加随笔
			informalEssayDAO.insertNewInformalEssay(new InformalEssay(0,
					informalEssay_title, informalEssay_intro,
					informalEssay_content, "杨超杰", TimeUtil.getMM_yyyy(),
					imgName, informalEssay_keyword));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Map<String, Object> getInformalEssayAttribute(
			HttpServletRequest request,String tag) {
		String p = request.getParameter("p");
		// 当前页
		int page;

		if (p == null) {
			page = 1;
		} else {
			page = Integer.parseInt(p);
		}
		// 每页长度为8
		int size = 8;

		// 获取随笔总数
		int count = informalEssayDAO.getInformalEssaySum();

		// 总页数
		int pageCount;

		if (count % size == 0) {
			pageCount = count / 8;
		} else {
			pageCount = count / 8 + 1;
		}
		
		List<InformalEssay> informalList;
		// 获取当前分页集合
		if(tag == null){
			informalList = informalEssayDAO
				.getInformalEssayList_Page((page - 1) * size, size);
		}else{
			informalList = informalEssayDAO.getInformalEssayByTag(tag,(page - 1) * size, size);
		}
		// 使用MAP集合将需要返回的数据添加
		Map<String, Object> Map = new HashMap<String, Object>();
		// 添加文章集合
		Map.put("InformalEssayList", informalList);
		// 添加总页数
		Map.put("PageCount", pageCount);
		// 添加当前页数
		Map.put("CurrentPageNum", page);
		// 返回MAP
		return Map;
	}
	//返回随笔图片路径
	@Override
	public String getInformalEssayPath() {
		return INFORMALESSAYIMGPATH;
	}

	@Override
	public InformalEssay getInformalEssay(int id) {
		return informalEssayDAO.getInformalEssay(id);
	}

	@Override
	public void updateInformalEssay(Transform transform) {
		informalEssayDAO.updateInformalEssay(new InformalEssay(Integer
				.parseInt(transform.getId()), transform.getTitle(), transform
				.getIntro(), transform.getContent(), transform.getKeyword()));
	}

	@Override
	public void deleteInformalEssay(String PROJECTPATH, int id) {
		String imgName = "\\"+informalEssayDAO.getInformalEssayPhotoName(id);
		File img = new File(PROJECTPATH+imgName);
		if(img.exists()){
			img.delete();
			System.out.println("删除随笔成功!\t"+"当前随笔id为:"+id+"\n图片名为:"+img);
		}
		informalEssayDAO.removeInformalEssay(id);
		
	}

}
