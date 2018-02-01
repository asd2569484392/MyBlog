package xyz.yangchaojie.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class IPFilter implements Filter{
	
	private	FilterConfig filterConfig;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		 	ServletContext context = filterConfig.getServletContext();
	        Map<String, Integer> ipMap = (Map<String, Integer>) context.getAttribute("ipMap");
	        String ip = request.getRemoteAddr();
	        if(ipMap.containsKey(ip)){
	            Integer count = ipMap.get(ip);
	            ipMap.put(ip,count+1);
	        }else{
	            ipMap.put(ip,1);
	        }
	        context.setAttribute("ipMap", ipMap);
	        fc.doFilter(request, response);
			
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
        this.filterConfig = filterConfig;
	}
	
	

}
