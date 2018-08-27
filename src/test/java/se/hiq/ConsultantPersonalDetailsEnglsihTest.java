package se.hiq;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.Page;

/*=========================================================================================================
 * test_002_1: verify consultant profile -> Personal details.
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. Modify profile image and verify changes...TBD
 * 3. Clean profile-fields and add new profile information.
 * 4. Save the information
 * 5. Signout from the page
 * 6. Login to the HiQEmployee page as consultant
 * 7. Verify added profile information is correct.
 * 8. Signout from the page
 * 9. Login to the HiQEmployee page as consultant
 * 10. Restore current profile information.
 * 11. Save the information
 * 12.Signout from the page
 * 
 * test_002_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class ConsultantPersonalDetailsEnglsihTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantAccessEnglishTest.class);

	String[] profileId = { "aboutMe", "firstName", "middleNames", "lastName", "dateOfBirth", "email", "phoneNumber" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "Jag är en super superutvecklare", "Adam", "Nils", "Larsson", "1970-01-01",
			"lars@hiq.se", "0700222233" };
	String[] profileTestName = { "Jag är en super testare", "Consultant_firstName", "Consultant_middleNames",
			"Consultant_lastName", "1970-12-11", "cosultName@hiq.se", "0712345678" };
	// String[] profileCurrentName = new String[profileArraySize];

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#002.1, check Profile ->> Personal info
	public void test_002_1() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> Personal details]---------------------");

		// login
		Functions.loginAsConsultant_en();
		
		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();
		
		// --------------------------------------------------
		// Add new profile image TBD
		// --------------------------------------------------

		// Click on Consultant info, update info and save

		// WebElement UploadImg = Functions.driver.findElement(By.id("profileImage"));
		// UploadImg.click();
		// UploadImg.sendKeys(Keys.RETURN);
		// Thread.sleep(500);
		// UploadImg.sendKeys("C:/");

		// UploadImg.sendKeys("C:\\Home_2017\\HiQ_CV\\user-avatar.jpg");
		// Functions.driver.setFileDetector(new LocalFileDetector());

		// Functions.driver.findElement(By.id("profileImage")).click();
		// Functions.driver.findElement(By.id("imageBrowser")).sendKeys("C:\\Users\\jakobda\\image_1.jpg");
		// Functions.driver.findElement(By.id("imageBrowser")).click();

		// Functions.driver.findElement(By.id("imageBrowser")).click();

		// WebElement UploadImg = Functions.driver.findElement(By.id("profileImage"));
		// UploadImg.click();
		// WebElement profileImage =
		// Functions.driver.findElement(By.id("imageBrowser"));
		// profileImage.sendKeys("C:\\image_1.jpg");

		// Wait until the save-message is disappears
		// try {
		// Thread.sleep(7000);
		// } catch (InterruptedException ex) {
		// Thread.currentThread().interrupt();
		// }

		// Clean profile-fields and add new profile information
		for (int i = 0; i <= profileArraySize - 1; i++) {
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i]));
			profileBox1.clear();
			profileBox1.sendKeys(profileTestName[i]);
		}
		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		try {
			Thread.sleep(7000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		// click on Sign out
		Functions.signOutAsConsultant();

		// --------------------------------------------------
		// Verify new profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Click on Consultant info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
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

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Restore current names
		for (int i2 = 0; i2 <= profileArraySize - 1; i2++) {
			WebElement profileBox1 = Functions.driver.findElement(By.id(profileId[i2]));
			profileBox1.clear();
			profileBox1.sendKeys(profileCurrentName[i2]);
		}

		// Save info
		Functions.driver.findElement(By.id("saveProfile")).click();

		// Wait until the save-message is disappears
		try {
			Thread.sleep(6000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_002_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();

		// Verify language change en to sv
		Functions.verifyLang_en2sv("profile");

		// Verify language change sv to en
		Functions.verifyLang_sv2en("profile");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}