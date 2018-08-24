package se.hiq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

/*=========================================================================================================
 * This test verify access to URL.
 *=======================================================================================================
 */
public class Consultant_En_AccessTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#001, test URL En and login check
	public void Test_001_1() throws InterruptedException {
		System.out.println("--------------------- Test#001_1 [Access to URL En]---------------------");

		// login
		Functions.loginAsConsultant_en();
		
		
		//Verify 
		String verify_text = Functions.driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
		System.out.println(verify_text);
		assertTrue(verify_text.contains("Profile") & verify_text.contains("Assignments")); 	
		
		//Verify language change en to sv
		Functions.verifyLang_en2sv();
		
		//Verify language change sv to en
		Functions.verifyLang_sv2en();				
		
		// click on Sign out
		Functions.signOutAsConsultant();

	}
	
	//Test URL-Sv
	@Test
	// Test#001, test URL Sv and login check
	public void Test_001_2() throws InterruptedException {
		System.out.println("--------------------- Test#001_2 [Access to URL Sv]---------------------");

		// login
		Functions.loginAsConsultant_sv();
		
		//Verify 
		String verify_text = Functions.driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
		System.out.println(verify_text);
		assertTrue(verify_text.contains("Profil") & verify_text.contains("Uppgifter")); 

		
		

		
		
		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
	}

}