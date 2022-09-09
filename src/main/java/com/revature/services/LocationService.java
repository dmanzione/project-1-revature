package com.revature.services;

import java.util.Map;

import com.revature.utils.LocalStorage;

public class LocationService {

	public static void main(String[] args) {
		System.out.println(fixLocationName("captain"));
		System.out.println(getAllLocations().containsKey(fixLocationName("captain")));
		System.out.println(getAllLocations().containsKey("Captain Branch"));
	}

	private LocationService() {

	}

	public static Map<String, String> getAllLocations() {

		return LocalStorage.getLocations();
	}

	public static boolean exists(String path) {

		path = fixLocationName(path);

		return getAllLocations().containsKey(path);

	}

	private static String capitalize(String string) {
		String cap = String.valueOf(string.charAt(0)).toUpperCase();
		return cap + (string.substring(1).toLowerCase());
	}

	public static String fixLocationName(String messyName) {
		String[] locationArr = messyName.split("-");

		messyName = (locationArr.length > 1)
				? (capitalize(locationArr[0]) + " " + capitalize(locationArr[1]) + " Branch")
				: capitalize(messyName) + " Branch";
		return messyName;
	}
}
