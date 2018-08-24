package se.hiq;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/*=========================================================================================================
 * This test verify access to URL.
 *=======================================================================================================
 */
public class Manager_En_AccessTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#001, test URL En and login check
	public void Test_001_1() throws InterruptedException {
		System.out.println("--------------------- Test#001_1 [Access to URL Manager En]---------------------");

		// login
		Functions.loginAsManager_en();
		
		
		// click on Sign out
		Functions.signOutAsManager();

	}
	
	//Test URL-Sv
	@Test
	// Test#001, test URL Sv and login check
	public void Test_001_2() throws InterruptedException {
		System.out.println("--------------------- Test#001_2 [Access to URL Manager Sv]---------------------");

		// login
		Functions.loginAsManager_sv();

		
		// click on Sign out
		Functions.signOutAsManager();

	}

	@AfterClass
	public static void afterTest() {
	}

}