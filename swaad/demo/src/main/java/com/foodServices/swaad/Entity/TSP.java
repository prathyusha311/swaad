package com.foodServices.swaad.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class TSP implements Serializable {
	
	@Column(name="TSP_ID")
	@Id
	private String tspId; 
	
	private String msisdn;

	private String email;
	private String name;
	
	private String pin;

	private String salt;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private KYC kyc;
	
	
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST )
	@JoinColumn(name="TSP_ID")
	private List<Address> address = new ArrayList<>();
	
//	@OneToMany(fetch=FetchType.LAZY )
//	@JoinColumn(name="USER_ID")
//	private List<OTP> otp;
	
	@OneToMany(mappedBy = "customer",fetch=FetchType.LAZY )
	private List<Orders> orders = new ArrayList<>();
	
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	public String getTspId() {
		return tspId;
	}

	public void setTspId(String tspId) {
		this.tspId = tspId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public KYC getKyc() {
		return kyc;
	}

	public void setKyc(KYC kyc) {
		this.kyc = kyc;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

//	public List<OTP> getOtp() {
//		return otp;
//	}
//
//	public void setOtp(List<OTP> otp) {
//		this.otp = otp;
//	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@PrePersist
	public void prePersist(){
		tspId = UUID.randomUUID().toString();
	}
	
	

}
