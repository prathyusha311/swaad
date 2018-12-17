package com.foodServices.swaad.Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.*;


@Entity
@Table(name="TSP_ITEMS")
public class TSPItems implements Serializable {
	
	@Id
	@Column(name="TSP_ITEM_ID")
	private String tspItemId;
	@Column(name="ITEM_NAME")
	private String itemName;
	private String price;
	@Column(name="TSP_ID")
	private String tspId;
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column(name="CREATED_ON")
	private Timestamp createdOn;

	public String getTspItemId() {
		return tspItemId;
	}

	public void setTspItemId(String tspItemId) {
		this.tspItemId = tspItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getTspId() {
		return tspId;
	}

	public void setTspId(String tspId) {
		this.tspId = tspId;
	}

	@PrePersist
	public void prePersist(){
		tspItemId = UUID.randomUUID().toString();
	}
	
}


