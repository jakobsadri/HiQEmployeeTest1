package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*=========================================================================================================
 * test_009_1: verify consultant Import CV button.
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. Click Import button
 * 3. Signout from the page
 * 
 * test_009_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */
public class ConsultantImportCVEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantImportCVEnglishTest.class);

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	public void test_009_1() throws InterruptedException {
		LOGGER.info("--------------------- [Import CV Consultant] ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to My Search
		Functions.driver.findElement(By.id("consultantMenu")).click();
		Functions.driver.findElement(By.id("navImport")).click();

		// Click import
		WebElement importButon = Functions.driver.findElement(By.id("fileUpload"));
		// importButon.click();
		importButon.sendKeys(Keys.RETURN);

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_009_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();

		// Go to My Search
		Functions.driver.findElement(By.id("consultantMenu")).click();
		Functions.driver.findElement(By.id("navImport")).click();

		// Verify language change en to sv
		Functions.verifyLang_en2sv("import");

		Thread.sleep(500);

		// Verify language change sv to en
		Functions.verifyLang_sv2en("import");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}
