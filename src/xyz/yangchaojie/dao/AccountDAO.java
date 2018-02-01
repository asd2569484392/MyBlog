package xyz.yangchaojie.dao;
/***
 * 用户持久层接口
 */
import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.Account;

public interface AccountDAO {
	/***
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回查询到的用户
	 */
	public Account LoginVerify(@Param("username")String username,@Param("password")String password);
	          
}	
