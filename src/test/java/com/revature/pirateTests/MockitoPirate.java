package com.revature.pirateTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.models.Pirate;
import com.revature.services.PirateService;

public class MockitoPirate {

	private static PirateService pirateService;
	private static Pirate testPirate;
	private static Pirate retrievalTestPirate;

	@BeforeAll
	public static void initializeFields() {
		/**
		 * ASSEMBLE: initialize fields we will be using
		 *
		 */

		pirateService = mock(PirateService.class);

		testPirate = mock(Pirate.class);

	}

	@Test
	public void testGetAllPirates() {
		/**
		 * ACT: user pirateService and pirateDAO to retrieve all pirate records *
		 */

		List<Pirate> piratesTest = mock(List.class);

		/**
		 * ASSERT: that the list is neither empty nor null, print the records to the
		 * console for good measure
		 *
		 */
		assertNotNull(piratesTest);
		assertFalse(piratesTest.isEmpty());
		piratesTest.forEach(x -> System.out.println(x));

	}

	/**
	 * This testAddPirate test adds a new pirate with the object initialized in the
	 * initializeFields method
	 * 
	 * The testGetPirate test below retrieves the newly inserted record and tests it
	 * for equality with the testPirate object (the Pirate model overrides the
	 * equals() method from the Object class)
	 *
	 */
	@Test
	public void testAddGetPirate() {
		/**
		 * ACT and ASSERT: add testPirate to database and assert that operation was
		 * successful
		 *
		 */

		assertTrue(pirateService.addPirate(testPirate));

	}

	@Test
	public void testGetPirate() {
		/**
		 * ACT retrieve record
		 *
		 */
		retrievalTestPirate = pirateService.getPirateByEmail("dms902021@gmail.com");

		/**
		 * ASSERT two pirate objects have equal value
		 * 
		 */

		assertEquals(testPirate, retrievalTestPirate);
		System.out.println(retrievalTestPirate);

	}

}
