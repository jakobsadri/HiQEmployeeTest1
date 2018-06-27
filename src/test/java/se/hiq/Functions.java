package se.hiq;
//import com.seleniumsimplified.webdriver.manager.Driver;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsimplified.webdriver.manager.Driver;

public class Functions {
	static WebDriver driver = Driver.get();
	public static String Hiq_url = "http://hiqemployee.northeurope.cloudapp.azure.com:8888";
	public static String Hiq_un = "fridab";
	public static String Hiq_pw = "1234";

	static void login() {

		// open URL
		driver.get(Hiq_url);
		// assertEquals("Assert initial page title", driver.getTitle(), "HIQ
		// Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(Hiq_un);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw);

		// click on login
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		// Check if login succsess by checking Dashboard title name
		// assertEquals("Assert initial page title", driver.getTitle(), "HIQ
		// Employees");

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}
}