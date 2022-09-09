package com.revature.services;

import java.util.Map;

import com.revature.utils.LocalStorage;


public class LocationService {


	private LocationService() {
		
	}
	public Map<String,String> getAllLocations() {
		
		return LocalStorage.getLocations();
	}
}
