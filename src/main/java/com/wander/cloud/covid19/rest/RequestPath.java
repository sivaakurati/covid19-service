/**
 * 
 */
package com.wander.cloud.covid19.rest;

/**
 * @author SIVA KUMAR
 */
public class RequestPath {
	
	private RequestPath() {
	}

	public static final String API = "/api";
	public static final String AUTHENTICATE = "/user/authenticate";
	public static final String USER = "/user";
	public static final String COUNTRY = "/country";
	public static final String LOCATION = "/location";
	
	public static final String COUNTRIES = "/countries";
	public static final String LOCATIONS = "/locations";
	
	public static final String ID = "/{id}";
}
