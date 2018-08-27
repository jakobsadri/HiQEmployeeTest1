package se.hiq;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*=========================================================================================================
 * test_003_1: verify consultant profile -> HIQ.
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. Clean some profile-fields and add/choose new profile information.
 * 3. Save the information
 * 4. Signout from the page
 * 5. Login to the HiQEmployee page as consultant
 * 6. Verify added/chosen profile information are correct.
 * 7. Signout from the page
 * 8. Login to the HiQEmployee page as consultant
 * 9. Restore current profile information.
 * 10. Save the information
 * 11.Signout from the page
 * 
 * test_003_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class ConsultantHiQEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantAccessEnglishTest.class);

	String[] profileId = { "consultantGroup", "title", "homeOffice", "startedInBranch", "startedAtCompany",
			"wantedAssignments" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "Hipe", "Developer", "STOCKHOLM", "1994-11-01", "2014-09-12", "A brain surgeon" };
	String[] profileTestName = { "MarkIT", "Tester", "MALMO", "2001-09-02", "2002-12-12", "Test" };
	// item by value (MarkIT = 11), Posation 11
	String[] profileTestName1 = { "11", "Tester", "MALMO", "2001-09-02", "2002-12-12", "Test" };

	// String[] profileCurrentName = new String[profileArraySize];

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#002.2, check Profile ->> Personal info
	public void test_003_1() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> HIQ] ---------------------");

		// --------------------------------------------------
		// Add new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

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

		// login
		Functions.loginAsConsultant_en();

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Click on Consultant info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
			String profileBoxInfo = Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
			assertEquals("bypass", Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"),
					profileTestName1[i]);
			LOGGER.info(profileBoxInfo + "  =  " + profileTestName1[i]);
		}

		// click on Sign out
		Functions.signOutAsConsultant();

		// --------------------------------------------------
		// Restore the current profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

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

	@Test
	public void test_003_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();
		
		// Go to My Profile->HiQ
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Verify language change en to sv
		Functions.verifyLang_en2sv("profile");

		// Verify language change sv to en
		Functions.verifyLang_sv2en("profile");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}