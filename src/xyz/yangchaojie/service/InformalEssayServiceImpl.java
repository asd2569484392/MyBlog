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
 * @see InformalEssayServiceImpl ��ʵ����
 * @author ���
 * 
 */
@Service
public class InformalEssayServiceImpl implements InformalEssayService {

	/***
	 * ���ͼƬ·��
	 */
	public static final String INFORMALESSAYIMGPATH = "InformalEssayImg/";

	/**
	 * ע����ʳ־ò�
	 */
	@Resource
	InformalEssayDAO informalEssayDAO;

	@Override
	public void insertNewInformalEssay(HttpServletRequest request,
			String informalEssay_title, String informalEssay_intro,
			String informalEssay_keyword, String informalEssay_content) {
		try {
			// ͼƬ�ϴ�
			String imgName = ImageUploadUtil.upload(request,
					INFORMALESSAYIMGPATH);
			// ������
			informalEssayDAO.insertNewInformalEssay(new InformalEssay(0,
					informalEssay_title, informalEssay_intro,
					informalEssay_content, "���", TimeUtil.getMM_yyyy(),
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
		int count = informalEssayDAO.getInformalEssaySum();

		// ��ҳ��
		int pageCount;

		if (count % size == 0) {
			pageCount = count / 8;
		} else {
			pageCount = count / 8 + 1;
		}
		
		List<InformalEssay> informalList;
		// ��ȡ��ǰ��ҳ����
		if(tag == null){
			informalList = informalEssayDAO
				.getInformalEssayList_Page((page - 1) * size, size);
		}else{
			informalList = informalEssayDAO.getInformalEssayByTag(tag,(page - 1) * size, size);
		}
		// ʹ��MAP���Ͻ���Ҫ���ص��������
		Map<String, Object> Map = new HashMap<String, Object>();
		// ������¼���
		Map.put("InformalEssayList", informalList);
		// �����ҳ��
		Map.put("PageCount", pageCount);
		// ��ӵ�ǰҳ��
		Map.put("CurrentPageNum", page);
		// ����MAP
		return Map;
	}
	//�������ͼƬ·��
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
			System.out.println("ɾ����ʳɹ�!\t"+"��ǰ���idΪ:"+id+"\nͼƬ��Ϊ:"+img);
		}
		informalEssayDAO.removeInformalEssay(id);
		
	}

}
