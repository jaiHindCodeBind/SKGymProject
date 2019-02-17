/**
 * 
 */
package com.codeBind.gymMgmt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MST")
public class UserMst implements Serializable {
	
	
	private static final long serialVersionUID = -7349716361572627965L;

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_MST_ID", unique = true, nullable = false, columnDefinition = "bigint")
	private Integer userMstId;

	@Id
	@Column(name = "LOGIN_ID", unique = true, nullable = false )
	private String loginId;
	
	@Column(name = "USER_PWD")
	private String password;
	
	@Column(name = "USER_NM")
	private String userNM;
	
	@Column(name = "OLD_PWD")
	private String oldPwd;
	
	@Column(name = "PWD_CHANGE_DT")
	private Date pwdChangeDt;
	
	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne(targetEntity = GYMMaster.class)
	@JoinColumn(name = "GYM_CODE")
	private GYMMaster gymMaster;
	
	@Column(name = "USER_TP")
	private String userTP;

	 @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	 @JoinTable(name = "USR_GRP_ACCESS", joinColumns = { @JoinColumn(name = "LOGIN_ID") },inverseJoinColumns = { @JoinColumn(name = "GRP_CODE") })
	 private Set<MstGroup> mstGroup;
	 
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 private Set<UserGrpAccess> userGrpAccess;
	
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

	public Date getPwdChangeDt() {
		return pwdChangeDt;
	}

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
	 * @return the userTP
	 */
	public String getUserTP() {
		return userTP;
	}

	/**
	 * @param userTP the userTP to set
	 */
	public void setUserTP(String userTP) {
		this.userTP = userTP;
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

	public Set<MstGroup> getMstGroup() {
		return mstGroup;
	}

	public void setMstGroup(Set<MstGroup> mstGroup) {
		this.mstGroup = mstGroup;
	}

	/**
	 * @return the userGrpAccess
	 */
	public Set<UserGrpAccess> getUserGrpAccess() {
		return userGrpAccess;
	}

	/**
	 * @param userGrpAccess the userGrpAccess to set
	 */
	public void setUserGrpAccess(Set<UserGrpAccess> userGrpAccess) {
		this.userGrpAccess = userGrpAccess;
	}
	
}
