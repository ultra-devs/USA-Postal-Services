package com.ultradev.dao.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "zipcodeinfo")
public class ZipCodeInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "COUNTRY")
	String country;
	@Column(name = "POSTAL_CODE")
	String postalcode;
	@Column(name = "PLACE_NAME")
	String place;
	@Column(name = "ADMIN_NAME_1")
	String adminname1;
	@Column(name = "ADMIN_CODE_1")
	String admincode1;
	@Column(name = "ADMIN_NAME_2")
	String adminname2;
	@Column(name = "ADMIN_CODE_2")
	String admincode2;
	@Column(name = "ADMIN_NAME_3")
	String adminname3;
	@Column(name = "ADMIN_CODE_3")
	String admincode3;
	@Column(name = "LATTITUDE")
	double lattitude;
	@Column(name = "LONGITUDE")
	double longitude;
	@Column(name = "ACCURACY")
	int accuracy;
	
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAdminname1() {
		return adminname1;
	}

	public void setAdminname1(String adminname1) {
		this.adminname1 = adminname1;
	}

	public String getAdmincode1() {
		return admincode1;
	}

	public void setAdmincode1(String admincode1) {
		this.admincode1 = admincode1;
	}

	public String getAdminname2() {
		return adminname2;
	}

	public void setAdminname2(String adminname2) {
		this.adminname2 = adminname2;
	}

	public String getAdmincode2() {
		return admincode2;
	}

	public void setAdmincode2(String admincode2) {
		this.admincode2 = admincode2;
	}

	public String getAdminname3() {
		return adminname3;
	}

	public void setAdminname3(String adminname3) {
		this.adminname3 = adminname3;
	}

	public String getAdmincode3() {
		return admincode3;
	}

	public void setAdmincode3(String admincode3) {
		this.admincode3 = admincode3;
	}
	
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAccuracy() {
		return accuracy;
	}
}
