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
 * test_102_1: This test verify search function in manager-interface
 * 1. Open the HiQEmlpoyee URL by Login as Manager and verify dash page by checking dash-pages's title "HIQ Employees".
 * 2. Go to search page and search "Java".
 * 3. Verify search result by checking test-user have Java competence.
 * 4. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class ManagerSearchEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerSearchEnglishTest.class);

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	public void test_102_1() throws InterruptedException {
		LOGGER.info("--------------------- [Test Search function Manager En] ---------------------");

		// login
		Functions.loginAsManager_en();

		// Go to My Search
		Functions.driver.findElement(By.id("navSearch")).click();

		// Search "Java"
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
		Functions.signOutAsManager();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}
