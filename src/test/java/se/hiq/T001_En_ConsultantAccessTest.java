package se.hiq;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/*=========================================================================================================
 * This test verify access to URL.
 *=======================================================================================================
 */
public class T001_En_ConsultantAccessTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#001, test URL and login check
	public void Test_001() {
		System.out.println("--------------------- Test#001 [Access to URL]---------------------");

		// login
		Functions.loginAsConsultant();

		// Check if login success by checking dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");

		// click on Sign out
		Functions.signOutAsConsultant();
		// Functions.driver.findElement(By.id("profileMenu")).click();
		// Functions.driver.findElement(By.id("navSignout")).click();
	}

	@AfterClass
	public static void afterTest() {
	}

}