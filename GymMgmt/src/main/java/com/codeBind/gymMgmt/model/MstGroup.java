package com.codeBind.gymMgmt.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "MST_GRP")
public class MstGroup implements Serializable{

	private static final long serialVersionUID = 2990597974825705930L;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MST_GRP_ID", unique = true, nullable = false, columnDefinition = "bigint")
	private Integer mstGrpId;
	
	@Id
	@Column(name = "GRP_CODE")
	private String grpCode;
	
	@Column(name = "GRP_NM")
	private String grpNm;
	
	@OneToMany(mappedBy = "mstGroup", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<MstGroupModule> mstGroupModule;

    @ManyToMany(mappedBy = "mstGroup")
    private Set<UserMst> userMst; 

	/**
	 * @return the mstGrpId
	 */
	public Integer getMstGrpId() {
		return mstGrpId;
	}

	/**
	 * @param mstGrpId the mstGrpId to set
	 */
	public void setMstGrpId(Integer mstGrpId) {
		this.mstGrpId = mstGrpId;
	}

	/**
	 * @return the grpCode
	 */
	public String getGrpCode() {
		return grpCode;
	}

	/**
	 * @param grpCode the grpCode to set
	 */
	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}

	/**
	 * @return the grpNm
	 */
	public String getGrpNm() {
		return grpNm;
	}

	/**
	 * @param grpNm the grpNm to set
	 */
	public void setGrpNm(String grpNm) {
		this.grpNm = grpNm;
	}

	/**
	 * @return the mstGroupModule
	 */
	public Set<MstGroupModule> getMstGroupModule() {
		return mstGroupModule;
	}

	/**
	 * @param mstGroupModule the mstGroupModule to set
	 */
	public void setMstGroupModule(Set<MstGroupModule> mstGroupModule) {
		this.mstGroupModule = mstGroupModule;
	}

	/**
	 * @return the userMst
	 */
	public Set<UserMst> getUserMst() {
		return userMst;
	}

	/**
	 * @param userMst the userMst to set
	 */
	public void setUserMst(Set<UserMst> userMst) {
		this.userMst = userMst;
	}	
}
