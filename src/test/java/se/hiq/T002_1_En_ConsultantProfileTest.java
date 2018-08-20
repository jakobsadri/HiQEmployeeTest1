package se.hiq;

import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;

import com.gargoylesoftware.htmlunit.Page;


/*=========================================================================================================
 * This test verify consultant profile -> Personal details. The test case clean current profile info first, then 
 *  write new profile info. After verifying the written info, restore the current profile info.
 *=======================================================================================================
 */
public class T002_1_En_ConsultantProfileTest {
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
	public void Profile_002_1_Test() {
		System.out.println("--------------------- Test#002.1 [Profile -> Personal details]---------------------");

		// --------------------------------------------------
		// Add new profile info
		// --------------------------------------------------
		// login
		Functions.loginAsConsultant();

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Click on Consultant info, update info and save

		  //WebElement UploadImg = Functions.driver.findElement(By.id("profileImage"));
		  //UploadImg.click();
		  //UploadImg.sendKeys("C:/");
		  
		  //UploadImg.sendKeys("C:\\Home_2017\\HiQ_CV\\user-avatar.jpg");
		    //Functions.driver.setFileDetector(new LocalFileDetector());
		  
		 //Functions.driver.findElement(By.id("profileImage")).click();
//		 Functions.driver.findElement(By.id("imageBrowser")).sendKeys("C:\\Users\\jakobda\\image_1.jpg");
//		 Functions.driver.findElement(By.id("imageBrowser")).click();

	    //Functions.driver.findElement(By.id("imageBrowser")).click();

	  		
//			WebElement UploadImg = Functions.driver.findElement(By.id("profileImage"));
//			UploadImg.click();
//			WebElement profileImage = Functions.driver.findElement(By.id("imageBrowser"));
//		    profileImage.sendKeys("C:\\image_1.jpg");
		  
		 // Wait until the save-message is disappears
//			try {
//				Thread.sleep(7000);
//			} catch (InterruptedException ex) {
//				Thread.currentThread().interrupt();
//			}

		
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
		Functions.loginAsConsultant();

		// Go to My Profile
		Functions.driver.findElement(By.id("navProfile")).click();

		// Click on Consultant info, update info and save
		for (int i = 0; i <= profileArraySize - 1; i++) {
			String profileBoxInfo = Functions.driver.findElement(By.id(profileId[i])).getAttribute("value");
			assertEquals("bypass", Functions.driver.findElement(By.id(profileId[i])).getAttribute("value"),
					profileTestName[i]);
			System.out.println(profileBoxInfo + "  =  " + profileTestName[i]);
		}

		// click on Sign out
		Functions.signOutAsConsultant();

		// --------------------------------------------------
		// Restore the current profile info
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant();

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

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}