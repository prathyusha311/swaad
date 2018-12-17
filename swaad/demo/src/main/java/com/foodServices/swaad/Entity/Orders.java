package com.foodServices.swaad.Entity;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class Orders implements Serializable {

	@Id
	private String orderId;
	
	private String amount;
	private String status;
	private String custAddress;
	private String tspAddress;

	@ElementCollection
	@CollectionTable(name="ORDER_ITEMS",joinColumns=@JoinColumn(name="orderId"))
	private List<OrderItems> orderItems;


	
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getTspAddress() {
		return tspAddress;
	}

	public void setTspAddress(String tspAddress) {
		this.tspAddress = tspAddress;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@PrePersist
	public void prePersist(){
		orderId = UUID.randomUUID().toString();
	}
}
