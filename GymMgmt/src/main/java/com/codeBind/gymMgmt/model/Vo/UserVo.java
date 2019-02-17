package com.codeBind.gymMgmt.model.Vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import com.codeBind.gymMgmt.model.GYMMaster;
import com.codeBind.gymMgmt.model.MstGroup;

public class UserVo implements Serializable{

	private static final long serialVersionUID = 8457546640901653747L;

	private Integer userMstId;
	private String loginId;
	private String password;
	private String userNM;
	private String oldPwd;
	private Date pwdChangeDt;
	private String status;
	private String gymCode;
	private String gymNm;
	private Set<MstGroupVo> mstGroupVo;
	private ArrayList<AccessGroupVo> accessGroupList;
	private String userTp;
	private String language;
	
	/**
	 * @return the userMstId
	 */
	public Integer getUserMstId() {
		return userMstId;
	}
	/**
	 * @param userMstId the userMstId to set
	 */
	public void setUserMstId(Integer userMstId) {
		this.userMstId = userMstId;
	}
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
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
	 * @return the userNM
	 */
	public String getUserNM() {
		return userNM;
	}
	/**
	 * @param userNM the userNM to set
	 */
	public void setUserNM(String userNM) {
		this.userNM = userNM;
	}
	/**
	 * @return the oldPwd
	 */
	public String getOldPwd() {
		return oldPwd;
	}
	/**
	 * @param oldPwd the oldPwd to set
	 */
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	/**
	 * @return the pwdChangeDt
	 */
	public Date getPwdChangeDt() {
		return pwdChangeDt;
	}
	/**
	 * @param pwdChangeDt the pwdChangeDt to set
	 */
	public void setPwdChangeDt(Date pwdChangeDt) {
		this.pwdChangeDt = pwdChangeDt;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the gymCode
	 */
	public String getGymCode() {
		return gymCode;
	}
	/**
	 * @param gymCode the gymCode to set
	 */
	public void setGymCode(String gymCode) {
		this.gymCode = gymCode;
	}
	/**
	 * @return the gymNm
	 */
	public String getGymNm() {
		return gymNm;
	}
	/**
	 * @param gymNm the gymNm to set
	 */
	public void setGymNm(String gymNm) {
		this.gymNm = gymNm;
	}
	/**
	 * @return the mstGroupVo
	 */
	public Set<MstGroupVo> getMstGroupVo() {
		return mstGroupVo;
	}
	/**
	 * @param mstGroupVo the mstGroupVo to set
	 */
	public void setMstGroupVo(Set<MstGroupVo> mstGroupVo) {
		this.mstGroupVo = mstGroupVo;
	}
	/**
	 * @return the accessGroupLst
	 */
	public ArrayList<AccessGroupVo> getAccessGroupList() {
		return accessGroupList;
	}
	/**
	 * @param accessGroupLst the accessGroupLst to set
	 */
	public void setAccessGroupList(ArrayList<AccessGroupVo> accessGroupList) {
		this.accessGroupList = accessGroupList;
	}
	/**
	 * @return the userTp
	 */
	public String getUserTp() {
		return userTp;
	}
	/**
	 * @param userTp the userTp to set
	 */
	public void setUserTp(String userTp) {
		this.userTp = userTp;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}	
}
