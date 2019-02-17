package com.codeBind.gymMgmt.dao;

import com.codeBind.gymMgmt.model.UserMst;

public interface UserMasterDao {

	/**@method use to get user Dtls by userName
	 * @param userName
	 * @return
	 */
	public UserMst getUserDtlsByUserId(String userName);
	

}
