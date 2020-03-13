package com.ultradev.util;

/**
 * 
 * @author shashank
 * 
 */
public class ApplicationConstants {
	private ApplicationConstants() {
	}

	
	public static final String  APPLICATION_NAME = "zipcodelocator";
	// feed file header/content order
	public static final int countryIndex = 0;
	public static final int postalIndex = 1;
	public static final int placeIndex = 2;
	public static final int adminname1Index = 3;
	public static final int admincode1Index = 4;
	public static final int adminname2Index = 5;
	public static final int admincode2Index = 6;
	public static final int adminname3Index = 7;
	public static final int admincode3Index = 8;
	public static final int latitudeIndex = 9;
	public static final int longitudeIndex = 10;
	public static final int accurarcyindex = 11;
	
	// For Logging Filter 
	public static final String BASE_PATH="/api/v1";
	public static final String BASE_PATH_TOEKN="/api/secure";
	public final static String TRANSACTION_ID_IDENTIFIER = "transactionId";
	public final static String REQUEST_URI_IDENTIFIER = "serviceName";
	public final static String RESPONSE_TIME_IDENTIFIER = " s e r v i c e - r e s p o n s e  - d u r a t i o n : ";// 
	public final static String HOST_IDENTIFIER = "hostname";
	public final static String APP_VERSION = "version";
	public final static String LOG_LEVEL = "loglevel";
	public final static String HOST_IDENTIFIER_TAG = "hostidentifier";
	
	// Swagger documentation 
	public final static String SWAGGER_CAT_DESCRIPTION_ZIP = "Services for zipcode resource lookup";
	public final static String SWAGGER_TAG_DESCRIPTION_ZIP = "zipcode";
	public final static String SWAGGER_CAT_DESCRIPTION_COUNTY = "Services for county resource lookup";
	public final static String SWAGGER_TAG_DESCRIPTION_COUNTY = "zipcounty";
	public final static String SWAGGER_CAT_DESCRIPTION_AUTH = "Autherization Service";
	public final static String SWAGGER_TAG_DESCRIPTION_AUTH = "token";
	
	public final static String SWAGGER_CONTENT_DESCRIPTION = "application/json";
	
	// Custom Exception error code
	public final static String DB_LOOKUP_FAILED=APPLICATION_NAME+"-"+"db-dnf-001";
	
	// api security flag
	public final static boolean API_SECURITY_ENABLE=true;
	
	// for flexibly response mapping
	public static final String DOZER_RESPONSE_MAPPING_XML = "dozer-response-mapping.xml";
	

}
