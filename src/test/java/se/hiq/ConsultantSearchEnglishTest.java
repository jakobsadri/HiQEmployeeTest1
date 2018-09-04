package se.hiq;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*=========================================================================================================
 * test_008_1: verify consultant search function.
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. Go to search field and type "Java".
 * 3. Verify that test-user page contains "Java".
 * 4. Signout from the page.
 * 
 * test_008_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class ConsultantSearchEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantSearchEnglishTest.class);

	@BeforeClass
	public static void beforeTest() {

	}

	@Test
	public void test_008_1() throws InterruptedException {
		LOGGER.info("---------------------[Search Consultant] ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to My Search
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("consultantMenu")).click();
		Functions.driver.findElement(By.id("navSearch")).click();

		// Go to search and type "Java"
		WebElement profileBox1 = Functions.driver.findElement(By.id("searchInput"));
		profileBox1.clear();
		profileBox1.sendKeys("Java");
		profileBox1.sendKeys(Keys.RETURN);
		Thread.sleep(50);

		// Verify search result by searching "Java"
		String searchResult = Functions.driver
				.findElement(By.xpath(
						"//div[@class='d-flex flex-row  align-items-baseline flex-wrap justify-content-center']"))
				.getText();
		LOGGER.info(searchResult);
		assertTrue(searchResult.contains("Java"));

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_008_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();

		// Go to My Search
		Functions.driver.findElement(By.id("consultantMenu")).click();
		Functions.driver.findElement(By.id("navSearch")).click();

		// Verify language change en to sv
		Functions.verifyConsultantLanguage_en2sv("search");

		Thread.sleep(500);

		// Verify language change sv to en
		Functions.verifyConsultantLanguage_sv2en("search");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}
