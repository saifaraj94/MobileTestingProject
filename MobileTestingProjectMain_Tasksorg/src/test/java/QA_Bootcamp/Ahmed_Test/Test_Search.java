package QA_Bootcamp.Ahmed_Test;

import base.TestBase;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import WF_Ahmed.MainPage_Search;

public class Test_Search extends TestBase {

	private MainPage_Search mainPage;
	
	@Test(priority = 1)
	public void AddDemoTask() {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
		WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")")));
        box.clear();
        box.sendKeys("Task A");
        try { driver.hideKeyboard(); } catch (Exception ignored) {}
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
		box = wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")")));
        box.clear();
        box.sendKeys("1");
        try { driver.hideKeyboard(); } catch (Exception ignored) {}
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(priority = 2, dataProvider = "Search_Bar_Test_Data", dataProviderClass = ReadFile_Search.class)
	public void validInvalidSearchTest(String taskName, String expectedResult) {
		mainPage = new MainPage_Search((io.appium.java_client.android.AndroidDriver) driver);

		System.out.println("Starting search test for task: '" + taskName + "'");
		
		boolean isValidTask = expectedResult.equalsIgnoreCase("TRUE");

		if (isValidTask) {
			System.out.println("Running valid search workflow...");
			boolean result = mainPage.validSearchWorkflow(taskName);
			System.out.println("Search for task '" + taskName + "' returned: " + result);
			Assert.assertTrue(result, "Task should be found: " + taskName);
		} else {
			System.out.println("Running invalid search workflow...");
			boolean result = mainPage.invalidSearchWorkflow(taskName);
			System.out.println("Search for task '" + taskName + "' returned: " + result);
			Assert.assertTrue(result, "Task should NOT be found: " + taskName);
		}

		System.out.println("Search test completed for task: '" + taskName + "'");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(priority = 3, dataProvider = "Search_Reset_Test_Data", dataProviderClass = ReadFile_Search.class)
	public void resetSearchBarTest(String taskName, String expectedResult) {
		mainPage = new MainPage_Search((io.appium.java_client.android.AndroidDriver) driver);

		System.out.println("Starting reset search bar test for task: '" + taskName + "'");

		boolean result = mainPage.resetSearchWorkflow(taskName);
		System.out.println("Search bar cleared: " + result);

		boolean expected = expectedResult.equalsIgnoreCase("TRUE");
		Assert.assertEquals(result, expected, "Search bar reset did not match expected result for task: " + taskName);

		System.out.println("Reset search bar test completed for task: '" + taskName + "'");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(priority = 4)
	public void collapseArrowTest() {
		mainPage = new MainPage_Search((io.appium.java_client.android.AndroidDriver) driver);

		System.out.println("Starting collapse arrow test...");
		boolean result = mainPage.collapseArrowWorkflow();
		System.out.println("Dashboard displayed after collapse arrow: " + result);
		Assert.assertTrue(result, "Should return to dashboard after clicking collapse arrow");
		System.out.println("Collapse arrow test completed.");
	}
}