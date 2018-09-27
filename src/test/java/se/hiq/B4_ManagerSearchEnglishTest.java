package se.hiq;

import static org.junit.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*=========================================================================================================
 * test_102_1: This test verify search function in manager-interface by Manager profile
 * 
 * test_102_2: This test verify search function in manager-interface by  competences
 * 
 * test_102_3: This test verify search function in manager-interface by customer
 * 
 * test_102_4: Verify language changes
 * 1. Open the HiQEmlpoyee URL by Login as Manager and verify dash page by checking dash-pages's title "HIQ Employees".
 * 2. Go to search page and search "Java".
 * 3. Verify search result by checking test-user have Java competence.
 * 4. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class B4_ManagerSearchEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(B4_ManagerSearchEnglishTest.class);

	String[] searchProfile = { "Test", "Titi", "Manager" };
	int searchItemArraySize = searchProfile.length;
	String[] searchProfileResutCompare = { "Test", "Manager", "Manager" };

	String[] searchCompetences = { "s:Java", "s:safe" };
	int searchCompetencesArraySize = searchCompetences.length;
	String[] searchCompetencesResutCompare = { "Java", "SAFe" };

	String[] searchCustomer = { "c:Ericsson", "c:Scania", "c:Telenor", "c:ViaSat" };
	int searchCustomerArraySize = searchCustomer.length;
	String[] searchCustomerResutCompare = { "Ericsson", "Scania", "Telenor", "ViaSat" };

	@BeforeClass
	public static void beforeTest() {

	}

	@Test
	public void test_102_1() throws InterruptedException {
		LOGGER.info("--------------------- [Test Search function Manager En] ---------------------");

		// login
		Functions.loginAsManager_en();

		// Go to Search
		Functions.driver.findElement(By.id("navSearch")).click();

		// Search for consultant profile
		for (int i = 0; i <= searchItemArraySize - 1; i++) {

			WebElement profileBox1 = Functions.driver.findElement(By.id("searchInput"));
			profileBox1.clear();
			profileBox1.sendKeys(searchProfile[i]);
			profileBox1.sendKeys(Keys.RETURN);
			Thread.sleep(Functions.timer_1s);

			// Verify searching result
			WebElement searchResult = Functions.driver.findElement(By.xpath("//div[@class='d-flex flex-row align-items-start flex-column']"));
			String str = searchResult.getText();
			LOGGER.info("Search result:\n" + str);
			assertTrue(str.contains(searchProfileResutCompare[i]));

			searchResult.click();
			Thread.sleep(Functions.timer_1s);
			WebElement searchResult2 = Functions.driver.findElement(By.xpath("//div[@class='col-md-8 pt-3']"));
			String str2 = searchResult2.getText();
			LOGGER.info("Search result:\n" + str2);
			assertTrue(str.contains(searchProfileResutCompare[i]));

			// Go back to Search
			Functions.driver.findElement(By.id("navSearch")).click();
		}
		// click on Sign out
		Functions.signOutAsManager();
	}

	@Test // Search consultants competences
	public void test_102_2() throws InterruptedException {
		LOGGER.info("---------------------[Search Consultant] ---------------------");
		// login
		Functions.loginAsManager_en();

		// Go to Search
		Functions.driver.findElement(By.id("navSearch")).click();

		// Search consultant competences
		for (int i = 0; i <= searchCompetencesArraySize - 1; i++) {

			WebElement profileBox1 = Functions.driver.findElement(By.id("searchInput"));
			profileBox1.clear();
			profileBox1.sendKeys(searchCompetences[i]);
			profileBox1.sendKeys(Keys.RETURN);
			Thread.sleep(Functions.timer_1s);

			// Validate search result
			WebElement searchResult = Functions.driver
					.findElement(By.xpath("//div[@class='d-flex flex-row  align-items-baseline flex-wrap justify-content-center']"));
			String str = searchResult.getText();
			LOGGER.info("Search result:\n" + str);
			assertTrue(str.contains(searchCompetencesResutCompare[i]));

			searchResult.click();
			Thread.sleep(Functions.timer_1s);
			WebElement searchResult2 = Functions.driver.findElement(By.xpath("//div[@class='col-md-8 pt-3']"));
			String str2 = searchResult2.getText();
			LOGGER.info("Search result:\n" + str2);
			assertTrue(str.contains(searchCompetencesResutCompare[i]));

			// Go back to Search
			Functions.driver.findElement(By.id("navSearch")).click();
		}
		// click on Sign out
		Functions.signOutAsManager();
	}

	@Test // Search customer
	public void test_102_3() throws InterruptedException {
		LOGGER.info("---------------------[Search Consultant] ---------------------");
		// login
		Functions.loginAsManager_en();

		// Go to Search
		Functions.driver.findElement(By.id("navSearch")).click();

		// Search for customer
		for (int i = 0; i <= searchCustomerArraySize - 1; i++) {

			WebElement profileBox1 = Functions.driver.findElement(By.id("searchInput"));
			profileBox1.clear();
			profileBox1.sendKeys(searchCustomer[i]);
			profileBox1.sendKeys(Keys.RETURN);
			Thread.sleep(Functions.timer_1s);

			// Go to consultant profile page
			Functions.driver.findElement(By.xpath("//div[@class='d-flex flex-row align-items-start flex-column']")).click();
			Thread.sleep(Functions.timer_1s);

			// Validate search result
			WebElement searchResult2 = Functions.driver.findElement(By.id("assignments"));
			String str2 = searchResult2.getText();
			LOGGER.info("Search result:\n" + str2);
			assertTrue(str2.contains(searchCustomerResutCompare[i]));
			Thread.sleep(Functions.timer_1s);

			// Go back to Search
			Functions.driver.findElement(By.id("navSearch")).click();
		}
		// click on Sign out
		Functions.signOutAsManager();
	}

	@Test
	public void test_102_4() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.timer_2s);

		// login
		Functions.loginAsManager_en();

		// Wait until "Search" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Search")));
		Functions.driver.findElement(By.id("navSearch")).click();

		// Go to Search
		Functions.verifyLanguage_en2sv("managerMenu");

		// Verify language change sv to en
		Functions.verifyLanguage_sv2en("managerMenu");

		// click on Sign out
		Functions.signOutAsManager();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}
