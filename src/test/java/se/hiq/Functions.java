package se.hiq;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

/*=========================================================================================================
 * This class contain some function that use often in test cases.
 *=======================================================================================================
 */
public class Functions {

	// -------------------------------------------------
	// Login info
	// -------------------------------------------------

	static WebDriver driver = Driver.get();
	public static String Hiq_url = "http://hiqemployee.northeurope.cloudapp.azure.com:8888";
	// public static String Hiq_url =
	// "http://hiqemployee.northeurope.cloudapp.azure.com:8888/en";
	// public static String Hiq_url =
	// "http://hiqemployee.northeurope.cloudapp.azure.com:8888/sv";
	public static String Hiq_un_consultant = "testconsultant";
	public static String Hiq_pw_consultant = "password";
	public static String Hiq_un_manager = "testmanager";
	public static String Hiq_pw_manager = "password";
	public static String Hiq_un_admin = "admin";
	public static String Hiq_pw_admin = "admin";

	// -------------------------------------------------
	// Login as consultant
	// -------------------------------------------------
	static void loginAsConsultant() {

		// open URL
		driver.get(Hiq_url);
		// assertEquals("Assert initial page title", driver.getTitle(), "HIQ
		// Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(Hiq_un_consultant);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw_consultant);

		// click on login
		driver.findElement(By.id("login")).click();
		// driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// Check if login succsess by checking Dashboard title name
		// assertEquals("Assert initial page title", driver.getTitle(), "HIQ
		// Employees");

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}

	// -------------------------------------------------
	// Login as manager
	// -------------------------------------------------
	static void loginAsManager() {

		// open URL
		driver.get(Hiq_url);
		// assertEquals("Assert initial page title", driver.getTitle(), "HIQ
		// Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(Hiq_un_manager);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw_manager);

		// click on login
		driver.findElement(By.id("login")).click();
		// Check if login succsess by checking Dashboard title name
		// assertEquals("Assert initial page title", driver.getTitle(), "HIQ
		// Employees");

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}

	// -------------------------------------------------
	// Login as admin
	// -------------------------------------------------
	static void loginAsAdmin() {

		// open URL
		driver.get(Hiq_url);
		// assertEquals("Assert initial page title", driver.getTitle(), "HIQ
		// Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(Hiq_un_admin);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw_admin);

		// click on login
		driver.findElement(By.id("login")).click();
		// Check if login succsess by checking Dashboard title name
		// assertEquals("Assert initial page title", driver.getTitle(), "HIQ
		// Employees");

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}

	// -------------------------------------------------
	// Sign out as consultant
	// -------------------------------------------------
	static void signOutAsConsultant() {

		// click on Sign out
		driver.findElement(By.id("consultantMenu")).click();

		driver.findElement(By.id("navSignout")).click();
	}

}