/**
 * 
 */
package com.codeBind.gymMgmt.services;

import org.springframework.stereotype.Service;

import com.codeBind.gymMgmt.model.MemberMst;

/**
 * @author Akshay
 *
 */
@Service
public interface MemberMstService {

	/**
	 * @param memberMst
	 * @return
	 * @throws Exception
	 */
	public MemberMst saveMember(MemberMst memberMst) throws Exception;
	
	/**
	 * @return
	 * @throws Exception
	 */
	public Iterable<MemberMst> getAllMember() throws Exception;
	
	
}
