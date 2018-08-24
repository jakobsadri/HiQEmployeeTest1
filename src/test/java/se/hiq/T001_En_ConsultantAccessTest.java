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
	// Test#001, test URL En and login check
	public void Test_001_1() throws InterruptedException {
		System.out.println("--------------------- Test#001_1 [Access to URL En]---------------------");

		// login
		Functions.loginAsConsultant_En();

		// click on Sign out
		Functions.signOutAsConsultant();
		// Functions.driver.findElement(By.id("profileMenu")).click();
		// Functions.driver.findElement(By.id("navSignout")).click();
	}
	
	//Test URL-Sv
	@Test
	// Test#001, test URL Sv and login check
	public void Test_001_2() throws InterruptedException {
		System.out.println("--------------------- Test#001_2 [Access to URL Sv]---------------------");

		// login
		Functions.loginAsConsultant_Sv();

		// click on Sign out
		Functions.signOutAsConsultant();
		// Functions.driver.findElement(By.id("profileMenu")).click();
		// Functions.driver.findElement(By.id("navSignout")).click();
	}

	@AfterClass
	public static void afterTest() {
	}

}