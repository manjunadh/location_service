package com.fgl.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//@Document
@Entity
@Table(name = "stores")
public class Store {
	@Id
	private int id;

	private String name;
	private String address;
	private String city;
	private String province;
	private String longitude;
	private String latitude;

	public Store(){}
	public Store(int id, String name, String address, String city, String province, String longitude,
			String latitude) {
		super();
		this.id= id;
		
		this.name = name;
		this.address = address;
		this.city = city;
		this.province = province;
		this.longitude = longitude;
		this.latitude = latitude;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	
}
