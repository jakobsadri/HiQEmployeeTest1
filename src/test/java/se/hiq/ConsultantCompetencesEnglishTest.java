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
	// Test#002.3, check Profile ->> Competences
	public void test_004_1() throws InterruptedException {
		LOGGER.info("--------------------- Test#002.3 [Profile -> SKILLS] ---------------------");

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

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}