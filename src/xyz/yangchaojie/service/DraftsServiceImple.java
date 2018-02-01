package xyz.yangchaojie.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import xyz.yangchaojie.dao.DraftsDAO;
import xyz.yangchaojie.entity.Drafts;
import xyz.yangchaojie.entity.Transform;
import xyz.yangchaojie.util.ImageUploadUtil;
import xyz.yangchaojie.util.TimeUtil;

/***
 * 草稿业务实现类
 * 
 * @see DraftsService 的实现类
 * @author 杨超杰
 * 
 */
@Service
public class DraftsServiceImple implements DraftsService {
	/***
	 * 注入草稿持久层
	 */
	@Resource
	DraftsDAO draftsDAO;
	/***
	 * 注入文章业务层
	 */
	@Resource
	ArticleService articleService;
	/***
	 * 注入博客业务层
	 */
	@Resource
	BlogService blogService;
	/***
	 * 注入随笔业务层
	 */
	@Resource
	InformalEssayService informalEssayService;

	@Override
	public Map<String, Object> getDraftsAttribute(HttpServletRequest request) {
		String p = request.getParameter("p");
		// 获取查询类型
		String type = request.getParameter("type");
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
		int count = draftsDAO.getDraftsSum();

		// 总页数
		int pageCount;

		if (count % size == 0) {
			pageCount = count / 8;
		} else {
			pageCount = count / 8 + 1;
		}
		// 获取当前分页集合
		List<Drafts> draftsList;
		if (type == null) {
			draftsList = draftsDAO.getDraftsList_Page((page - 1) * size, size);
		} else {
			draftsList = draftsDAO.getDraftsList_PageByType((page - 1) * size,
					size, type);
		}
		// 使用MAP集合将需要返回的数据添加
		Map<String, Object> Map = new HashMap<String, Object>();
		// 添加文章集合
		Map.put("DraftsList", draftsList);
		// 添加总页数
		Map.put("PageCount", pageCount);
		// 添加当前页数
		Map.put("CurrentPageNum", page);
		// 返回MAP
		return Map;
	}

	@Override
	public void insertToDraft(HttpServletRequest request, String draft_title,
			String draft_intro, String draft_keyword, String draft_content,
			String draft_type) {
		try {
			if (draft_type.equals("Blog")) { // 判断当前草稿类型，添加图片到不同的文件夹下，并添加到数据库
				String imgName = ImageUploadUtil.upload(request,
						blogService.getBlogPath());
				draftsDAO.insertDraft(new Drafts(0, draft_title, draft_intro,
						draft_content, "杨超杰", TimeUtil.getMM_yyyy(), imgName,
						draft_keyword, draft_type));
			} else if (draft_type.equals("InformalEssay")) {
				String imgName = ImageUploadUtil.upload(request,
						informalEssayService.getInformalEssayPath());
				draftsDAO.insertDraft(new Drafts(0, draft_title, draft_intro,
						draft_content, "杨超杰", TimeUtil.getMM_yyyy(), imgName,
						draft_keyword, draft_type));
			} else if (draft_type.equals("Article")) {
				String imgName = ImageUploadUtil.upload(request,
						articleService.getArticlePath());
				draftsDAO.insertDraft(new Drafts(0, draft_title, draft_intro,
						draft_content, "杨超杰", TimeUtil.getMM_yyyy(), imgName,
						draft_keyword, draft_type));
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Drafts getDraft(int id) {
		return draftsDAO.getDraft(id);
	}

	@Override
	public void updateDraft(Transform transform) {
		draftsDAO.updateDraft(new Drafts(Integer.parseInt(transform.getId()),
				transform.getTitle(), transform.getIntro(), transform
						.getContent(), transform.getKeyword()));
	}

	@Override
	public void deleteDraft(String PROJECTPATH,int id) {
		Drafts drafts = draftsDAO.getTypeAndPhotoName(id);
		if(drafts.getDraft_type().equals("Article")){
			String ARTICLEPATH = articleService.getArticlePath();
			String articleImgPath = PROJECTPATH+ ARTICLEPATH.substring(0, (ARTICLEPATH.indexOf("/")))+"\\"+drafts.getDraft_photoURL();
			File imgFile = new File(articleImgPath);
			if(imgFile.exists()){
				imgFile.delete();
				System.out.println("删除草稿成功!\t"+"当前草稿id为:"+id+"\n图片名为:"+articleImgPath);
			}
			draftsDAO.removeDraft(id);
		}else if(drafts.getDraft_type().equals("Blog")){
			String BLOGPATH = blogService.getBlogPath();
			String blogImgPath =PROJECTPATH+ BLOGPATH.substring(0, (BLOGPATH.indexOf("/")))+"\\"+drafts.getDraft_photoURL();
			File imgFile = new File(blogImgPath);
			if(imgFile.exists()){
				imgFile.delete();
				System.out.println("删除草稿成功!\t"+"当前草稿id为:"+id+"\n图片名为:"+blogImgPath);
			}
			draftsDAO.removeDraft(id);
		}else if(drafts.getDraft_type().equals("InformalEssay")){
			String INFORMALESSAYPATH = informalEssayService.getInformalEssayPath();
			String informalEssayImgPath =PROJECTPATH+ INFORMALESSAYPATH.substring(0, (INFORMALESSAYPATH.indexOf("/")))+"\\"+drafts.getDraft_photoURL();
			File imgFile = new File(informalEssayImgPath);
			if(imgFile.exists()){
				imgFile.delete();
				System.out.println("删除草稿成功!\t"+"当前草稿id为:"+id+"\n图片名为:"+informalEssayImgPath);
			}
			draftsDAO.removeDraft(id);
		}
	}

}
