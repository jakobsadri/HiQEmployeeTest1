package se.hiq;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
public class ConsultantAssignmentsEnglishTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantAssignmentsEnglishTest.class);
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
		// login
		Functions.loginAsConsultant_en();

		// Go to My Assignment
		Functions.driver.findElement(By.id("navAssignments")).click();

		// Add assignment
		Functions.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		WebElement customer = Functions.driver.findElement(By.id("customer"));
		customer.clear();
		customer.sendKeys("Computer Games AB");
		customer.sendKeys(Keys.RETURN);
		
		WebElement startDate = Functions.driver.findElement(By.id("startDate"));
		startDate.clear();
		startDate.sendKeys("2015-02-11");
		
		WebElement endDate = Functions.driver.findElement(By.id("endDate"));
		endDate.clear();
		endDate.sendKeys("2017-02-01");
		
		WebElement assignmentRole = Functions.driver.findElement(By.id("assignmentRole"));
		assignmentRole.clear();
		assignmentRole.sendKeys("Test Manager");
		
		LOGGER.info("-------1-----------");
		
		//Functions.driver.findElement(By.xpath("//input[@class='ng2-tag-input__text-input ng-valid ng-touched ng-dirty']")).click();
		//WebElement competences = Functions.driver.findElement(By.id("competences"));
		//Functions.driver.findElement(By.id("competences")).click();
		
		//WebElement competences = Functions.driver.findElement(By.xpath("//input[@class='ng2-tag-input__text-input ng-pristine ng-valid ng-touched']"));
		//competences.click();
		//competences.sendKeys("JUnit");
		//Select Profileoption = new Select(Functions.driver.findElement(By.id("competences")));
		//Profileoption.selectByVisibleText("JUnit");
		
		
		//WebElement competences = Functions.driver.findElement(By.id("competences"));
		//WebElement competences =Functions.driver.findElement(By.xpath("//[@class='ng-tns-c14-32 ng-pristine ng-valid ng-touched']"));
		//competences.getText();
		//competences.click();
		//competences.sendKeys("JUnit");
		//competences.sendKeys(Keys.DOWN);
		//competences.sendKeys(Keys.RETURN);
		//competences.sendKeys(Keys.RETURN);
		//competences2.sendKeys(Keys.ARROW_DOWN);

		//competences.click();
		//customer.sendKeys(Keys.ARROW_DOWN);
		LOGGER.info("-------2-----------");

		//customer.sendKeys(Keys.ARROW_DOWN);
		//Select Profileoption = new Select(Functions.driver.findElement(By.xpath("//[@class='sr-only']")));
		//Profileoption.selectByVisibleText("JUnit");
		
		//WebElement competences = Functions.driver.findElement(By.xpath("//[@class='ng2-tags-container']"));
		
		//competences.sendKeys("JUnit"+(Keys.ARROW_DOWN)+(Keys.RETURN));
		//customer.sendKeys(Keys.ARROW_DOWN);
		//customer.sendKeys(Keys.RETURN);
		//Functions.driver.findElement(By.xpath("//ng2-dropdown-menu[@class='ng-tns-c17-14 ng-star-inserted']")).click();
		
		
		LOGGER.info("-------3-----------");
		
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

		// login
		Functions.loginAsConsultant_en();

		// Go to My Assigment
		Functions.driver.findElement(By.id("navAssignments")).click();

		// Verify language change en to sv
		Functions.verifyConsultantLanguage_en2sv("assignments");

		// Verify language change sv to en
		Functions.verifyConsultantLanguage_sv2en("assignments");

		// click on Sign out
		Functions.signOutAsConsultant();
	}

	@AfterClass
	public static void afterTest() {
		// Driver.quit();
	}

}