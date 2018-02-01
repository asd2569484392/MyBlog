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
 * �ݸ�ҵ��ʵ����
 * 
 * @see DraftsService ��ʵ����
 * @author ���
 * 
 */
@Service
public class DraftsServiceImple implements DraftsService {
	/***
	 * ע��ݸ�־ò�
	 */
	@Resource
	DraftsDAO draftsDAO;
	/***
	 * ע������ҵ���
	 */
	@Resource
	ArticleService articleService;
	/***
	 * ע�벩��ҵ���
	 */
	@Resource
	BlogService blogService;
	/***
	 * ע�����ҵ���
	 */
	@Resource
	InformalEssayService informalEssayService;

	@Override
	public Map<String, Object> getDraftsAttribute(HttpServletRequest request) {
		String p = request.getParameter("p");
		// ��ȡ��ѯ����
		String type = request.getParameter("type");
		// ��ǰҳ
		int page;

		if (p == null) {
			page = 1;
		} else {
			page = Integer.parseInt(p);
		}
		// ÿҳ����Ϊ8
		int size = 8;

		// ��ȡ�������
		int count = draftsDAO.getDraftsSum();

		// ��ҳ��
		int pageCount;

		if (count % size == 0) {
			pageCount = count / 8;
		} else {
			pageCount = count / 8 + 1;
		}
		// ��ȡ��ǰ��ҳ����
		List<Drafts> draftsList;
		if (type == null) {
			draftsList = draftsDAO.getDraftsList_Page((page - 1) * size, size);
		} else {
			draftsList = draftsDAO.getDraftsList_PageByType((page - 1) * size,
					size, type);
		}
		// ʹ��MAP���Ͻ���Ҫ���ص��������
		Map<String, Object> Map = new HashMap<String, Object>();
		// ������¼���
		Map.put("DraftsList", draftsList);
		// �����ҳ��
		Map.put("PageCount", pageCount);
		// ��ӵ�ǰҳ��
		Map.put("CurrentPageNum", page);
		// ����MAP
		return Map;
	}

	@Override
	public void insertToDraft(HttpServletRequest request, String draft_title,
			String draft_intro, String draft_keyword, String draft_content,
			String draft_type) {
		try {
			if (draft_type.equals("Blog")) { // �жϵ�ǰ�ݸ����ͣ����ͼƬ����ͬ���ļ����£�����ӵ����ݿ�
				String imgName = ImageUploadUtil.upload(request,
						blogService.getBlogPath());
				draftsDAO.insertDraft(new Drafts(0, draft_title, draft_intro,
						draft_content, "���", TimeUtil.getMM_yyyy(), imgName,
						draft_keyword, draft_type));
			} else if (draft_type.equals("InformalEssay")) {
				String imgName = ImageUploadUtil.upload(request,
						informalEssayService.getInformalEssayPath());
				draftsDAO.insertDraft(new Drafts(0, draft_title, draft_intro,
						draft_content, "���", TimeUtil.getMM_yyyy(), imgName,
						draft_keyword, draft_type));
			} else if (draft_type.equals("Article")) {
				String imgName = ImageUploadUtil.upload(request,
						articleService.getArticlePath());
				draftsDAO.insertDraft(new Drafts(0, draft_title, draft_intro,
						draft_content, "���", TimeUtil.getMM_yyyy(), imgName,
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
				System.out.println("ɾ���ݸ�ɹ�!\t"+"��ǰ�ݸ�idΪ:"+id+"\nͼƬ��Ϊ:"+articleImgPath);
			}
			draftsDAO.removeDraft(id);
		}else if(drafts.getDraft_type().equals("Blog")){
			String BLOGPATH = blogService.getBlogPath();
			String blogImgPath =PROJECTPATH+ BLOGPATH.substring(0, (BLOGPATH.indexOf("/")))+"\\"+drafts.getDraft_photoURL();
			File imgFile = new File(blogImgPath);
			if(imgFile.exists()){
				imgFile.delete();
				System.out.println("ɾ���ݸ�ɹ�!\t"+"��ǰ�ݸ�idΪ:"+id+"\nͼƬ��Ϊ:"+blogImgPath);
			}
			draftsDAO.removeDraft(id);
		}else if(drafts.getDraft_type().equals("InformalEssay")){
			String INFORMALESSAYPATH = informalEssayService.getInformalEssayPath();
			String informalEssayImgPath =PROJECTPATH+ INFORMALESSAYPATH.substring(0, (INFORMALESSAYPATH.indexOf("/")))+"\\"+drafts.getDraft_photoURL();
			File imgFile = new File(informalEssayImgPath);
			if(imgFile.exists()){
				imgFile.delete();
				System.out.println("ɾ���ݸ�ɹ�!\t"+"��ǰ�ݸ�idΪ:"+id+"\nͼƬ��Ϊ:"+informalEssayImgPath);
			}
			draftsDAO.removeDraft(id);
		}
	}

}
