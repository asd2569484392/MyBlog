package xyz.yangchaojie.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @ClassName: ImageUploadUtil
 * @Description: ͼƬ�ϴ������࣬����ckeditor����
 */
public class ImageUploadUtil {

    // ͼƬ����
    private static List<String> fileTypes = new ArrayList<String>();

    static {
        fileTypes.add(".jpg");
        fileTypes.add(".jpeg");
        fileTypes.add(".bmp");
        fileTypes.add(".gif");
        fileTypes.add(".png");
    }

    /**
     * ͼƬ�ϴ�
     * 
     * @Title upload
     * @param request
     * @param DirectoryName
     *            �ļ��ϴ�Ŀ¼������upload(�����ǰ���/) upload/news ..
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String upload(HttpServletRequest request, String DirectoryName) throws IllegalStateException,
            IOException {
        // ����һ��ͨ�õĶಿ�ֽ�����
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());
        // ͼƬ����
        String fileName = null;
        // �ж� request �Ƿ����ļ��ϴ�,���ಿ������
        if (multipartResolver.isMultipart(request)) {
            // ת���ɶಿ��request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // ȡ��request�е������ļ���
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // ��¼�ϴ�������ʼʱ��ʱ�䣬���������ϴ�ʱ��
                // int pre = (int) System.currentTimeMillis();
                // ȡ���ϴ��ļ�
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // ȡ�õ�ǰ�ϴ��ļ����ļ�����
                    String myFileName = file.getOriginalFilename();
                    // ������Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������
                    if (myFileName.trim() != "") {
                        // ���ͼƬ��ԭʼ����
                        String originalFilename = file.getOriginalFilename();
                        // ���ͼƬ��׺����,�����׺��ΪͼƬ��ʽ�����ϴ�
                        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
                        if (!fileTypes.contains(suffix)) {
                            continue;
                        }
                        // ����ϴ�·���ľ���·����ַ(/upload)-->
                        String realPath = request.getSession().getServletContext().getRealPath("/" + DirectoryName);
//                        System.out.println(realPath);
                        // ���·�������ڣ��򴴽���·��
                        File realPathDirectory = new File(realPath);
                        if (realPathDirectory == null || !realPathDirectory.exists()) {
                            realPathDirectory.mkdirs();
                        }
                        // �������ϴ�����ļ��� 111112323.jpg
                        fileName = UUID.randomUUID().toString() + suffix;
                        // �����ϴ�·�� .../upload/111112323.jpg
                        File uploadFile = new File(realPathDirectory + "\\" + fileName);
                        System.out.println("ͼƬ�ϴ��ɹ�!\n·��Ϊ:"+uploadFile);
                        file.transferTo(uploadFile);
                    }
                }
                // ��¼�ϴ����ļ����ʱ��
                // int finaltime = (int) System.currentTimeMillis();
                // System.out.println(finaltime - pre);
            }
        }
        return fileName;
    }

    /**
     * ckeditor�ļ��ϴ����ܣ��ص�������ͼƬ·����ʵ��Ԥ��Ч����
     * 
     * @Title ckeditor
     * @param request
     * @param response
     * @param DirectoryName
     *            �ļ��ϴ�Ŀ¼������upload(�����ǰ���/) upload/..
     * @throws IOException
     */
    public static void ckeditor(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
        String fileName = upload(request, DirectoryName);
        // ���ckeditor����
        // imageContextPathΪͼƬ�ڷ�������ַ����upload/123.jpg,�Ǿ���·��
        String imageContextPath = request.getContextPath() + "/" + DirectoryName + "/" + fileName;
        response.setContentType("text/html;charset=UTF-8");
        String callback = request.getParameter("CKEditorFuncNum");
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
        out.println("</script>");
        out.flush();
        out.close();
    }
}