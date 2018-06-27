package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class T_003_ProfileTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#003, check Profile
	public void Test_003() {
		System.out.println("--------------------- Test#003 ---------------------");
		// login
		Functions.login();

		// Go to My Profile
		Functions.driver.findElement(By.id("navbarDropdownMenuLink")).click();
		Functions.driver.findElement(By.xpath("//button[@class='dropdown-item color-hiq-yellow'][1]")).click();
		// driver.findElement(By.xpath("//button[@class='dropdown-item
		// color-hiq-yellow'][2]")).click();

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
