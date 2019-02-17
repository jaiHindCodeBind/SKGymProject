package com.codeBind.gymMgmt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class GroupModulePk implements Serializable{


	private static final long serialVersionUID = 1302787048883120157L;

	@Column(name = "GRP_CODE", unique = true, nullable = false, columnDefinition = "bigint")
	protected String grpId;

    @Column(name = "MODULE_CODE")
	protected String mstModuleId;

	
	/**
	 * @return the grpId
	 */
	public String getGrpId() {
		return grpId;
	}

	/**
	 * @param grpId the grpId to set
	 */
	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}

	/**
	 * @return the mstModuleId
	 */
	public String getMstModuleId() {
		return mstModuleId;
	}

	/**
	 * @param mstModuleId the mstModuleId to set
	 */
	public void setMstModuleId(String mstModuleId) {
		this.mstModuleId = mstModuleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grpId == null) ? 0 : grpId.hashCode());
		result = prime * result
				+ ((mstModuleId == null) ? 0 : mstModuleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupModulePk other = (GroupModulePk) obj;
		if (grpId == null) {
			if (other.grpId != null)
				return false;
		} else if (!grpId.equals(other.grpId))
			return false;
		if (mstModuleId == null) {
			if (other.mstModuleId != null)
				return false;
		} else if (!mstModuleId.equals(other.mstModuleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupModulePk [grpId=" + grpId + ", mstModuleId=" + mstModuleId
				+ "]";
	}
	


}
