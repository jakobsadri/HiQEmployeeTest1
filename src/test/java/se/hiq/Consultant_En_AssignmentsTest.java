package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class Consultant_En_AssignmentsTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#004, check Assignment
	public void Test_006_1() throws InterruptedException {
		System.out.println("--------------------- Test#004 ---------------------");
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