/**
 * 
 */
package com.codeBind.gymMgmt.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeBind.gymMgmt.model.UserMst;

/**
 * @author Akshay
 *
 */

@Service
public interface UserMstService {


	public Optional<UserMst> getUserLoginDtlsByUserId(String userNm) throws Exception;
	
	
}
