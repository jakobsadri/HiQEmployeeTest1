package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*=========================================================================================================
 * test_101_1: This test verify access to URL and login as manager in English
 * 1. Open the URL:"http://hiqemployee.northeurope.cloudapp.azure.com:8888/en/login" 
 * 2. Login as Manager and verify dash page by checking dash-pages's title "HIQ Employees".
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 * 
 * test_101_2: This test verify access to URL and login as manager in Swedish
 * 1. Open the URL:"http://hiqemployee.northeurope.cloudapp.azure.com:8888/sv/login" 
 * 2. Login as Manager and verify dash page by checking dash-pages's title "HIQ Employees".
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */
public class ManagerAccessEnglishTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerAccessEnglishTest.class);

	@BeforeClass
	public static void beforeTest() {

	}

	@Test
	public void test_101_1() throws InterruptedException {
		LOGGER.info("--------------------- [Access to URL Manager En]---------------------");

		// login
		Functions.loginAsManager_en();

		// click on Sign out
		Functions.signOutAsManager();
	}

	// Test URL-Sv
	@Test
	// Test#001, test URL Sv and login check
	public void test_101_2() throws InterruptedException {
		LOGGER.info("--------------------- [Access to URL Manager Sv]---------------------");

		// login
		Functions.loginAsManager_sv();

		// click on Sign out
		Functions.signOutAsManager();
	}

	@AfterClass
	public static void afterTest() {
	}

}