package com.revature.testcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.revature.dao.PirateDAO;
import com.revature.models.Pirate;
import com.revature.services.PirateService;

/**
 * @author DonatoManzione Tests for Pirate Services and, by extension, PirateDAO
 * 
 *         Methods are all static to share resources among them
 *
 */

public class PirateTests {

	private static PirateService pirateService;
	private static PirateDAO pirateDAO;
	private static Pirate testPirate;
	private static Pirate retrievalTestPirate;

	@BeforeAll
	public void initializeFields() {
		/**
		 * ASSEMBLE: initialize fields we will be using
		 *
		 */

		pirateDAO = new PirateDAO();

		pirateService = new PirateService(pirateDAO);
		testPirate = new Pirate("Test", "Pirate", "test@revaturepirate.cove", "12345678");

	}

	@Test
	public static void testGetAllPirates() {
		/**
		 * ACT: user pirateService and pirateDAO to retrieve all pirate records *
		 */

		List<Pirate> piratesTest = pirateService.getAllPirates();

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
	public static void testAddGetPirate() {
		/**
		 * ACT and ASSERT: add testPirate to database and assert that operation was
		 * successful
		 *
		 */

		assertTrue(pirateService.addPirate(testPirate));

	}

	@Test
	public static void testGetPirate() {
		/**
		 * ACT retrieve record
		 *
		 */
		retrievalTestPirate = pirateService.getPirateByEmail("test@revaturepirate.cove");

		testPirate = new Pirate("Test ", "Pirate", "test@revaturepirate.cove", "12345678");

		/**
		 * ASSERT two pirate objects have equal value
		 *
		 */
		assertEquals(retrievalTestPirate, testPirate);

	}

}
