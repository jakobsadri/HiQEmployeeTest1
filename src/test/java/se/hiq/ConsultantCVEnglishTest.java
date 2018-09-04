package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*=========================================================================================================
 * test_007_1: verify consultant CV Export-button.
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. Click Extport button
 * 3. Signout from the page
 * 
 * test_007_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */
public class ConsultantCVEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantCVEnglishTest.class);

	@BeforeClass
	public static void beforeTest() {

	}

	@Test
	public void test_007_1() throws InterruptedException {
		LOGGER.info("--------------------- [CV Export Consultant English] ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to CV
		Functions.driver.findElement(By.id("navCv")).click();

		// Export CV
		Functions.driver.findElement(By.xpath("//button[@class='btn btn-primary mt-3 mb-3']")).click();
		Thread.sleep(500);

		// click on Sign out
		Functions.signOutAsConsultant();
	}
	
	@Test
	public void test_007_2() throws InterruptedException {
		LOGGER.info("--------------------- [CV Export Consultant Swedish] ---------------------");
		// login
		Functions.loginAsConsultant_sv();

		// Go to CV
		Functions.driver.findElement(By.id("navCv")).click();

		// Export CV
		Functions.driver.findElement(By.xpath("//button[@class='btn btn-primary mt-3 mb-3']")).click();
		Thread.sleep(500);

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_007_3() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();

		// Go to My Assigment
		Functions.driver.findElement(By.id("navCv")).click();

		// Verify language change en to sv
		Functions.verifyConsultantLanguage_en2sv("cv");

		// Verify language change sv to en
		Functions.verifyConsultantLanguage_sv2en("cv");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}