package se.hiq;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.Driver.BrowserName;
import com.seleniumsimplified.webdriver.manager.EnvironmentPropertyReader;

/*=========================================================================================================
 * test_001_1: Verify access to URL and login as consultant English
 * 1. Open the URL:"http://hiqemployee.northeurope.cloudapp.azure.com:8888/en/login" 
 * 2. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 * 
 * test_001_2: Verify access to URL and login as consultant Swedish
 * 1. Open the URL:"http://hiqemployee.northeurope.cloudapp.azure.com:8888/sv/login" 
 * 2. Login as consultant and verify start page. Start page should contains words "profil" and "Uppgifter".
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 * 
 * test_001_3: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */
public class ConsultantAccessEnglishTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantAccessEnglishTest.class);

	@BeforeClass
	public static void beforeTest() {
		//EnvironmentPropertyReader.getPropertyOrEnv("GOOGLECHROME","FIREFOXMARIONETTE");
		
	}

	@Test
	public void test_001_1() throws InterruptedException {
		LOGGER.info("--------------------- [Access to Consultant URL English]---------------------");

		// login
		Functions.loginAsConsultant_en();

		// Verify consultant start-page
		String verify_text = Functions.driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']"))
				.getText();
		assertTrue(verify_text.contains("Profile") & verify_text.contains("Assignments"));

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_001_2() throws InterruptedException {
		LOGGER.info("--------------------- [Access to Consultant URL Swedish]---------------------");

		// login
		Functions.loginAsConsultant_sv();

		// Verify consultant start-page
		String verify_text = Functions.driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']"))
				.getText();
		assertTrue(verify_text.contains("Profil") & verify_text.contains("Uppgifter"));

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_001_3() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();

		// Verify language change en to sv
		Functions.verifyConsultantLanguage_en2sv("profile");

		// Verify language change sv to en
		Functions.verifyConsultantLanguage_sv2en("profile");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
	}

}