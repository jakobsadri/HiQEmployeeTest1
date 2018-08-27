package se.hiq;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsultantSearchEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantAccessEnglishTest.class);

	@BeforeClass
	public static void setupDriver() {

	}

	@Test
	// Test#003, check Generate CV
	public void test_008_1() throws InterruptedException {
		LOGGER.info("--------------------- Test#005 ---------------------");
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
		LOGGER.info(searchResult);
		assertTrue(searchResult.contains("Java")); 	

		// click on Sign out
		Functions.signOutAsConsultant();
	}
	@Test
	public void test_008_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		// login
		Functions.loginAsConsultant_en();
		
		// Go to My Search
		Functions.driver.findElement(By.id("consultantMenu")).click();
		Functions.driver.findElement(By.id("navSearch")).click();

		// Verify language change en to sv
		Functions.verifyLang_en2sv("search");
		
		Thread.sleep(500);

		// Verify language change sv to en
		Functions.verifyLang_sv2en("search");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}
