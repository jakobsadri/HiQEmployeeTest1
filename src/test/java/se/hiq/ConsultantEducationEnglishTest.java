package se.hiq;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*=========================================================================================================
 * test_005_1: verify consultant profile -> Education. TBD
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. TBD.....
 * 3. Signout from the page
 * 
 * test_005_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class ConsultantEducationEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantEducationEnglishTest.class);

	String[] profileId = { "", "title", "homeOffice", "startedInBranch", "startedAtCompany", "wantedAssignments" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "HICARE", "Utvecklare", "STOCKHOLM", "1994-11-01", "2014-09-12",
			"A brain surgeon" };
	String[] profileTestName = { "HICLOUD", "Testare", "MALMO", "2001-09-02", "2002-12-12", "Test" };
	// String[] profileCurrentName = new String[profileArraySize];

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	public void test_005_1() throws InterruptedException {
		System.out.println("---------------------[Profile -> Education] ---------------------");

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

	@Test
	public void test_005_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();

		// Go to Profile -> Education
		Functions.driver.findElement(By.id("ngb-tab-3")).click();

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