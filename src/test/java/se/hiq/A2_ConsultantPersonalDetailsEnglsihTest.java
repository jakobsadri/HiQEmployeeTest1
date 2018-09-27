package se.hiq;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.Page;
import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.Driver.BrowserName;

/*=========================================================================================================
 * test_002_1: verify consultant profile -> Personal details Consultant English.
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. Clean profile-fields and add new profile information.
 * 3. Save the information
 * 4. Signout from the page
 * 5. Login to the HiQEmployee page as consultant
 * 6. Verify added profile information is correct.
 * 7. Signout from the page
 * 8. Login to the HiQEmployee page as consultant
 * 9. Restore current profile information.
 * 10.Save the information
 * 11.Signout from the page
 * 
 * test_002_2: verify consultant profile -> Personal details Consultant Swedish.
 * 1. Login as consultant and verify start page. Start page should contains words "profil" and "Uppgifter".
 * 2. Clean profile-fields and add new profile information.
 * 3. Save the information
 * 4. Signout from the page
 * 5. Login to the HiQEmployee page as consultant
 * 6. Verify added profile information is correct.
 * 7. Signout from the page
 * 8. Login to the HiQEmployee page as consultant
 * 9. Restore current profile information.
 * 10.Save the information
 * 11.Signout from the page
 * 
 * test_002_3: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class A2_ConsultantPersonalDetailsEnglsihTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(A2_ConsultantPersonalDetailsEnglsihTest.class);

	String[] profileId = { "aboutMe", "firstName", "middleNames", "lastName", "dateOfBirth", "email", "phoneNumber" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "Jag �r en super superutvecklare", "Adam", "Nils", "Larsson", "1970-01-01",
			"lars@hiq.se", "0700222233" };
	String[] profileTestName = { "Jag �r en super testare", "Consultant_firstName", "Consultant_middleNames",
			"Consultant_lastName", "1970-12-11", "cosultName@hiq.se", "0712345678" };
	// String[] profileCurrentName = new String[profileArraySize];

	@BeforeClass
	public static void beforeTest() {
		//Driver.set(BrowserName.EDGE);
	}

	@Test
	public void test_002_1() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> Personal details Consultant English]---------------------");
		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.untilTimer_2);

		// login
		Functions.loginAsConsultant_en();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personal Details")));
		
		// Go to personal details
		Functions.driver.findElement(By.linkText("Personal Details")).click();

		// Clean profile-fields and add new profile information
		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
			profileBox1.clear();
			profileBox1.sendKeys(profileTestName[i]);
		}
		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("consultantMenu")));
		Thread.sleep(Functions.timer_7s);
				
		// click on Sign out
		Functions.signOutAsConsultant();

		// --------------------------------------------------
		// Verify new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_en();
		
		// Wait until "Personal Details" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personal Details")));

		// Go to personal details
		Functions.driver.findElement(By.linkText("Personal Details")).click();

		// Click on Consultant info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			String profileBoxInfo = Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
			assertEquals("bypass", Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"),
					profileTestName[i]);
			LOGGER.info(profileBoxInfo + "  =  " + profileTestName[i]);
		}

		// click on Sign out
		Functions.signOutAsConsultant();

		// --------------------------------------------------
		// Restore the current profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

		// Wait until "Personal Details" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personal Details")));

		// Go to personal details
		Functions.driver.findElement(By.linkText("Personal Details")).click();;

		// Restore current names
		for (int i2 = 0; i2 <= profileArraySize - 1; i2++) {
			Thread.sleep(Functions.timer_100ms);
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i2]));
			profileBox1.clear();
			profileBox1.sendKeys(profileCurrentName[i2]);
		}

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("consultantMenu")));
		Thread.sleep(Functions.timer_7s);

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_002_2() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> Personal details Consultant Swedish]---------------------");
		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.untilTimer_2);

		// login
		Functions.loginAsConsultant_sv();
		
		// Wait until "Personal Details" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personliga detaljer")));

		// Go to personal details
		Functions.driver.findElement(By.linkText("Personliga detaljer")).click();

		// Clean profile-fields and add new profile information
		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
			profileBox1.clear();
			profileBox1.sendKeys(profileTestName[i]);
		}
		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("consultantMenu")));
		Thread.sleep(Functions.timer_7s);
		
		// click on Sign out
		Functions.signOutAsConsultant();

		// --------------------------------------------------
		// Verify new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_sv();

		// Wait until "Personal Details" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personliga detaljer")));

		// Go to personal details
		Functions.driver.findElement(By.linkText("Personliga detaljer")).click();

		// Click on Consultant info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			String profileBoxInfo = Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
			assertEquals("bypass", Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"),
					profileTestName[i]);
			LOGGER.info(profileBoxInfo + "  =  " + profileTestName[i]);
		}

		// click on Sign out
		Functions.signOutAsConsultant();

		// --------------------------------------------------
		// Restore the current profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_sv();

		// Wait until "Personal Details" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personliga detaljer")));

		// Go to personal details
		Functions.driver.findElement(By.linkText("Personliga detaljer")).click();

		// Restore current names
		for (int i2 = 0; i2 <= profileArraySize - 1; i2++) {
			Thread.sleep(Functions.timer_100ms);
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i2]));
			profileBox1.clear();
			profileBox1.sendKeys(profileCurrentName[i2]);
		}

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("consultantMenu")));
		Thread.sleep(Functions.timer_7s);

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_002_3() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");
		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.timer_2s);

		// login
		Functions.loginAsConsultant_en();
		
		// Wait until "Personal Details" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personal Details")));
		
		// Go to personal details
		Functions.driver.findElement(By.linkText("Personal Details")).click();
		
		// Verify language change sv to en
		Functions.verifyLanguage_en2sv("consultantMenu");
		
		// Verify language change sv to en
		Functions.verifyLanguage_sv2en("consultantMenu");

		// click on Sign out
		Functions.signOutAsConsultant();
			
	}

	@AfterClass
	public static void afterTest() {
		//Functions.driver.quit();
	}

}