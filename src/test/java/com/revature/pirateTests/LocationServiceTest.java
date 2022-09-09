package com.revature.pirateTests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.services.LocationService;

public class LocationServiceTest {

	@Test
	public void testLocationExists() {
		
		List<String> locationNames = new ArrayList<String>() {{
			
			add("captain");
			add("first-mate");
			add("quartermaster");
			add("sailing-master");
			add("gunner");
			add("powder-monkey");
			add("boatswain");
			add("surgeon");
			add("cook");
			
		}};
		
		
		locationNames.stream().forEach(x->{
			assertTrue(LocationService.exists(x));
		});
	}
}
