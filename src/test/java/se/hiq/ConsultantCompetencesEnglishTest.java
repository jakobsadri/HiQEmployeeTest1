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
 * test_004_1: verify consultant profile -> Competences. TBD
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 
 * 11.Signout from the page
 * 
 * test_004_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

/*=========================================================================================================
 * This test verify consultant profile -> Competences.... TBD
 *=======================================================================================================
 */
public class ConsultantCompetencesEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerAccessEnglishTest.class);

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
	// Test#002.3, check Profile -> Competences
	public void test_004_1() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> SKILLS] ---------------------");

		// --------------------------------------------------
		// Add new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("ngb-tab-2")).click();

		// Click on Consultant info, update info and save


		// --------------------------------------------------
		// Verify new profile info
		// --------------------------------------------------

		
		// --------------------------------------------------
		// Restore the current profile info
		// --------------------------------------------------
		
		
	
		// click on Sign out
		Functions.signOutAsConsultant();
		
	}
	@Test
	public void test_004_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();
		
		// Go to Profile-Competences
		Functions.driver.findElement(By.id("ngb-tab-2")).click();

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