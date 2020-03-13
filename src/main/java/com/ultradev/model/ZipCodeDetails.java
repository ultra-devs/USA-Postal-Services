package com.ultradev.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ZipCodeDetails {

	private String placeName;
	private String countyName;
	private String stateName;
	private String stateCode;
	
	
	public ZipCodeDetails(String placeName, String countyName, String stateName, String stateCode) {
		super();
		this.placeName = placeName;
		this.countyName = countyName;
		this.stateName = stateName;
		this.stateCode = stateCode;
	}

	public ZipCodeDetails()
	{}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	
	
}
