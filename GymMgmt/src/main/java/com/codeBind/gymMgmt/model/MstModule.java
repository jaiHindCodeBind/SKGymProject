package com.codeBind.gymMgmt.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MST_MODULE")
public class MstModule implements Serializable{

	private static final long serialVersionUID = -8392797211704574864L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MST_MODULE_ID", unique = true, nullable = false, columnDefinition = "bigint")
	private Integer mstModuleId;
	
	@Id
	@Column(name = "MODULE_CODE")
	private String moduleCode;
	
	@Column(name = "MODULE_NM")
	private String moduleNm;
	
	@Column(name = "SEARCH_PATH")
	private String searchPath;

	@Column(name = "TOOLTIP_DESC")
	private String toolTipDesc;
	
	@ManyToOne(targetEntity = MstSection.class)
	@JoinColumn(name = "SECTION_CODE")
	private MstSection mstScetion;

	@OneToMany(mappedBy = "mstModule", cascade = CascadeType.ALL)
	private List<MstGroupModule> msttGroupModuleList;

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
	 * @return the moduleCode
	 */
	public String getModuleCode() {
		return moduleCode;
	}

	/**
	 * @param moduleCode the moduleCode to set
	 */
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	/**
	 * @return the moduleNm
	 */
	public String getModuleNm() {
		return moduleNm;
	}

	/**
	 * @param moduleNm the moduleNm to set
	 */
	public void setModuleNm(String moduleNm) {
		this.moduleNm = moduleNm;
	}

	/**
	 * @return the searchPath
	 */
	public String getSearchPath() {
		return searchPath;
	}

	/**
	 * @param searchPath the searchPath to set
	 */
	public void setSearchPath(String searchPath) {
		this.searchPath = searchPath;
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
	 * @return the mstScetion
	 */
	public MstSection getMstScetion() {
		return mstScetion;
	}

	/**
	 * @param mstScetion the mstScetion to set
	 */
	public void setMstScetion(MstSection mstScetion) {
		this.mstScetion = mstScetion;
	}

	/**
	 * @return the msttGroupModuleList
	 */
	public List<MstGroupModule> getMsttGroupModuleList() {
		return msttGroupModuleList;
	}

	/**
	 * @param msttGroupModuleList the msttGroupModuleList to set
	 */
	public void setMsttGroupModuleList(List<MstGroupModule> msttGroupModuleList) {
		this.msttGroupModuleList = msttGroupModuleList;
	}
	
}
