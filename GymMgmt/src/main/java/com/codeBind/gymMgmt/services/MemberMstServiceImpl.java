/**
 * 
 */
package com.codeBind.gymMgmt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeBind.gymMgmt.dao.MemberMstDao;
import com.codeBind.gymMgmt.model.MemberMst;

/**
 * @author Akshay
 *
 */

@Service
public class MemberMstServiceImpl implements MemberMstService {

	@Autowired
	private MemberMstDao memberMstDao;
	
	/* (non-Javadoc)
	 * @see com.codeBind.gymMgmt.services.MemberMstService#saveMember(com.codeBind.gymMgmt.model.MemberMst)
	 */
	@Override
	public MemberMst saveMember(MemberMst memberMst) throws Exception {
		
		System.out.println("username:::"+memberMst.getRollNumber());
		System.out.println("name:::"+memberMst.getMemberNm());
		
		return memberMstDao.save(memberMst);
	}

	/* (non-Javadoc)
	 * @see com.codeBind.gymMgmt.services.MemberMstService#getAllMember()
	 */
	@Override
	public Iterable<MemberMst> getAllMember() throws Exception {
		Iterable<MemberMst> memberList = null;
		memberList =  memberMstDao.findAll();
		return memberList;
	}
}
