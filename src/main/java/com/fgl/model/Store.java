package com.fgl.model;

import javax.persistence.Id;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import javax.persistence.Table;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import javax.persistence.Entity;
import org.springframework.data.mongodb.core.mapping.Document;
//@Document
@Entity
@Table(name = "stores")
public class Store {
	@Id
	private String storeNumber;
	private String name;
	private String address;
	private String city;
	private String province;
	private String longitude;
	private String latitude;
//	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
//	Point location;
	public Store(){}
	public Store(String storeNumber, String name, String address, String city, String province, String longitude,
			String latitude) {
		super();
		this.storeNumber = storeNumber;
		this.name = name;
		this.address = address;
		this.city = city;
		this.province = province;
		this.longitude = longitude;
		this.latitude = latitude;
		
	}
	public String getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
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
