package se.hiq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*=========================================================================================================
 * test_004_1: verify consultant profile -> Competences. TBD
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. TBD....
 * 3. Signout from the page
 * 
 * test_004_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */

public class A4_ConsultantCompetencesEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(A4_ConsultantCompetencesEnglishTest.class);

	String[] profileId = { "consultantGroup", "title", "homeOffice", "startedInBranch", "startedAtCompany",
			"wantedAssignments" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "HICARE", "Utvecklare", "STOCKHOLM", "1994-11-01", "2014-09-12",
			"A brain surgeon" };
	String[] profileTestName = { "HICLOUD", "Testare", "MALMO", "2001-09-02", "2002-12-12", "Test" };
	// String[] profileCurrentName = new String[profileArraySize];

	@BeforeClass
	public static void beforeTest() {

	}

	@Test // add new competences
	public void test_004_1() throws InterruptedException {
		LOGGER.info("---------------------[Profile -> Competences] ---------------------");

		// --------------------------------------------------
		// Add new competences
		// --------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

		// Go to competences page
		Functions.driver.findElement(By.id("ngb-tab-2")).click();

		// Add
		Functions.driver.findElement(By.id("add-button")).click();
		Functions.driver.findElement(By.id("competence")).click();
		Select competencesOption = new Select(Functions.driver.findElement(By.id("competence")));
		competencesOption.selectByVisibleText(".NET");
		Thread.sleep(1000);

		WebElement numberOfYears = Functions.driver.findElement(By.id("numberOfYears"));
		numberOfYears.clear();
		numberOfYears.sendKeys("4"); // numberOfYears.sendKeys(Keys.RETURN);
		Thread.sleep(Functions.timer_1s);

		//WebElement Rating = Functions.driver.findElement(By.id("rating"));
		//Rating.clear(); // 
		//Rating.sendKeys("5"); 
		// Rating.sendKeys(Keys.RETURN); //
		//Thread.sleep(Functions.timer_1s);

		// save info 
		Functions.driver.findElement(By.id("saveButton")).click();
		Thread.sleep(Functions.timer_7s);

		// click on Sign out
		Functions.signOutAsConsultant();

		// Verify
		// ------------------------------------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

		// Go to competences page
		Functions.driver.findElement(By.id("ngb-tab-2")).click();

		WebElement competencesResult = Functions.driver
				.findElement(By.xpath("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']"));
		String str1 = competencesResult.getText();
		LOGGER.info(str1);
		assertTrue(str1.contains(".NET") & str1.contains("4") & !str1.contains("()"));

		// click on Sign out
		Functions.signOutAsConsultant();

		// Remove
		// competence-----------------------------------------------------------------------

		// login
		Functions.loginAsConsultant_en();

		// Go to competences page
		Functions.driver.findElement(By.id("ngb-tab-2")).click();
		WebElement removeButton = Functions.driver.findElement(By.xpath("//span[@class='oi oi-trash'][1]"));
		removeButton.click();
		Thread.sleep(3000);
		WebElement removeButtonYes = Functions.driver
				.findElement(By.xpath("//button[@class='btn btn-success mx-1 ng-star-inserted']"));
		removeButtonYes.click();

		// click on Sign out
		Functions.signOutAsConsultant();

	}

	@Test
	public void test_004_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.timer_2s);

		// login
		Functions.loginAsConsultant_en();

		// Wait until "Competences" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Competences")));

		// Go to Competences
		Functions.driver.findElement(By.linkText("Competences")).click();

		// Verify language change en to sv
		Functions.verifyLanguage_en2sv("consultantMenu");

		// Verify language change sv to en
		Functions.verifyLanguage_sv2en("consultantMenu");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}