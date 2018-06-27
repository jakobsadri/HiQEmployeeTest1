package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class T_005_ImportProfileTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#003, check Import profile
	public void Test_007() {
		System.out.println("--------------------- Test#007 ---------------------");
		// login
		Functions.login();

		// Go to My Assigment
		Functions.driver.findElement(By.id("navbarDropdownMenuLink")).click();
		Functions.driver.findElement(By.xpath("//button[@class='dropdown-item color-hiq-yellow'][3]")).click();

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