package se.hiq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seleniumsimplified.webdriver.manager.Driver;

/*=========================================================================================================
 * This class contain some function that use often in test cases.
 *=======================================================================================================
 */
public class Functions {

	private static final Logger LOGGER = LoggerFactory.getLogger(Functions.class);

	// -------------------------------------------------
	// Login info
	// -------------------------------------------------

	static WebDriver driver = Driver.get();
	public static String Hiq_url_en = "http://hiqemployee.northeurope.cloudapp.azure.com:8888/en/login";
	public static String Hiq_url_sv = "http://hiqemployee.northeurope.cloudapp.azure.com:8888/sv/login";
	public static String Hiq_un_consultant = "testconsultant";
	public static String Hiq_pw_consultant = "password";
	public static String Hiq_un_manager = "testmanager";
	public static String Hiq_pw_manager = "password";
	public static String Hiq_un_admin = "admin";
	public static String Hiq_pw_admin = "admin";

	// -------------------------------------------------
	// Login as consultant En
	// -------------------------------------------------
	static void loginAsConsultant_en() throws InterruptedException {

		// open URL
		driver.get(Hiq_url_en);
		Thread.sleep(50);
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(Hiq_un_consultant);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw_consultant);

		// click on login
		driver.findElement(By.id("login")).click();

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}

	// -------------------------------------------------
		// Login as consultant Sv
		// -------------------------------------------------
		static void loginAsConsultant_sv() throws InterruptedException {

			// open URL
			
			driver.get(Hiq_url_sv);
			Thread.sleep(50);
			assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

			// Write username and password
			WebElement nameBox1 = driver.findElement(By.name("username"));
			nameBox1.sendKeys(Hiq_un_consultant);
			WebElement nameBox2 = driver.findElement(By.name("password"));
			nameBox2.sendKeys(Hiq_pw_consultant);

			// click on login
			driver.findElement(By.id("login")).click();

			// Check if login succsess by checking Dashboard title name
			assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
		}

		
	// -------------------------------------------------
	// Login as manager En
	// -------------------------------------------------
	static void loginAsManager_en() throws InterruptedException {

		// open URL
		driver.get(Hiq_url_en);
		Thread.sleep(50);
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

		
		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(Hiq_un_manager);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw_manager);

		// click on login
		driver.findElement(By.id("login")).click();

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}
	
	// -------------------------------------------------
		// Login as manager Sv
		// -------------------------------------------------
		static void loginAsManager_sv() throws InterruptedException {

			// open URL
			driver.get(Hiq_url_sv);
			Thread.sleep(50);
			assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

			
			// Write username and password
			WebElement nameBox1 = driver.findElement(By.name("username"));
			nameBox1.sendKeys(Hiq_un_manager);
			WebElement nameBox2 = driver.findElement(By.name("password"));
			nameBox2.sendKeys(Hiq_pw_manager);

			// click on login
			driver.findElement(By.id("login")).click();

			// Check if login succsess by checking Dashboard title name
			assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
		}

	// -------------------------------------------------
	// Login as admin
	// -------------------------------------------------
	static void loginAsAdmin() throws InterruptedException {

		// open URL
		driver.get(Hiq_url_en);
		Thread.sleep(50);
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");
		
		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(Hiq_un_admin);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw_admin);

		// click on login
		driver.findElement(By.id("login")).click();

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
		
		// verify
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}
		
	// -------------------------------------------------
	// Sign out as Manager
	// -------------------------------------------------
	static void signOutAsManager() {

		// click on Sign out
		driver.findElement(By.id("managerMenu")).click();
		driver.findElement(By.id("navSignout")).click();
		// verify
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}
	
	static void verifyLang_en2sv(String pageSwedish) {
		//LOGGER.info("------------" + pageSwedish);
		pageSwedish = "//a[@href='/sv/" + pageSwedish + "/1']";
		LOGGER.info("------------" + pageSwedish);
	//Change language from En to Sv
			driver.findElement(By.id("consultantMenu")).click();
			driver.findElement(By.xpath(pageSwedish)).click();
			//driver.findElement(By.xpath("//a[@href='/sv/profile/1']")).click();
			String verify_lang_sv = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
			assertTrue(verify_lang_sv.contains("Profil") & verify_lang_sv.contains("Uppgifter")); 	
	}
	
	static void verifyLang_sv2en() {
		//Change language from Sv to En
			driver.findElement(By.id("consultantMenu")).click();
			driver.findElement(By.xpath("//a[@href='/en/profile/1']")).click();
			String verify_lang_en = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
			assertTrue(verify_lang_en.contains("Profile") & verify_lang_en.contains("Assignments")); 
	}
}