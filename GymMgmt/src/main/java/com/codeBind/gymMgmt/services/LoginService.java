package com.codeBind.gymMgmt.services;

import com.codeBind.gymMgmt.GymException;
import com.codeBind.gymMgmt.forms.LoginForm;
import com.codeBind.gymMgmt.model.Vo.UserVo;


public interface LoginService {

	/**@method use to authenticate User
	 * @param form
	 * @return
	 * @throws GymException 
	 */
	public UserVo authenticateUser(LoginForm form) throws GymException;

	
}
