package com.codeBind.gymMgmt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MST_GRP_MODULE")
public class MstGroupModule implements Serializable{

	private static final long serialVersionUID = 7246149044957293050L;
	
	@EmbeddedId
	protected GroupModulePk groupModulePk;
		
	@Column(name = "CR_ACCESS")
	private Boolean crAccess;

	@Column(name = "MD_ACCESS")
	private Boolean mdAccess;

	@Column(name = "VW_ACCESS")
	private Boolean vwAccess;

	@Column(name = "DEL_ACCESS")
	private Boolean delAccess;

	@ManyToOne(targetEntity = MstGroup.class )
	@JoinColumn(name = "GRP_CODE", insertable=false, updatable=false)
	private MstGroup mstGroup;
	
	@ManyToOne(targetEntity = MstModule.class)
	@JoinColumn(name = "MODULE_CODE", insertable=false, updatable=false)
	private MstModule mstModule;
	
	
	/**
	 * @return the groupModulePk
	 */
	public GroupModulePk getGroupModulePk() {
		return groupModulePk;
	}

	/**
	 * @param groupModulePk the groupModulePk to set
	 */
	public void setGroupModulePk(GroupModulePk groupModulePk) {
		this.groupModulePk = groupModulePk;
	}


	/**
	 * @return the mstGroup
	 */
	public MstGroup getMstGroup() {
		return mstGroup;
	}

	/**
	 * @return the crAccess
	 */
	public Boolean getCrAccess() {
		return crAccess;
	}

	/**
	 * @param crAccess the crAccess to set
	 */
	public void setCrAccess(Boolean crAccess) {
		this.crAccess = crAccess;
	}

	/**
	 * @return the mdAccess
	 */
	public Boolean getMdAccess() {
		return mdAccess;
	}

	/**
	 * @param mdAccess the mdAccess to set
	 */
	public void setMdAccess(Boolean mdAccess) {
		this.mdAccess = mdAccess;
	}

	/**
	 * @return the vwAccess
	 */
	public Boolean getVwAccess() {
		return vwAccess;
	}

	/**
	 * @param vwAccess the vwAccess to set
	 */
	public void setVwAccess(Boolean vwAccess) {
		this.vwAccess = vwAccess;
	}

	/**
	 * @return the delAccess
	 */
	public Boolean getDelAccess() {
		return delAccess;
	}

	/**
	 * @param delAccess the delAccess to set
	 */
	public void setDelAccess(Boolean delAccess) {
		this.delAccess = delAccess;
	}

	/**
	 * @param mstGroup the mstGroup to set
	 */
	public void setMstGroup(MstGroup mstGroup) {
		this.mstGroup = mstGroup;
	}

	/**
	 * @return the mstModule
	 */
	public MstModule getMstModule() {
		return mstModule;
	}

	/**
	 * @param mstModule the mstModule to set
	 */
	public void setMstModule(MstModule mstModule) {
		this.mstModule = mstModule;
	}	
	
}
