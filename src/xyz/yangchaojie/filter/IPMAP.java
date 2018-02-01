package xyz.yangchaojie.filter;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IPMAP implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("===========全局上下文销毁!==========");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 ServletContext context = arg0.getServletContext();
	     Map<String, Integer> ipMap = new LinkedHashMap<String, Integer>();
	     context.setAttribute("ipMap", ipMap);
	}

}
