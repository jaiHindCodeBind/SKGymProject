package com.codeBind.gymMgmt.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "MST_SECTION")
public class MstSection implements Serializable{

	private static final long serialVersionUID = -3940928954053758509L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MST_SECTION_ID", unique = true, nullable = false, columnDefinition = "bigint")
	private Integer mstModuleId;
	
	@Id
	@Column(name = "SECTION_CODE")
	private String sectionCode;
	
	@Column(name = "SECTION_NM")
	private String sectionNm;

	@Column(name = "TOOLTIP_DESC")
	private String toolTipDesc;
	 
	@OneToMany(mappedBy = "mstScetion", cascade = CascadeType.ALL)
	private List<MstModule> userAccessModules;

	/**
	 * @return the mstModuleId
	 */
	public Integer getMstModuleId() {
		return mstModuleId;
	}

	/**
	 * @param mstModuleId the mstModuleId to set
	 */
	public void setMstModuleId(Integer mstModuleId) {
		this.mstModuleId = mstModuleId;
	}

	/**
	 * @return the sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	/**
	 * @param sectionCode the sectionCode to set
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @return the sectionNm
	 */
	public String getSectionNm() {
		return sectionNm;
	}

	/**
	 * @param sectionNm the sectionNm to set
	 */
	public void setSectionNm(String sectionNm) {
		this.sectionNm = sectionNm;
	}

	/**
	 * @return the toolTipDesc
	 */
	public String getToolTipDesc() {
		return toolTipDesc;
	}

	/**
	 * @param toolTipDesc the toolTipDesc to set
	 */
	public void setToolTipDesc(String toolTipDesc) {
		this.toolTipDesc = toolTipDesc;
	}

	/**
	 * @return the userAccessModules
	 */
	public List<MstModule> getUserAccessModules() {
		return userAccessModules;
	}

	/**
	 * @param userAccessModules the userAccessModules to set
	 */
	public void setUserAccessModules(List<MstModule> userAccessModules) {
		this.userAccessModules = userAccessModules;
	}
	
}
