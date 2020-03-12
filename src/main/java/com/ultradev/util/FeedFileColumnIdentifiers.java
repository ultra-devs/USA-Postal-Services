package com.ultradev.util;

public enum FeedFileColumnIdentifiers {
	// creating description alias for the the ordered TDF
	country(ApplicationConstants.countryIndex), postalcode(ApplicationConstants.postalIndex),
	place(ApplicationConstants.placeIndex), adminname1(ApplicationConstants.adminname1Index),
	admincode1(ApplicationConstants.admincode1Index), adminname2(ApplicationConstants.adminname2Index),
	admincode2(ApplicationConstants.admincode2Index), adminname3(ApplicationConstants.adminname3Index),
	admincode3(ApplicationConstants.admincode3Index), lattitude(ApplicationConstants.latitudeIndex),
	longitude(ApplicationConstants.longitudeIndex), accuracy(ApplicationConstants.accurarcyindex);
	private FeedFileColumnIdentifiers(int index) {
		indexvalue = index;
	}
	private int indexvalue;
	public int val() {
		return this.indexvalue;
	}
}
