package xyz.yangchaojie.dao;
/***
 * �û��־ò�ӿ�
 */
import org.apache.ibatis.annotations.Param;

import xyz.yangchaojie.entity.Account;

public interface AccountDAO {
	/***
	 * 
	 * @param username �û���
	 * @param password ����
	 * @return ���ز�ѯ�����û�
	 */
	public Account LoginVerify(@Param("username")String username,@Param("password")String password);
	          
}	
