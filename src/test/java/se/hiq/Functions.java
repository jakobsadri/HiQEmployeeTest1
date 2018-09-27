package se.hiq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public static String hiq_url_en = "https://test-employee.northeurope.cloudapp.azure.com/en";
	public static String hiq_url_sv = "https://test-employee.northeurope.cloudapp.azure.com/sv";
	public static String hiq_un_consultant = "testconsultant";
	public static String Hiq_pw_consultant = "password";
	public static String hiq_un_manager = "testmanager";
	public static String hiq_pw_manager = "password";
	public static String hiq_un_admin = "admin";
	public static String hiq_pw_admin = "admin";
	public static int untilTimer_1 = 1000;
	public static int untilTimer_2 = 500;
	public static int untilTimer_3 = 5000;
	public static int timer_100ms = 100;
	public static int timer_200ms = 200;
	public static int timer_300ms = 300;
	public static int timer_500ms = 500;
	public static int timer_1s = 1000;
	public static int timer_2s = 2000;
	public static int timer_3s = 3000;
	public static int timer_5s = 5000;
	public static int timer_7s = 7000;
	public static int timer_s = 10000;
	

	// -------------------------------------------------
	// Login as consultant En
	// -------------------------------------------------
	static void loginAsConsultant_en() throws InterruptedException {

		// open URL
		driver.get(hiq_url_en);

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(hiq_un_consultant);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw_consultant);

		// click on login
		driver.findElement(By.id("login")).click();

		// Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("main-nav")));

				// Check if login succsess by checking Dashboard title name
		String str = Functions.driver.getTitle();
		Thread.sleep(100);
		assertEquals("Assert initial page title", str, "HIQ Employees");
	}

	// -------------------------------------------------
	// Login as consultant Sv
	// -------------------------------------------------
	static void loginAsConsultant_sv() throws InterruptedException {

		// open URL
		driver.get(hiq_url_sv);

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(hiq_un_consultant);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(Hiq_pw_consultant);

		// click on login
		driver.findElement(By.id("login")).click();

		// Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("main-nav")));

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");

	}

	// -------------------------------------------------
	// Login as manager En
	// -------------------------------------------------
	static void loginAsManager_en() throws InterruptedException {

		// open URL
		driver.get(hiq_url_en);

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(hiq_un_manager);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(hiq_pw_manager);

		// click on login
		driver.findElement(By.id("login")).click();

		// Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("main-nav")));
		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}

	// -------------------------------------------------
	// Login as manager Sv
	// -------------------------------------------------
	static void loginAsManager_sv() throws InterruptedException {

		// open URL
		driver.get(hiq_url_sv);

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(hiq_un_manager);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(hiq_pw_manager);

		// click on login
		driver.findElement(By.id("login")).click();

		// Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("main-nav")));

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}

	// -------------------------------------------------
	// Login as admin en
	// -------------------------------------------------
	static void loginAsAdmin_en() throws InterruptedException {

		// open URL
		driver.get(hiq_url_en);

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, timer_5s);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(hiq_un_admin);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(hiq_pw_admin);

		// click on login
		driver.findElement(By.id("login")).click();

		// Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employees")));

		// Check if login succsess by checking Dashboard title name
		String str = Functions.driver.getTitle();
		Thread.sleep(100);
		assertEquals("Assert initial page title", str, "HIQ Employees");
	}

	// -------------------------------------------------
	// Login as admin sv
	// -------------------------------------------------
	static void loginAsAdmin_sv() throws InterruptedException {

		// open URL
		driver.get(hiq_url_sv);

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");

		// Write username and password
		WebElement nameBox1 = driver.findElement(By.name("username"));
		nameBox1.sendKeys(hiq_un_admin);
		WebElement nameBox2 = driver.findElement(By.name("password"));
		nameBox2.sendKeys(hiq_pw_admin);

		// click on login
		driver.findElement(By.id("login")).click();

		// Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("main-nav")));

		// Check if login succsess by checking Dashboard title name
		assertEquals("Assert initial page title", Functions.driver.getTitle(), "HIQ Employees");
	}

	// -------------------------------------------------
	// Sign out as consultant
	// -------------------------------------------------
	static void signOutAsConsultant() throws InterruptedException {

		// click on Sign out
		driver.findElement(By.id("consultantMenu")).click();
		driver.findElement(By.id("navSignout")).click();

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");
		Thread.sleep(timer_500ms);
	}

	// -------------------------------------------------
	// Sign out as Manager
	// -------------------------------------------------
	static void signOutAsManager() throws InterruptedException {

		// click on Sign out
		driver.findElement(By.id("managerMenu")).click();
		driver.findElement(By.id("navSignout")).click();

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");
		Thread.sleep(timer_500ms);
	}

	// -------------------------------------------------
	// Sign out as Admin
	// -------------------------------------------------
	static void signOutAsAdmin() throws InterruptedException {
		// click on Sign out
		driver.findElement(By.id("adminMenu")).click();
		driver.findElement(By.id("navSignout")).click();

		// Wait until action is done and find login button
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));

		// verify also home page title
		assertEquals("Assert initial page title", driver.getTitle(), "HIQ Employees");
		Thread.sleep(timer_500ms);
	}

	// -------------------------------------------------
		// Change language from English to Svenska
		// -------------------------------------------------
		static void verifyLanguage_en2sv(String pageSwedish) throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);
			
			// Change language from En to Sv
			driver.findElement(By.id(pageSwedish)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Svenska")));
			driver.findElement(By.linkText("Svenska")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employees")));
			
			//verify
			String verify_lang_en = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
			assertTrue((verify_lang_en.contains("Profil") || verify_lang_en.contains("Dashboard")) & (verify_lang_en.contains("Uppdragen") || verify_lang_en.contains("S�k")));
			
		}

		// -------------------------------------------------
		// Change language from Svenska to English
		// -------------------------------------------------
		static void verifyLanguage_sv2en(String pageEnglish) throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);

			// Change language from Sv to En
			driver.findElement(By.id(pageEnglish)).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("English")));
			driver.findElement(By.linkText("English")).click();
			//Wait until action is done
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employees")));
			
			//verify
			String verify_lang_en = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
			assertTrue((verify_lang_en.contains("Profile") || verify_lang_en.contains("Dashboard")) & (verify_lang_en.contains("Assignments") || verify_lang_en.contains("Search")));
		}

	// -------------------------------------------------
	// Change language Manager from English to Svenska
	// -------------------------------------------------
	static void verifyManagerLanguage_en2sv(String pageSwedish) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);

		if (pageSwedish.equals("search")) {
			pageSwedish = "//a[@href='/sv/" + pageSwedish + "']";
		} else if (pageSwedish.equals("profile") || pageSwedish.equals("assignments") || pageSwedish.equals("cv")
				|| pageSwedish.equals("import")) {
			pageSwedish = "//a[@href='/sv/" + pageSwedish + "/2']";
		}
		// Change language from En to Sv
		driver.findElement(By.id("managerMenu")).click();
		driver.findElement(By.xpath(pageSwedish)).click();
		//Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("navProfile")));
		Thread.sleep(timer_200ms);
		String verify_lang_sv = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
		//LOGGER.info(verify_lang_sv);
		assertTrue(verify_lang_sv.contains("Profil") & verify_lang_sv.contains("Konsultgrupp"));
	}

	// -------------------------------------------------
	// Change language Manager from Svenska to English
	// -------------------------------------------------
	static void verifyManagerLanguage_sv2en(String pageEnglish) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);

		if (pageEnglish.equals("search")) {
			pageEnglish = "//a[@href='/en/" + pageEnglish + "']";
		} else if (pageEnglish.equals("profile") || pageEnglish.equals("assignments") || pageEnglish.equals("cv")
				|| pageEnglish.equals("import")) {
			pageEnglish = "//a[@href='/en/" + pageEnglish + "/2']";
		}
		// Change language from Sv to En
		driver.findElement(By.id("managerMenu")).click();
		Thread.sleep(timer_200ms);
		driver.findElement(By.xpath(pageEnglish)).click();
		//Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("navProfile")));
	
		String verify_lang_en = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
		Thread.sleep(timer_200ms);
		//LOGGER.info(verify_lang_en);
		assertTrue(verify_lang_en.contains("Search") & verify_lang_en.contains("Profile"));
	}

	// -------------------------------------------------
	// Change language Admin from English to Svenska
	// -------------------------------------------------
	static void verifyAdminLanguage_en2sv(String pageSwedish) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);

		if (pageSwedish.equals("dashboard")) {
			pageSwedish = "//a[@href='/sv/" + pageSwedish + "']";
			LOGGER.info(pageSwedish);
		} else if (pageSwedish.equals("profile") || pageSwedish.equals("assignments") || pageSwedish.equals("cv")
				|| pageSwedish.equals("import")) {
			pageSwedish = "//a[@href='/sv/" + pageSwedish + "/2']";
		}
		// Change language from En to Sv
		driver.findElement(By.id("adminMenu")).click();
		driver.findElement(By.xpath(pageSwedish)).click();
		//Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("navDashboard")));
		Thread.sleep(timer_200ms);

		String verify_lang_sv = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
		//LOGGER.info(verify_lang_sv);
		assertTrue(verify_lang_sv.contains("Dashboard") & verify_lang_sv.contains("S�k"));
	}

	// -------------------------------------------------
	// Change language Admin from Svenska to English
	// -------------------------------------------------
	static void verifyAdminLanguage_sv2en(String pageEnglish) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, untilTimer_1);

		if (pageEnglish.equals("dashboard")) {
			pageEnglish = "//a[@href='/en/" + pageEnglish + "']";
		} else if (pageEnglish.equals("profile") || pageEnglish.equals("assignments") || pageEnglish.equals("cv")
				|| pageEnglish.equals("import")) {
			pageEnglish = "//a[@href='/en/" + pageEnglish + "/2']";
		}
		// Change language from Sv to En
		driver.findElement(By.id("adminMenu")).click();
		driver.findElement(By.xpath(pageEnglish)).click();
		//Wait until action is done
		wait.until(ExpectedConditions.elementToBeClickable(By.id("navDashboard")));
		Thread.sleep(timer_200ms);
	
		String verify_lang_en = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']")).getText();
		//LOGGER.info(verify_lang_en);
		assertTrue(verify_lang_en.contains("Dashboard") & verify_lang_en.contains("Search"));
	}
}