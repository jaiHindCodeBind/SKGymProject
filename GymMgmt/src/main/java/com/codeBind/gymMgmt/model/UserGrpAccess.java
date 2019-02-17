package com.codeBind.gymMgmt.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USR_GRP_ACCESS")
public class UserGrpAccess implements Serializable{

	private static final long serialVersionUID = -517573173718920139L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USR_GRP_ACCESS_ID", unique = true, nullable = false, columnDefinition = "bigint")
	protected Integer usrAccessId;
	
	@ManyToOne(targetEntity = UserMst.class)
	@JoinColumn(name = "LOGIN_ID")
	protected UserMst user;

	@ManyToOne(targetEntity = MstGroup.class)
	@JoinColumn(name = "GRP_CODE")
	protected MstGroup userGroup;

	
	/**
	 * @return the usrAccessId
	 */
	public Integer getUsrAccessId() {
		return usrAccessId;
	}

	/**
	 * @param usrAccessId the usrAccessId to set
	 */
	public void setUsrAccessId(Integer usrAccessId) {
		this.usrAccessId = usrAccessId;
	}

	/**
	 * @return the user
	 */
	public UserMst getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserMst user) {
		this.user = user;
	}

	/**
	 * @return the userGroup
	 */
	public MstGroup getUserGroup() {
		return userGroup;
	}

	/**
	 * @param userGroup the userGroup to set
	 */
	public void setUserGroup(MstGroup userGroup) {
		this.userGroup = userGroup;
	}

	
	
}
