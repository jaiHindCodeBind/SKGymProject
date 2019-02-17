package com.codeBind.gymMgmt.model.Vo;

import java.io.Serializable;
import java.util.List;

import com.codeBind.gymMgmt.model.MstGroupModule;

public class MstGroupVo implements Serializable{

	private static final long serialVersionUID = 1705460943145988005L;
	private Integer mstGrpId;
	private String grpCode;
	private String grpNm;
	//private List<MstGroupModuleVo> mstGroupModule;
	
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
/*	*//**
	 * @return the mstGroupModule
	 *//*
	public List<MstGroupModule> getMstGroupModule() {
		return mstGroupModule;
	}
	*//**
	 * @param mstGroupModule the mstGroupModule to set
	 *//*
	public void setMstGroupModule(List<MstGroupModule> mstGroupModule) {
		this.mstGroupModule = mstGroupModule;
	}*/

}
