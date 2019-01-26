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
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER_MST")
public class MemberMst implements Serializable {

	private static final long serialVersionUID = -4508276739855237982L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_MST_ID", unique = true, nullable = false, columnDefinition = "bigint")
	private Integer memberMstId;
	
	@Column(name = "ROLL_NUMBER", nullable = false)
	private String rollNumber;
	
	@Column(name = "MEMBER_NM")
	private String memberNm;

	/**
	 * @return the memberMstId
	 */
	public Integer getMemberMstId() {
		return memberMstId;
	}

	/**
	 * @param memberMstId the memberMstId to set
	 */
	public void setMemberMstId(Integer memberMstId) {
		this.memberMstId = memberMstId;
	}

	/**
	 * @return the rollNumber
	 */
	public String getRollNumber() {
		return rollNumber;
	}

	/**
	 * @param rollNumber the rollNumber to set
	 */
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	/**
	 * @return the memberNm
	 */
	public String getMemberNm() {
		return memberNm;
	}

	/**
	 * @param memberNm the memberNm to set
	 */
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}
}
