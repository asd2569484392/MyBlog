package xyz.yangchaojie.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import xyz.yangchaojie.util.TimeUtil;

/***
 * 
 * @author ���
 *
 */
@Service
public class ShowLogServiceImpl implements ShowLogService{
	
	
	@Override
	public Map<String,Object> getLog(int LineNum,String logName,String PATH) {
		/***
		 * iΪ�ֲ�����,����while����log��־,���������������
		 */
		int i = 1;
		
		/*System.out.println("������");*/
		
		String logPath = PATH+"logs\\";
		//��ȡ���µ�log��־��
		String newLogName = (logPath+"localhost_access_log."+TimeUtil.getyyyyMMddLog()+".txt");
		
		File logFile;
		//������������ݣ��ļ���
		Map<String, Object> logMap = new HashMap<String, Object>();
		try {
			//�жϵ�ǰ�Ƿ��һ�ζ�ȡ,�����жϵ�ǰ�ļ��Ƿ�
		if(logName==null||!logName.equals(newLogName)){
			
				logFile = new File(newLogName);
				
				BufferedReader bufferedReader;
				//���ж�ȡ
				bufferedReader = new BufferedReader(new FileReader(logFile));
				if(logFile.exists()){
					/*System.out.println("ִ�ж�ȡ�µ�log��־!");*/
					//�����ֲ��������ÿһ�еı���
					String textLine;
					
					String content = "";
					
					while((textLine = bufferedReader.readLine())!=null){
						//��¼����
						i++;
						//�޸�ԭ����ΪHTML��ʽ
						textLine = "<p>"+textLine+"</p>";
						//���������ݸ���content
						content+=textLine;
						
					}//While End - 1
					logMap.put("error", null);
					logMap.put("lineNumber", i);
					logMap.put("logPath", newLogName);
					logMap.put("content", content);
					/*System.out.println("��ǰ��ȡ��־:"+content);*/
					
					return logMap;
					}
				}else{
						/*System.out.println("ִ��������־");*/
						logFile = new File(logName);
						BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile));
						if(logFile.exists()){
						String textLine;
						String content = "";
						while((textLine=bufferedReader.readLine())!=null){
							i++;
							if(i==(LineNum)){
								textLine = "<p>"+textLine+"</p>";
								content+=textLine;
							}
						}
						logMap.put("error", null);
						logMap.put("lineNumber", i);
						logMap.put("logPath", newLogName);
						logMap.put("content", content);
						/*System.out.println("������־:"+content);*/
						
						return logMap;
						}
				}
		//�쳣ʱ��ȡ�쳣��Ϣ
		} catch (FileNotFoundException e) {
			logMap.put("error", "�]���ҵ�log���I!");
			e.printStackTrace();
			return logMap;
		}catch (IOException e) {
			logMap.put("error", "���ݴ����쳣!");
			e.printStackTrace();
			return logMap;
		}
		
		return null;
	}
	}