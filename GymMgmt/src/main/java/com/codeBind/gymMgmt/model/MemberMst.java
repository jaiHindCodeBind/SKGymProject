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

/**
 * @author Akshay
 *
 */
@Entity
@Table(name = "member_mst")
public class MemberMst implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "member_mst_id")
	private long memberMstId;
	
	@Column(name = "roll_number", nullable = false)
	private String rollNumber;
	
	@Column(name = "member_nm")
	private String memberNm;
	

	/**
	 * @return the memberMstId
	 */
	public long getMemberMstId() {
		return memberMstId;
	}

	/**
	 * @return the roll_number
	 */
	public String getRollNumber() {
		return rollNumber;
	}

	/**
	 * @return the memberNm
	 */
	public String getMemberNm() {
		return memberNm;
	}

	

	/**
	 * @param memberMstId the memberMstId to set
	 */
	public void setMemberMstId(long memberMstId) {
		this.memberMstId = memberMstId;
	}

	/**
	 * @param roll_number the roll_number to set
	 */
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	/**
	 * @param memberNm the memberNm to set
	 */
	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	
	
}
