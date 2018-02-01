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
 * @author 杨超杰
 *
 */
@Service
public class ShowLogServiceImpl implements ShowLogService{
	
	
	@Override
	public Map<String,Object> getLog(int LineNum,String logName,String PATH) {
		/***
		 * i为局部变量,用于while遍历log日志,并将最后行数返回
		 */
		int i = 1;
		
		/*System.out.println("调用了");*/
		
		String logPath = PATH+"logs\\";
		//获取到新的log日志名
		String newLogName = (logPath+"localhost_access_log."+TimeUtil.getyyyyMMddLog()+".txt");
		
		File logFile;
		//存放行数，内容，文件名
		Map<String, Object> logMap = new HashMap<String, Object>();
		try {
			//判断当前是否第一次读取,并且判断当前文件是否
		if(logName==null||!logName.equals(newLogName)){
			
				logFile = new File(newLogName);
				
				BufferedReader bufferedReader;
				//逐行读取
				bufferedReader = new BufferedReader(new FileReader(logFile));
				if(logFile.exists()){
					/*System.out.println("执行读取新的log日志!");*/
					//声明局部变量存放每一行的变量
					String textLine;
					
					String content = "";
					
					while((textLine = bufferedReader.readLine())!=null){
						//记录行数
						i++;
						//修改原内容为HTML格式
						textLine = "<p>"+textLine+"</p>";
						//将所有内容赋给content
						content+=textLine;
						
					}//While End - 1
					logMap.put("error", null);
					logMap.put("lineNumber", i);
					logMap.put("logPath", newLogName);
					logMap.put("content", content);
					/*System.out.println("当前获取日志:"+content);*/
					
					return logMap;
					}
				}else{
						/*System.out.println("执行续读日志");*/
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
						/*System.out.println("续读日志:"+content);*/
						
						return logMap;
						}
				}
		//异常时获取异常信息
		} catch (FileNotFoundException e) {
			logMap.put("error", "沒有找到log日誌!");
			e.printStackTrace();
			return logMap;
		}catch (IOException e) {
			logMap.put("error", "数据传输异常!");
			e.printStackTrace();
			return logMap;
		}
		
		return null;
	}
	}