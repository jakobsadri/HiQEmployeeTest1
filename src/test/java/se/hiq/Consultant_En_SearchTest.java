package se.hiq;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Consultant_En_SearchTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#003, check Generate CV
	public void Test_005() throws InterruptedException {
		System.out.println("--------------------- Test#005 ---------------------");
		// login
		Functions.loginAsConsultant_en();

		// Go to My Search
		Functions.driver.findElement(By.id("navProfile")).click();
		Functions.driver.findElement(By.id("consultantMenu")).click();
		Functions.driver.findElement(By.id("navSearch")).click();
		
		
		WebElement profileBox1 = Functions.driver.findElement(By.id("searchInput"));
		profileBox1.clear();
		profileBox1.sendKeys("Java");
		//Functions.driver.findElement(By.xpath("//[@class='io oi-magnifying-glass']")).click();
		profileBox1.sendKeys(Keys.RETURN);
		Thread.sleep(50);
		
		//Verify search result by searching "Java"
		String searchResult = Functions.driver.findElement(By.xpath("//div[@class='d-flex flex-row  align-items-baseline flex-wrap justify-content-center']")).getText();
		System.out.println(searchResult);
		assertTrue(searchResult.contains("Java")); 	


		
		
		

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}
