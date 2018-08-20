package se.hiq;

import org.openqa.selenium.support.ui.Select;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/*=========================================================================================================
 * This test verify consultant profile -> HIQ. The test case clean current profile info first, then 
 *  write new profile info. After verifying the written info, restore the current profile info.
 *=======================================================================================================
 */
public class T002_2_En_ConsultantProfileTest {
	String[] profileId = { "consultantGroup", "title", "homeOffice", "startedInBranch", "startedAtCompany",
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
	// Test#002.2, check Profile ->> Personal info
	public void Profile_002_2_Test() {
		System.out.println("--------------------- Test#002.2 [Profile -> HIQ] ---------------------");

		// --------------------------------------------------
		// Add new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant();

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Click on Consultant info, update info and save

		for (int i = 0; i <= profileArraySize - 1; i++) {
			if (i == 0) {
				Functions.driver.findElement(By.id(profileId[i])).click();
				Select Profileoption = new Select(Functions.driver.findElement(By.id(profileId[i])));
				Profileoption.selectByVisibleText(profileTestName[i]);

			} else if (i == 2) {
				Functions.driver.findElement(By.id(profileId[i])).click();
				Select Profileoption = new Select(Functions.driver.findElement(By.id(profileId[i])));
				Profileoption.selectByVisibleText(profileTestName[i]);

			} else {
				WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
				profileBox1.clear();
				profileBox1.sendKeys(profileTestName[i]);
			}
		}

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
		 * // login Functions.loginAsConsultant();
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
		Functions.loginAsConsultant();

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Restore current names
		for (int i = 0; i <= profileArraySize - 1; i++) {
			if (i == 0) {
				Functions.driver.findElement(By.id(profileId[i])).click();
				Select Profileoption = new Select(Functions.driver.findElement(By.id(profileId[i])));
				Profileoption.selectByVisibleText(profileCurrentName[i]);

			} else if (i == 2) {
				Functions.driver.findElement(By.id(profileId[i])).click();
				Select Profileoption = new Select(Functions.driver.findElement(By.id(profileId[i])));
				Profileoption.selectByVisibleText(profileCurrentName[i]);

			} else {
				WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
				profileBox1.clear();
				profileBox1.sendKeys(profileCurrentName[i]);
			}
		}

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

	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}