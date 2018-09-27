package se.hiq;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*=========================================================================================================
 * test_104_1: verify Manager profile -> HIQ Manager Engilsh.
 * 1. Login as Manager and verify start page.
 * 2. Clean some profile-fields and add/choose new profile information.
 * 3. Save the information
 * 4. Signout from the page
 * 5. Login to the HiQEmployee page as Manager
 * 6. Verify added/chosen profile information are correct.
 * 7. Signout from the page
 * 8. Login to the HiQEmployee page as Manager
 * 9. Restore current profile information.
 * 10. Save the information
 * 11. Signout from the page
 * 
 * test_104_2: verify Manager profile -> HIQ Manager Swedish.
 * 1. Login as Manager and verify start page.
 * 2. Clean some profile-fields and add/choose new profile information.
 * 3. Save the information
 * 4. Signout from the page
 * 5. Login to the HiQEmployee page as Manager
 * 6. Verify added/chosen profile information are correct.
 * 7. Signout from the page
 * 8. Login to the HiQEmployee page as Manager
 * 9. Restore current profile information.
 * 10. Save the information
 * 11. Signout from the page
 * 
 * test_104_3: Verify language changes
 * 1. Login as Manager and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class B3_ManagerHiQEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(B3_ManagerHiQEnglishTest.class);

	String[] profileId = { "consultantGroup", "homeOffice", "startedInBranch", "startedAtCompany" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "Hipe", "STOCKHOLM", "1994-04-01", "2014-09-11" };
	String[] profileTestName = { "MarkIT", "MALMO", "2002-09-02", "2004-12-12" };
	// item by value (MarkIT = 11), Posation 11
	String[] profileTestName1 = { "11", "MALMO", "2002-09-02", "2004-12-12" };

	// String[] profileCurrentName = new String[profileArraySize];

	@BeforeClass
	public static void beforeTest() {

	}

	@Test
	public void test_104_1() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> HIQ Manager English] ---------------------");
		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.untilTimer_2);

		// --------------------------------------------------
		// Add new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsManager_en();

		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("ngb-tab-1")));

		// Go to Profile ->HiQ
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Click on Manager info, update info and save

		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			if (i == 0 || i == 1) {
				Functions.driver.findElement(By.id(profileId[i])).click();
				Select Profileoption = new Select(Functions.driver.findElement(By.id(profileId[i])));
				Profileoption.selectByVisibleText(profileTestName[i]);

			} else {
				WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
				profileBox1.clear();
				profileBox1.sendKeys(profileTestName[i]);
			}
			Thread.sleep(Functions.timer_100ms);
		}

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
		Functions.loginAsManager_en();

		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ngb-tab-1")));

		// Go to Profile ->HiQ
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Click on Manager info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			String profileBoxInfo = Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
			assertEquals("bypass", Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"),
					profileTestName1[i]);
			LOGGER.info(profileBoxInfo + "  =  " + profileTestName1[i]);
			Thread.sleep(Functions.timer_100ms);
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
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ngb-tab-1")));

		// Go to Profile ->HiQ
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Restore current names
		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			if (i == 0 || i == 1) {
				Functions.driver.findElement(By.id(profileId[i])).click();
				Select Profileoption = new Select(Functions.driver.findElement(By.id(profileId[i])));
				Profileoption.selectByVisibleText(profileCurrentName[i]);

			} else {
				WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
				profileBox1.clear();
				profileBox1.sendKeys(profileCurrentName[i]);
			}
			Thread.sleep(Functions.timer_100ms);
		}

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("managerMenu")));
		Thread.sleep(Functions.timer_7s);

		// click on Sign out
		Functions.signOutAsManager();
	}

	@Test
	public void test_104_2() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> HIQ Manager Swedish] ---------------------");
		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.untilTimer_1);

		// --------------------------------------------------
		// Add new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsManager_sv();

		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ngb-tab-1")));

		// Go to Profile ->HiQ
		Functions.driver.findElement(By.id("ngb-tab-1")).click();
		

		// Click on Manager info, update info and save

		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_1s);
			if (i == 0 || i == 1) {
				Functions.driver.findElement(By.id(profileId[i])).click();
				Select Profileoption = new Select(Functions.driver.findElement(By.id(profileId[i])));
				Profileoption.selectByVisibleText(profileTestName[i]);

			} else {
				WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
				profileBox1.clear();
				profileBox1.sendKeys(profileTestName[i]);
			}
		}

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

		// Go to Profile ->HiQ
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Click on Manager info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			String profileBoxInfo = Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
			assertEquals("bypass", Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"),
					profileTestName1[i]);
			LOGGER.info(profileBoxInfo + "  =  " + profileTestName1[i]);
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

		wait.until(ExpectedConditions.elementToBeClickable(By.id("ngb-tab-1")));

		// Go to Profile ->HiQ
		Functions.driver.findElement(By.id("ngb-tab-1")).click();

		// Restore current names
		for (int i = 0; i <= profileArraySize - 1; i++) {
			Thread.sleep(Functions.timer_100ms);
			if (i == 0 || i == 1) {
				Functions.driver.findElement(By.id(profileId[i])).click();
				Select Profileoption = new Select(Functions.driver.findElement(By.id(profileId[i])));
				Profileoption.selectByVisibleText(profileCurrentName[i]);

			} else {
				WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
				profileBox1.clear();
				profileBox1.sendKeys(profileCurrentName[i]);
			}
			Thread.sleep(Functions.timer_1s);
		}

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("managerMenu")));
		Thread.sleep(Functions.timer_7s);

		// click on Sign out
		Functions.signOutAsManager();
	}

	@Test
	public void test_104_3() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language Manager]---------------------");
		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.timer_2s);

		// login
		Functions.loginAsManager_en();
		
		// Go to Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Personal Details")));
		
		Functions.driver.findElement(By.linkText("HiQ")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("HiQ")));

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