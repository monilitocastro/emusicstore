package com.emusicstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BillingAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6091579459463730482L;

	
	@Id
	@GeneratedValue
	private int billingAddressId;
	private String streetName;
	private String apartmentNumber;
	private String city;
	private String state;
	private String county;
	private String zipCode;
	
	public int getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
