package com.foodServices.swaad.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class KYC implements Serializable {

	@Id
	@Column(name="KYC_ID")
	private String kycId;
	
	@Column(name="KYC_NUMBER")
	private String kycNumber;
	
	private String status;
	
	@OneToOne
	@JoinColumn(name="TSP_ID")
	private TSP tsp;
	
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	public String getKycId() {
		return kycId;
	}

	public void setKycId(String kycId) {
		this.kycId = kycId;
	}

	public String getKycNumber() {
		return kycNumber;
	}

	public void setKycNumber(String kycNumber) {
		this.kycNumber = kycNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TSP getTsp() {
		return tsp;
	}

	public void setTsp(TSP tsp) {
		this.tsp = tsp;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@PrePersist
	public void prePersist(){
		kycId = UUID.randomUUID().toString();
	}
}
