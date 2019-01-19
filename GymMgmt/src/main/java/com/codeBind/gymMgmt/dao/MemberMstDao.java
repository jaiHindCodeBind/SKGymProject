/**
 * 
 */
package com.codeBind.gymMgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeBind.gymMgmt.model.MemberMst;

/**
 * @author Akshay
 *
 */

@Repository
public interface MemberMstDao extends CrudRepository<MemberMst, Integer> {

	//public MemberMst crudOnMember() throws Exception;
	
}
