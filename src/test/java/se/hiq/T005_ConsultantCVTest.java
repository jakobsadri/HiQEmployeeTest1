package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class T005_ConsultantCVTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#003, check Import profile
	public void Test_007() {
		System.out.println("--------------------- Test#007 ---------------------");
		// login
		Functions.loginAsConsultant();

		// Go to My CV
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("navCv")).click();

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}