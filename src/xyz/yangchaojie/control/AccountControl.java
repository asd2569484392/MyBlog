package xyz.yangchaojie.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import xyz.yangchaojie.dao.AccountDAO;
import xyz.yangchaojie.entity.Account;
import xyz.yangchaojie.util.MD5Util;

@Controller
@RequestMapping("accountControl")
@SessionAttributes("LoginOK")
public class AccountControl {
	/***
	 * 引入账户持久层
	 */
	@Resource
	AccountDAO accountDAO;
	@RequestMapping("Login")
	public String Login(String username, String password,Model m) {
			Account account = accountDAO.LoginVerify(username
					,MD5Util.string2MD5(password));
			if(account==null||!account.getRole().equals("admin")){	
				return "redirect:/Login/Login.jsp";
			}else{
				m.addAttribute("LoginOK", username);
				return "Back/index";
			}			
	}
	

}
