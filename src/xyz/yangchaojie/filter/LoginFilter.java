package xyz.yangchaojie.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/***
 *  ÓÃÓÚµÇÂ¼¹ýÂË
 * @author Ñî³¬½Ü
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("=========µÇÂ¼¹ýÂËÆ÷Ïú»Ù!==========");
	}

	@Override
	public void doFilter(ServletRequest arg1, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) arg1;
			HttpSession session = request.getSession();
			if(session.getAttribute("LoginOK")!=null){
				fc.doFilter(arg1, response);
			}else{
			RequestDispatcher rd =  request.getRequestDispatcher("/Login/Login.jsp");
			rd.forward(arg1, response);
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("=========³õÊ¼»¯µÇÂ¼¹ýÂËÆ÷!==========");
		
	}

}
