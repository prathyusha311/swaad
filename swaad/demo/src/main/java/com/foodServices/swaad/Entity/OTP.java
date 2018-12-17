package com.foodServices.swaad.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class OTP implements Serializable {
	
	@Column(name="OTP_ID")
	@Id
	private String otpId;
	private int otp;
	private String status;
	
	@Column(name="EXPIRY_TIME")
	private Timestamp expiryTime;

//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "customerId")
//	private Customer customer;
//
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "tspId")
//	private TSP tsp;

	private String msisdn;

	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	public String getOtpId() {
		return otpId;
	}

	public void setOtpId(String otpId) {
		this.otpId = otpId;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public Timestamp getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Timestamp expiryTime) {
		this.expiryTime = expiryTime;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public TSP getTsp() {
//		return tsp;
//	}
//
//	public void setTsp(TSP tsp) {
//		this.tsp = tsp;
//	}


	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@PrePersist
	public void prePersist(){
		otpId = UUID.randomUUID().toString();
	}
	
	
}
