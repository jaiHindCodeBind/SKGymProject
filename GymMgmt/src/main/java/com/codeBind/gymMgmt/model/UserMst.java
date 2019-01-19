/**
 * 
 */
package com.codeBind.gymMgmt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Akshay
 *
 */

@Entity
@Table(name = "user_mst")
public class UserMst implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_pwd")
	private String password;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
