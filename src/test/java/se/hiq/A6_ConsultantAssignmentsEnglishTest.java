package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*=========================================================================================================
 * test_006_1: verify consultant assignments.
 * 1. Login as consultant and verify start page. Start page should contains words "profile" and "Assignments".
 * 2. TBD....
 * 3. Signout from the page
 * 
 * test_006_2: Verify language changes
 * 1. Login as consultant and verify start page.
 * 2. Change language from English to Swedish and vice versa.
 * 3. Signout from the page and verify signout by checking HiQEmployee login-pages's title "HIQ Employees".
 *=========================================================================================================
 */
public class A6_ConsultantAssignmentsEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(A6_ConsultantAssignmentsEnglishTest.class);
	String[] profileId = { "customer", "JUnit", "homeOffice", "startedInBranch", "startedAtCompany",
			"wantedAssignments" };
	int profileArraySize = profileId.length;
	String[] profileCurrentName = { "Hipe", "Developer", "STOCKHOLM", "1994-11-01", "2014-09-12", "A brain surgeon" };
	String[] profileTestName = { "Computer Games AB", "JUnit", "MALMO", "2001-09-02", "2002-12-12", "Test" };
	// item by value (MarkIT = 11), Posation 11
	String[] profileTestName1 = { "11", "Tester", "MALMO", "2001-09-02", "2002-12-12", "Test" };

	@BeforeClass
	public static void beforeTest() {

	}

	@Test
	public void test_006_1() throws InterruptedException {
		LOGGER.info("--------------------- [Assignments Consultant] ---------------------");
		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.untilTimer_2);

		// login
		Functions.loginAsConsultant_en();

		// Go to My Assignment
		Functions.driver.findElement(By.id("navAssignments")).click();
		Thread.sleep(Functions.timer_500ms);
		// Add assignment
		Functions.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("customer")));
		
		WebElement customer = Functions.driver.findElement(By.id("customer"));
		customer.sendKeys("Computer Games AB");
		customer.sendKeys(Keys.RETURN);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("startDate")));

		WebElement startDate = Functions.driver.findElement(By.id("startDate"));
		startDate.clear();
		startDate.sendKeys("2015-02-11");
		
		WebElement endDate = Functions.driver.findElement(By.id("endDate"));
		endDate.clear();
		endDate.sendKeys("2017-02-01");
		
		WebElement assignmentRole = Functions.driver.findElement(By.id("assignmentRole"));
		assignmentRole.clear();
		assignmentRole.sendKeys("Test Manager");
		
		WebElement description = Functions.driver.findElement(By.id("description"));
		description.clear();
		description.sendKeys("I was responsible for the.....project....");
		
		WebElement summary = Functions.driver.findElement(By.id("summary"));
		summary.clear();
		summary.sendKeys("Bla bla bla....");
		
		// Save info
		Functions.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		
		// Functions.driver.findElement(By.xpath("//div[@class='btn
		// btn-primary']")).getText();

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@Test
	public void test_006_2() throws InterruptedException {
		LOGGER.info("-------------------- [Change Language]---------------------");

		WebDriverWait wait = new WebDriverWait(Functions.driver, Functions.timer_2s);

		// login
		Functions.loginAsConsultant_en();

		// Wait until "Assignments" link is active
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Assignments")));
		
		// Go to Assignments
		Functions.driver.findElement(By.linkText("Assignments")).click();

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