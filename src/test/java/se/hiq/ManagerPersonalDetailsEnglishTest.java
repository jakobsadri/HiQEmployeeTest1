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

/*=========================================================================================================
 * test_103_1: verify Manager profile -> Personal details Manager English.
 * 1. Login as Manager and verify start page.
 * 2. Clean profile-fields and add new profile information.
 * 3. Save the information
 * 4. Signout from the page
 * 5. Login to the HiQEmployee page as Manager
 * 6. Verify added profile information is correct.
 * 7. Signout from the page
 * 8. Login to the HiQEmployee page as Manager
 * 9. Restore current profile information.
 * 10.Save the information
 * 11.Signout from the page
 * 
 * test_103_2: verify Manager profile -> Personal details Manager Swedish.
 * 1. Login as Manager and verify start page. 
 * 2. Clean profile-fields and add new profile information.
 * 3. Save the information
 * 4. Signout from the page
 * 5. Login to the HiQEmployee page as Manager
 * 6. Verify added profile information is correct.
 * 7. Signout from the page
 * 8. Login to the HiQEmployee page as Manager
 * 9. Restore current profile information.
 * 10.Save the information
 * 11.Signout from the page
 * 
 * test_103_3: Verify language changes
 * 1. Login as Manager and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class ManagerPersonalDetailsEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ManagerPersonalDetailsEnglishTest.class);

	String[] profileId = { "aboutMe", "firstName", "middleNames", "lastName", "dateOfBirth", "email", "phoneNumber" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "Manager of the HiCare consulting group.", "Test", "Nils", "Manager", "1960-02-02",
			"manager@hiq.se", "0700222244" };
	String[] profileTestName = { "Jag är en super Manager", "Manager_firstName", "Manager_middleNames",
			"Manager_lastName", "1970-05-11", "ManagerName@hiq.se", "0712345678" };
	// String[] profileCurrentName = new String[profileArraySize];

	@BeforeClass
	public static void beforeTest() {

	}

	@Test
	public void test_103_1() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> Personal details Manager English]---------------------");
		// Wait until action is done and find login button
		//WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.untilTimer_2);
		// login
		Functions.loginAsManager_en();
		
		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Clean profile-fields and add new profile information
		for (int i = 0; i <= profileArraySize - 1; i++) {
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
			Thread.sleep(100);
			profileBox1.clear();
			profileBox1.sendKeys(profileTestName[i]);
			Thread.sleep(100);
		}
		Thread.sleep(100);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("saveProfile")));

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("managerMenu")));
		Thread.sleep(6000);
		
		// click on Sign out
		Functions.signOutAsManager();

		// --------------------------------------------------
		// Verify new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsManager_en();

		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		
		// Click on Manager info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
			String profileBoxInfo = Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
			Thread.sleep(200);
			//LOGGER.info(profileBoxInfo);
			assertEquals("bypass", Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"), profileTestName[i]);
			LOGGER.info(profileBoxInfo + "  =  " + profileTestName[i]);
			Thread.sleep(200);
		}

		// click on Sign out
		Functions.signOutAsManager();

		// --------------------------------------------------
		// Restore the current profile info
		// --------------------------------------------------

		// login
		Functions.loginAsManager_en();

		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Restore current names
		for (int i2 = 0; i2 <= profileArraySize - 1; i2++) {
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i2]));
			Thread.sleep(50);
			profileBox1.clear();
			profileBox1.sendKeys(profileCurrentName[i2]);
		}
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("saveProfile")));
		Thread.sleep(100);

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();
				
		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("managerMenu")));
		Thread.sleep(6000);


		// click on Sign out
		Functions.signOutAsManager();
	}

	@Test
	public void test_103_2() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> Personal details Manager Swedish]---------------------");
		// Wait until action is done and find login button
		//WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.untilTimer_2);
		
		// login
		Functions.loginAsManager_sv();

		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Clean profile-fields and add new profile information
		for (int i = 0; i <= profileArraySize - 1; i++) {
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
			Thread.sleep(Functions.timer_300ms);
			profileBox1.clear();
			profileBox1.sendKeys(profileTestName[i]);
		}
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("saveProfile")));
		Thread.sleep(Functions.timer_300ms);

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();
		
		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("managerMenu")));
		Thread.sleep(Functions.timer_7s);
		// click on Sign out
		Functions.signOutAsManager();

		// --------------------------------------------------
		// Verify new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsManager_sv();

		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Click on Manager info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
			String profileBoxInfo = Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
			assertEquals("bypass", Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"),
					profileTestName[i]);
			LOGGER.info(profileBoxInfo + "  =  " + profileTestName[i]);
			Thread.sleep(100);
		}

		// click on Sign out
		Functions.signOutAsManager();

		// --------------------------------------------------
		// Restore the current profile info
		// --------------------------------------------------

		// login
		Functions.loginAsManager_sv();

		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Restore current names
		for (int i2 = 0; i2 <= profileArraySize - 1; i2++) {
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i2]));
			profileBox1.clear();
			profileBox1.sendKeys(profileCurrentName[i2]);
			Thread.sleep(100);
		}
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("saveProfile")));
		Thread.sleep(100);

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();


		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("managerMenu")));
		
		Thread.sleep(6000);

		// click on Sign out
		Functions.signOutAsManager();
	}

	@Test
	public void test_103_3() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");
		// Wait until action is done and find login button
		// login
		Functions.loginAsManager_en();
		
		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		
		// Verify language change en to sv
		Functions.verifyManagerLanguage_en2sv("profile");
		
		Thread.sleep(1000);
		
		// Verify language change sv to en
		Functions.verifyManagerLanguage_sv2en("profile");

		// click on Sign out
		Functions.signOutAsManager();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}