package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsultantCVEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantAccessEnglishTest.class);

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#003, check Import profile
	public void test_007_1() throws InterruptedException {
		LOGGER.info("--------------------- Test#007 ---------------------");
		// login
		Functions.loginAsConsultant_en();

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