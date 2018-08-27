package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/*=========================================================================================================
 * This test verify access to URL and login as manager
 * 1. Open the URL:"http://hiqemployee.northeurope.cloudapp.azure.com:8888/en/login" 
 * 2. Login as Manager and verify dash page by checking dash-pages's title "HIQ Employees".
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */
public class Manager_En_AccessTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#001, test URL En and login check
	public void Test_101_1() throws InterruptedException {
		System.out.println("--------------------- [Access to URL Manager En]---------------------");

		// login
		Functions.loginAsManager_en();

		// click on Sign out
		Functions.signOutAsManager();

	}

	// Test URL-Sv
	@Test
	// Test#001, test URL Sv and login check
	public void Test_101_2() throws InterruptedException {
		System.out.println("--------------------- [Access to URL Manager Sv]---------------------");

		// login
		Functions.loginAsManager_sv();

		// click on Sign out
		Functions.signOutAsManager();

	}

	@AfterClass
	public static void afterTest() {
	}

}