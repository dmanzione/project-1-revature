package com.revature.services;

import java.util.Map;

import com.revature.utils.LocalStorage;

public class LocationService {

	private LocationService() {

	}

	public static Map<String, String> getAllLocations() {

		return LocalStorage.getLocations();
	}

	public static boolean exists(String path) {

		

		return getAllLocations().containsKey(path);

	}

	private static String capitalize(String string) {
		if (string.length() < 1)
			return null;
		else if (string.length() == 1)
			return string.toUpperCase();
		else
			return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}

	public static String fixLocationName(String messyName) {
		// remove slash
		String storeLocationRequested = messyName.replace("/", "");
		// create String array of distinct words in path
		String[] storeLocationArr = storeLocationRequested.split("-");
		storeLocationRequested = "";
		for (String wordInName : storeLocationArr) {
			// capitalize each word
			wordInName = capitalize(wordInName);

			// add to String
			storeLocationRequested += wordInName;
		}
		return storeLocationRequested + " Branch";
	}
}
