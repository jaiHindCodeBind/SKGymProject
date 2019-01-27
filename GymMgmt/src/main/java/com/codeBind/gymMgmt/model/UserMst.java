/**
 * 
 */
package com.codeBind.gymMgmt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MST")
public class UserMst implements Serializable {
	
	
	private static final long serialVersionUID = -7349716361572627965L;

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_MST_ID", unique = true, nullable = false, columnDefinition = "bigint")
	private Integer userMstId;

	@Id
	@Column(name = "LOGIN_ID", unique = true, nullable = false)
	private String loginId;
	
	@Column(name = "USER_PWD")
	private String password;
	
	@Column(name = "USER_NM")
	private String userNM;
	
	@Column(name = "OLD_PWD")
	private String oldPwd;
	
	@Column(name = "PWD_CHANGE_DT")
	private String pwdChangeDt;
	
	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne(targetEntity = GYMMaster.class)
	@JoinColumn(name = "GYM_CODE")
	//@JoinColumn(name = "GYM_CODE")
	private GYMMaster gymMaster;
	
	/*
	@OneToMany(targetEntity = UserGrpAccess.class, mappedBy = "userMst", fetch = FetchType.EAGER)
	//@JoinColumn(name = "LOGIN_ID", referencedColumnName = "LOGIN_ID")
	@Cascade(value = { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	@Fetch(FetchMode.SELECT)
	private List<UserGrpAccess> userAccessModules;
*/
	
	
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
	public String getPwdChangeDt() {
		return pwdChangeDt;
	}

	/**
	 * @param pwdChangeDt the pwdChangeDt to set
	 */
	public void setPwdChangeDt(String pwdChangeDt) {
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
	 * @return the gymMaster
	 */
	public GYMMaster getGymMaster() {
		return gymMaster;
	}

	/**
	 * @param gymMaster the gymMaster to set
	 */
	public void setGymMaster(GYMMaster gymMaster) {
		this.gymMaster = gymMaster;
	}
	
}
