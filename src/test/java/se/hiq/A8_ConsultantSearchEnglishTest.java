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
 * test_008_1: Verify search by consult profile
 * 
 * test_008_2: Verify search by consult competences
 * 
 * test_008_3: Verify search by customer
 * 
 * test_008_4: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class A8_ConsultantSearchEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(B4_ManagerSearchEnglishTest.class);

	String[] searchProfile = { "Adam", "Nils", "Larsson" };
	int searchItemArraySize = searchProfile.length;
	String[] searchProfileResutCompare = { "Adam", "Larsson", "Larsson" };

	String[] searchCompetences = { "s:Java", "s:safe" };
	int searchCompetencesArraySize = searchCompetences.length;
	String[] searchCompetencesResutCompare = { "Java", "SAFe" };
	
	String[] searchCustomer = { "c:Ericsson", "c:Scania", "c:Telenor","c:ViaSat"};
	int searchCustomerArraySize = searchCustomer.length;
	String[] searchCustomerResutCompare = { "Ericsson", "Scania", "Telenor", "ViaSat"};

	@BeforeClass
	public static void beforeTest() {

	}

	@Test // Search consultants profile
	public void test_008_1() throws InterruptedException {
		LOGGER.info("---------------------[Search Consultant] ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to Search
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("consultantMenu")).click();
		Functions.driver.findElement(By.id("navSearch")).click();

		// Search for consultant profile
		for (int i = 0; i <= searchItemArraySize - 1; i++) {

			WebElement profileBox1 = Functions.driver.findElement(By.id("searchInput"));
			profileBox1.clear();
			profileBox1.sendKeys(searchProfile[i]);
			profileBox1.sendKeys(Keys.RETURN);
			Thread.sleep(Functions.timer_1s);

			// Verify searching result
			WebElement searchResult = Functions.driver
					.findElement(By.xpath("//div[@class='card-body ng-star-inserted']"));
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
			Functions.driver.findElement(By.id("navProfile")).click();
			Functions.driver.findElement(By.id("consultantMenu")).click();
			Functions.driver.findElement(By.id("navSearch")).click();
		}
		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test // Search consultants competences
	public void test_008_2() throws InterruptedException {
		LOGGER.info("---------------------[Search Consultant] ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to Search
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("consultantMenu")).click();
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
					.findElement(By.xpath("//div[@class='card-body ng-star-inserted']"));
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
			Functions.driver.findElement(By.id("navProfile")).click();
			Functions.driver.findElement(By.id("consultantMenu")).click();
			Functions.driver.findElement(By.id("navSearch")).click();
		}
		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test // Search customer
	public void test_008_3() throws InterruptedException {
		LOGGER.info("---------------------[Search Consultant] ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to Search
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("consultantMenu")).click();
		Functions.driver.findElement(By.id("navSearch")).click();

		// Search for customer
		for (int i = 0; i <= searchCustomerArraySize - 1; i++) {

			WebElement profileBox1 = Functions.driver.findElement(By.id("searchInput"));
			profileBox1.clear();
			profileBox1.sendKeys(searchCustomer[i]);
			profileBox1.sendKeys(Keys.RETURN);
			Thread.sleep(Functions.timer_1s);

			// Go to consultant profile page
			 Functions.driver.findElement(By.xpath("//div[@class='card-body ng-star-inserted']")).click();
			Thread.sleep(Functions.timer_1s);

			// Validate search result
			WebElement searchResult2 = Functions.driver.findElement(By.id("assignments"));
			String str2 = searchResult2.getText();
			LOGGER.info("Search result:\n" + str2);
			assertTrue(str2.contains(searchCustomerResutCompare[i]));
			Thread.sleep(Functions.timer_1s);

			// Go back to Search
			Functions.driver.findElement(By.id("navProfile")).click();
			Functions.driver.findElement(By.id("consultantMenu")).click();
			Functions.driver.findElement(By.id("navSearch")).click();
		}
		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_008_4() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.timer_2s);

		// login
		Functions.loginAsConsultant_en();

		// Wait until "Search" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CV")));
		Functions.driver.findElement(By.id("consultantMenu")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("navSearch")));
		Functions.driver.findElement(By.id("navSearch")).click();

		// Go to Search
		Functions.verifyLanguage_en2sv("consultantMenu");

		// Verify language change sv to en
		Functions.verifyLanguage_sv2en("consultantMenu");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}
