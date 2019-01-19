/**
 * 
 */
package com.codeBind.gymMgmt.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeBind.gymMgmt.dao.UserMstDao;
import com.codeBind.gymMgmt.model.UserMst;

/**
 * @author Akshay
 *
 */

@Service
public class UserMstServiceImpl implements UserMstService{

	@Autowired
	private UserMstDao userMstDao;
	
	@Override
	public Optional<UserMst> getUserLoginDtlsByUserId(String userNm) throws Exception {
		
		Optional<UserMst> userMst = null;
		
		userMst = userMstDao.findById(userNm);
		
		return userMst;
	}

}
