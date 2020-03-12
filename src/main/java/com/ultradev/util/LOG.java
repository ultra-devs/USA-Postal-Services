package com.ultradev.util;

import org.apache.commons.text.WordUtils;

public enum LOG {
	INPUT_PARAM("parameter Name "), DATA_LOAD_COMPLETED(" Feed file Load completed Successfully ( Took : "),FEED_FILE_RECORD_COUNT(" Total Feed Record Count :  ")
	,API_TRANSACTION_ID("API TransactionId"),FETCH_ZIP_CODE("Processing Zip Code Details with zipcode : ")
	,FETCH_STATE_DETAILS("Processing State Details with state code : ")
	;

	String value;

	LOG(String value) {
		this.value = value;
	}

	public String val() {
		return getFormattedMessage(this.value);
	}

	private static String getFormattedMessage(String msg) {
		StringBuilder stringBuilder = new StringBuilder();

		msg = WordUtils.capitalize(msg);

		if (msg == null || msg.length() == 0) {
			return msg;
		}

		char[] allChacters = msg.toCharArray();
		for (int i = 0; i < allChacters.length; i++) {
			stringBuilder.append((allChacters[i] + " "));
		}

		return (stringBuilder.toString());
	}
}
