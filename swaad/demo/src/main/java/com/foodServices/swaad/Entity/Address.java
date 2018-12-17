package com.foodServices.swaad.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class Address implements Serializable {

		@Id
	    @Column(name = "ADDRESS_ID")
	    private String addressId;

	    @Column(name = "ADDRESS_LINE1")
	    private String addressLine1;

	    @Column(name = "ADDRESS_LINE2")
	    private String addressLine2;

	    @Column(name = "ADDRESS_LINE3")
	    private String addressLine3;
	    
	    @Column(name = "IS_DEFAULT")
	    private String isDefault;
	    
	    
	    private String city;

	    @Column(name = "CONTACT_NUMBER")
	    private String contactNumber;
	    
	    @Column(name="CREATED_ON")
		private Timestamp createdOn;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getAddressLine3() {
			return addressLine3;
		}

		public void setAddressLine3(String addressLine3) {
			this.addressLine3 = addressLine3;
		}

		public String getIsDefault() {
			return isDefault;
		}

		public void setIsDefault(String isDefault) {
			this.isDefault = isDefault;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public Timestamp getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(Timestamp createdOn) {
			this.createdOn = createdOn;
		}

	@PrePersist
	public void prePersist(){
		addressId = UUID.randomUUID().toString();
	}
}
