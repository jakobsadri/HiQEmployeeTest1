package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*=========================================================================================================
 * test_006_1: verify consultant assignments.
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. TBD....
 * 3. Signout from the page
 * 
 * test_006_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */
public class ConsultantAssignmentsEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantAssignmentsEnglishTest.class);

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	public void test_006_1() throws InterruptedException {
		LOGGER.info("--------------------- [Assignments Consultant] ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to My Assigment
		Functions.driver.findElement(By.id("navAssignments")).click();

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_006_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();

		// Go to My Assigment
		Functions.driver.findElement(By.id("navAssignments")).click();

		// Verify language change en to sv
		Functions.verifyLang_en2sv("assignments");

		// Verify language change sv to en
		Functions.verifyLang_sv2en("assignments");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}