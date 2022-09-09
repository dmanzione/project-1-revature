package com.revature.dao;
import java.util.Map;
import com.revature.utils.LocalStorage;
public class LocationDAO   {
	
	
	public Map<String, String> readAll() {
		
		return LocalStorage.getLocations();
	}
	
}
