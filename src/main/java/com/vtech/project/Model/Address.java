package com.vtech.project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	private String area;
	private String city;
	private String state;
	private long pincode;
	public Address() {
		super();
	}
	public Address(long addressId, String area, String city, String state, long pincode) {
		super();
		this.addressId = addressId;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSatte() {
		return state;
	}
	public void setSatte(String state) {
		this.state = state;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}

}
