package se.hiq;

import org.openqa.selenium.support.ui.Select;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/*=========================================================================================================
 * This test verify consultant profile -> Education. The test case add new education, course and certificate. 
 * Verify them. The test case verify delete-buttons by removing added education, course and certificate.
 * Verify them.
 *=======================================================================================================
 */
public class Consultant_En_EducationTest {
	String[] profileId = { "", "title", "homeOffice", "startedInBranch", "startedAtCompany",
			"wantedAssignments" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "HICARE", "Utvecklare", "STOCKHOLM", "1994-11-01", "2014-09-12",
			"A brain surgeon" };
	String[] profileTestName = { "HICLOUD", "Testare", "MALMO", "2001-09-02", "2002-12-12", "Test" };
	// String[] profileCurrentName = new String[profileArraySize];

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#002.4, check Profile ->> Personal info
	public void Profile_005_1() throws InterruptedException {
		System.out.println("--------------------- Test#002.4 [Profile -> Education] ---------------------");

		// --------------------------------------------------
		// Add new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("ngb-tab-3")).click();

		// Click on Consultant info, update info and save
		
		Functions.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		WebElement profileBox1 = Functions.driver.findElement(By.id("fe0"));
		profileBox1.clear();
		profileBox1.sendKeys("System Communicaton at KTH");
		
		
		//Functions.driver.findElement(By.xpath("class='input-group-text'")).click();


		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		try {
			Thread.sleep(7000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		
		
		
		
		// click on Sign out
		Functions.signOutAsConsultant();

		// --------------------------------------------------
		// Verify new profile info
		// --------------------------------------------------

		/*
		 * // login Functions.loginAsConsultant_en();
		 * 
		 * // Go to My Profile
		 * Functions.driver.findElement(By.id("navProfile")).click();
		 * Functions.driver.findElement(By.id("ngb-tab-1")).click();
		 * 
		 * // Click on Consultant info, update info and save for (int i = 0; i <=
		 * profileArraySize - 1; i++) { String profileBoxInfo =
		 * Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
		 * assertEquals("bypass",
		 * Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"),
		 * profileTestName[i]); System.out.println(profileBoxInfo+ "  =  "+
		 * profileTestName[i]); }
		 * 
		 * // click on Sign out Functions.signOutAsConsultant();
		 */
		// --------------------------------------------------
		// Restore the current profile info
		// --------------------------------------------------

		// login 
		
		Functions.loginAsConsultant_en();
		
		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("ngb-tab-3")).click();

		
			
		// click on Sign out
		Functions.signOutAsConsultant();
		
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}