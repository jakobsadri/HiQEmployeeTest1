package se.hiq;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.Driver.BrowserName;
import com.seleniumsimplified.webdriver.manager.EnvironmentPropertyReader;

/*=========================================================================================================
 * test_201_1: Verify access to URL and login as admin English
 * 1. Open the URL:"http://hiqemployee.northeurope.cloudapp.azure.com:8888/en/login" 
 * 2. Login as admin and verify start page. Start page should contains words "profile" and "Assignments".
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 * 
 * test_201_2: Verify access to URL and login as admin Swedish
 * 1. Open the URL:"http://hiqemployee.northeurope.cloudapp.azure.com:8888/sv/login" 
 * 2. Login as admin and verify start page. Start page should contains words "profil" and "Uppgifter".
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 * 
 * test_201_3: Verify language changes
 * 1. Login as admin and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */
public class C1_AdminAccessEnglishTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(C1_AdminAccessEnglishTest.class);

	@BeforeClass
	public static void beforeTest() {
		// EnvironmentPropertyReader.getPropertyOrEnv("EDGE","EDGE");
		//Driver.set(BrowserName.EDGE);
	}

	@Test
	public void test_201_1() throws InterruptedException {
		LOGGER.info("--------------------- [Access to Admin URL English]---------------------");

		// login
		Functions.loginAsAdmin_en();

		// click on Sign out
		Functions.signOutAsAdmin();
	}

	@Test
	public void test_201_2() throws InterruptedException {
		LOGGER.info("--------------------- [Access to Admin URL Swedish]---------------------");

		// login
		Functions.loginAsAdmin_sv();

		// Verify admin start-page
		String verify_text = Functions.driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']"))
				.getText();
		assertTrue(verify_text.contains("Dashboard") & verify_text.contains("Sök"));

		// click on Sign out
		Functions.signOutAsAdmin();
	}

	@Test
	public void test_201_3() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language Admin]---------------------");
		
		
		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.timer_2s);

		// login
		Functions.loginAsAdmin_en();

		// Go to Search
		Functions.verifyLanguage_en2sv("adminMenu");
		
		// Verify language change sv to en
		Functions.verifyLanguage_sv2en("adminMenu");
	
		
		// click on Sign out
		Functions.signOutAsAdmin();
	}

	@AfterClass
	public static void afterTest() {
	}

}