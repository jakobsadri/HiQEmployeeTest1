package se.hiq;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.seleniumsimplified.webdriver.manager.Driver;
public class T_001_AccessTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#001, test URL and login check
	public void Test_001() {
		System.out.println("--------------------- Test#001 ---------------------");

		// call login funcktion
		Functions.login();

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");

		// click on Sign out
		Functions.driver.findElement(By.id("navbarDropdownMenuLink")).click();
		Functions.driver.findElement(By.xpath("//button[@class='dropdown-item color-hiq-yellow'][6]")).click();
		// driver.navigate().back();
	}

	@AfterClass
	public static void afterTest() {
	}

}