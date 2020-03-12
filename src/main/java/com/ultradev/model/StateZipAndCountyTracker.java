package com.ultradev.model;

public class StateZipAndCountyTracker {

	private String stateName;
	private String stateCode;
	private long numberOfCounties;
	private long numberOfZipCodes;
	public StateZipAndCountyTracker(String stateName, String stateCode, long numberOfCounties, long numberOfZipCodes) {
		super();
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.numberOfCounties = numberOfCounties;
		this.numberOfZipCodes = numberOfZipCodes;
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

	public long getNumberOfCounties() {
		return numberOfCounties;
	}


	public void setNumberOfCounties(long numberOfCounties) {
		this.numberOfCounties = numberOfCounties;
	}


	public long getNumberOfZipCodes() {
		return numberOfZipCodes;
	}


	public void setNumberOfZipCodes(long numberOfZipCodes) {
		this.numberOfZipCodes = numberOfZipCodes;
	}


	public StateZipAndCountyTracker()
	{}
	

	
}
