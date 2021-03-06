/**
 * 
 */
package com.codeBind.gymMgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codeBind.gymMgmt.model.UserMst;

/**
 * @author Akshay
 *
 */

@Repository
public interface UserMstDao extends JpaRepository<UserMst, String>{

	/**
	 * @param userNm
	 * @return
	 * @throws Exception
	 */
/*	public UserMst getMemberByUserId(String userNm) throws Exception;*/
	
}
