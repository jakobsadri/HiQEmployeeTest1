package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class T_007_SearchingTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#003, check Searching
	public void Test_006() {
		System.out.println("--------------------- Test#006 ---------------------");
		// login
		Functions.login();

		// Go to My Assigment
		Functions.driver.findElement(By.id("navbarDropdownMenuLink")).click();
		Functions.driver.findElement(By.xpath("//button[@class='dropdown-item color-hiq-yellow'][5]")).click();

		// click on Sign out
		Functions.driver.findElement(By.id("navbarDropdownMenuLink")).click();
		Functions.driver.findElement(By.xpath("//button[@class='dropdown-item color-hiq-yellow'][6]")).click();
		// driver.navigate().back();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}
