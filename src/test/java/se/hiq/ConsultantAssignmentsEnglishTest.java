package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsultantAssignmentsEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerAccessEnglishTest.class);

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#004, check Assignment
	public void test_006_1() throws InterruptedException {
		LOGGER.info("--------------------- Test#004 ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to My Assigment
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("navAssignments")).click();
	
		
		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}