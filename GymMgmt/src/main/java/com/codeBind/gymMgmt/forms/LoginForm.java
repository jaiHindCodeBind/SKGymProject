/**
 * 
 */
package com.codeBind.gymMgmt.forms;

import java.io.Serializable;

/**
 * @author akshay.hande
 *
 */
public class LoginForm implements Serializable{

	private static final long serialVersionUID = 1L;

	String userName ;
	String password ;
	String error;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

}
