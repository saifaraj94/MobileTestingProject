package WF_Ahmed;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Sorting extends TestBase {

	private MainPage_Sorting mainPage;
	
	@Test(priority = 1, dataProvider = "Sorting_Data", dataProviderClass = ReadFile_Sorting.class)
	public void testFullSortingFlow(String groupingOption, boolean groupingAsc, String sortingOption,
			boolean sortingAsc, String subtaskOption, boolean subtaskAsc, String completedOption, boolean completedAsc)
			throws InterruptedException {
		if (driver == null) {
			System.out.println("Error: Appium driver is null in Test_Sorting.testFullSortingFlow for grouping: '"
					+ groupingOption + "'");
			throw new IllegalStateException(
					"Appium driver is null. Ensure TestBase's @BeforeClass setUp() ran and Appium server/emulator are configured.");
		}

		mainPage = new MainPage_Sorting((io.appium.java_client.android.AndroidDriver) driver);

		System.out.println("Starting sorting test for grouping: '" + groupingOption + "', sorting: '" + sortingOption
				+ "', subtask: '" + subtaskOption + "', completed: '" + completedOption + "'");

		boolean result = mainPage.applyFullSortingFlow(groupingOption, groupingAsc, sortingOption, sortingAsc,
				subtaskOption, subtaskAsc, completedOption, completedAsc);

		System.out.println("Sorting test result: " + result);
		Assert.assertTrue(result, "Sorting flow failed for grouping: '" + groupingOption + "', sorting: '"
				+ sortingOption + "', subtask: '" + subtaskOption + "', completed: '" + completedOption + "'");

		System.out.println("Sorting test completed for grouping: '" + groupingOption + "'");
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void testCompletedWorkflowClose() {
		mainPage = new MainPage_Sorting((io.appium.java_client.android.AndroidDriver) driver);
		mainPage.workflowCompletedToggleClose();
	}

	@Test(priority = 3)
	public void testCompletedWorkflowOpen() {
		mainPage = new MainPage_Sorting((io.appium.java_client.android.AndroidDriver) driver);
		mainPage.workflowCompletedToggleOpen();
	}

}