package com.codeBind.gymMgmt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "GYM_MST")
public class GYMMaster implements Serializable{

	private static final long serialVersionUID = 8426738380496593995L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GYM_MST_ID", unique = true, nullable = false, columnDefinition = "bigint")
	private Integer gymMstId;

	@Id
	@Column(name = "GYM_CODE", unique = true, nullable = false)
	private String gymCode;
	
	@Column(name = "GYM_NAME")
	private String gymNm;
	
/*	@Column(name = "ADDRESS_ID")
	private Integer address;
*/
	@Column(name = "RAGISTRATION_DT" , columnDefinition = "date")
	@Type(type = "org.hibernate.type.TimestampType")
	private Date registrationDt;
	
	
	@Column(name = "VALID_FROM" , columnDefinition = "date")
	@Type(type = "org.hibernate.type.TimestampType")
	private Date validFrom;
	
	@Column(name = "VALID_TO" , columnDefinition = "date")
	@Type(type = "org.hibernate.type.TimestampType")
	private Date validTo;
	
	@Column(name = "CONTACT_NO")
	private Integer contactNo;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "STATUS")
	private String status;
	

	//@OneToMany(targetEntity = UserMst.class, mappedBy = "gymMaster", fetch = FetchType.LAZY)
	//@JoinColumn(name = "GYM_CODE", referencedColumnName = "GYM_CODE")
	 @OneToMany(mappedBy = "gymMaster", cascade = CascadeType.ALL)
	//@Cascade(value = { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	//@Fetch(FetchMode.SELECT)
	private List<UserMst> userMstList;


	/**
	 * @return the gymMstId
	 */
	public Integer getGymMstId() {
		return gymMstId;
	}


	/**
	 * @param gymMstId the gymMstId to set
	 */
	public void setGymMstId(Integer gymMstId) {
		this.gymMstId = gymMstId;
	}


	/**
	 * @return the gymCode
	 */
	public String getGymCode() {
		return gymCode;
	}


	/**
	 * @param gymCode the gymCode to set
	 */
	public void setGymCode(String gymCode) {
		this.gymCode = gymCode;
	}


	/**
	 * @return the gymNm
	 */
	public String getGymNm() {
		return gymNm;
	}


	/**
	 * @param gymNm the gymNm to set
	 */
	public void setGymNm(String gymNm) {
		this.gymNm = gymNm;
	}


	/**
	 * @return the registrationDt
	 */
	public Date getRegistrationDt() {
		return registrationDt;
	}


	/**
	 * @param registrationDt the registrationDt to set
	 */
	public void setRegistrationDt(Date registrationDt) {
		this.registrationDt = registrationDt;
	}


	/**
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}


	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}


	/**
	 * @return the validTo
	 */
	public Date getValidTo() {
		return validTo;
	}


	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}


	/**
	 * @return the contactNo
	 */
	public Integer getContactNo() {
		return contactNo;
	}


	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}


	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}


	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	 * @return the userMstList
	 */
	public List<UserMst> getUserMstList() {
		return userMstList;
	}


	/**
	 * @param userMstList the userMstList to set
	 */
	public void setUserMstList(List<UserMst> userMstList) {
		this.userMstList = userMstList;
	}

}
