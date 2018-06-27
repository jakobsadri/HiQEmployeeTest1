package se.hiq;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

//import com.seleniumsimplified.webdriver.manager.Driver;

public class T_002_DashboardTest {

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#002, check Dashboard
	public void Test_002() {
		System.out.println("--------------------- Test#002 ---------------------");
		// login
		Functions.login();

		// Go to My Profile
		//Functions.driver.findElement(By.id("navbarDropdownMenuLink")).click();
		//Functions.driver.findElement(By.xpath("//button[@class='header-logo'")).click();
		// Check if login succsess by checking Dashboard title name
		//assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");

		// click on Sign out
		Functions.driver.findElement(By.id("navbarDropdownMenuLink")).click();
		Functions.driver.findElement(By.xpath("//button[@class='dropdown-item color-hiq-yellow'][6]")).click();
	}

	@AfterClass
	public static void afterTest() {
	}

}
