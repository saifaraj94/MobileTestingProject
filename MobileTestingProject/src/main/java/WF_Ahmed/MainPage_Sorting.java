package WF_Ahmed;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.MobileBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage_Sorting {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	public MainPage_Sorting(AndroidDriver<MobileElement> driver) {
		if (driver == null) {
			throw new IllegalArgumentException(
					"Appium driver cannot be null in MainPage_Sorting. Check TestBase setup.");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}

	private MobileBy sortButton = (MobileBy) MobileBy.AccessibilityId("Sort");
	private MobileBy closeSheet = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().description(\"Close sheet\")");

	private MobileBy groupingSort = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)");
	private MobileBy byDueDate = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"By due date\")");
	private MobileBy byStartDate = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"By start date\")");
	private MobileBy byPriority = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"By priority\")");
	private MobileBy byLastModified = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By last modified\")");
	private MobileBy byCreationTime = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By creation time\")");
	private MobileBy byList = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"By list\")");
	private MobileBy noneOption = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"None\")");
	private MobileBy groupingAscending = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Ascending\").instance(0)");
	private MobileBy groupingDescending = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Descending\").instance(0)");

	private MobileBy sortingNextType13 = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(13)");
	private MobileBy sortingNextType11 = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(11)");
	private MobileBy sortingByDueDate = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By due date\")");
	private MobileBy sortingByStartDate = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By start date\")");
	private MobileBy sortingByPriority = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By priority\")");
	private MobileBy sortingByTitle = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(11)");
	private MobileBy sortingByLastModified = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By last modified\")");
	private MobileBy sortingBySmartSort = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Smart sort\")");
	private MobileBy sortingByCreationTime = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By creation time\")");
	private MobileBy sortingAscending = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Ascending\").instance(1)");
	private MobileBy sortingDescending = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Descending\").instance(1)");

	private MobileBy subtaskNextType17 = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(17)");
	private MobileBy subtaskNextType15 = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(15)");
	private MobileBy subtaskAscending = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Ascending\").instance(2)");
	private MobileBy subtaskDescending = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Descending\").instance(2)");
	private MobileBy subtaskMyOrder = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"My order\")");
	private MobileBy subtaskByTitle = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"By title\")");
	private MobileBy subtaskByDueDate = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By due date\")");
	private MobileBy subtaskByStartDate = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By start date\")");
	private MobileBy subtaskByPriority = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By priority\")");
	private MobileBy subtaskByLastModified = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By last modified\")");
	private MobileBy subtaskByCreationTime = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By creation time\")");
	private MobileBy subtaskSmartSort = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"Smart sort\")");

	private MobileBy completedNextType17 = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(17)");
	private MobileBy completedNextType25 = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(25)");
	private MobileBy completedAscending = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Ascending\").instance(3)");
	private MobileBy completedDescending = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Descending\").instance(3)");
	private MobileBy completedCheckCloseOpen = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(22)");
	private MobileBy completedByMyOrder = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"My order\")");
	private MobileBy completedByDueDate = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By due date\")");
	private MobileBy completedByStartDate = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By start date\")");
	private MobileBy completedByPriority = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By priority\")");
	private MobileBy completedByTitle = (MobileBy) MobileBy.AndroidUIAutomator("new UiSelector().text(\"By title\")");
	private MobileBy completedByLastModified = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By last modified\")");
	private MobileBy completedByCreationTime = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"By creation time\")");
	private MobileBy completedBySmartSort = (MobileBy) MobileBy
			.AndroidUIAutomator("new UiSelector().text(\"Smart sort\")");

	public void clickSortButton() {
		System.out.println("Clicking sort button");
		wait.until(ExpectedConditions.elementToBeClickable(sortButton)).click();
	}

	public void clickCloseSheet() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.elementToBeClickable(sortButton));
	        System.out.println("Sort button is clickable → do nothing");
	    } catch (Exception e) {
	        System.out.println("Sort button not clickable → pressing BACK");
	        driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    }
	}




//		wait.until(ExpectedConditions.elementToBeClickable(closeSheet)).click();

	public void clickGroupingSort() {
		System.out.println("Clicking grouping sort");
		wait.until(ExpectedConditions.elementToBeClickable(groupingSort)).click();
	}

	public void clickByDueDate() {
		wait.until(ExpectedConditions.elementToBeClickable(byDueDate)).click();
	}

	public void clickByStartDate() {
		wait.until(ExpectedConditions.elementToBeClickable(byStartDate)).click();
	}

	public void clickByPriority() {
		wait.until(ExpectedConditions.elementToBeClickable(byPriority)).click();
	}

	public void clickByLastModified() {
		wait.until(ExpectedConditions.elementToBeClickable(byLastModified)).click();
	}

	public void clickByCreationTime() {
		wait.until(ExpectedConditions.elementToBeClickable(byCreationTime)).click();
	}

	public void clickByList() {
		wait.until(ExpectedConditions.elementToBeClickable(byList)).click();
	}

	public void clickNoneOption() {
		wait.until(ExpectedConditions.elementToBeClickable(noneOption)).click();
	}

	public void clickGroupingAscending() {
		System.out.println("Selecting grouping ascending");
		wait.until(ExpectedConditions.elementToBeClickable(groupingAscending)).click();
	}

	public void clickGroupingDescending() {
		System.out.println("Selecting grouping descending");
		wait.until(ExpectedConditions.elementToBeClickable(groupingDescending)).click();
	}

	public void clickSortingNextType() {
		try {
			driver.findElement(sortingNextType13).click();
		} catch (Exception e1) {
			try {
				driver.findElement(sortingNextType11).click();
			} catch (Exception e2) {
				try {
					driver.findElement(MobileBy
							.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
									+ "new UiSelector().className(\"android.view.View\"))"))
							.click();
				} catch (Exception e3) {
					System.out.println("Sorting option not found even after scrolling!");
					throw e3;
				}
			}
		}
	}

	public void clickSortingByDueDate() {
		wait.until(ExpectedConditions.elementToBeClickable(sortingByDueDate)).click();
	}

	public void clickSortingByStartDate() {
		wait.until(ExpectedConditions.elementToBeClickable(sortingByStartDate)).click();
	}

	public void clickSortingByPriority() {
		wait.until(ExpectedConditions.elementToBeClickable(sortingByPriority)).click();
	}

	public void clickSortingByTitle() {
		wait.until(ExpectedConditions.elementToBeClickable(sortingByTitle)).click();
	}

	public void clickSortingByLastModified() {
		wait.until(ExpectedConditions.elementToBeClickable(sortingByLastModified)).click();
	}

	public void clickSortingBySmartSort() {
		wait.until(ExpectedConditions.elementToBeClickable(sortingBySmartSort)).click();
	}

	public void clickSortingByCreationTime() {
		wait.until(ExpectedConditions.elementToBeClickable(sortingByCreationTime)).click();
	}

	public void clickSortingAscending() {
		System.out.println("Selecting sorting ascending");
		wait.until(ExpectedConditions.elementToBeClickable(sortingAscending)).click();
	}

	public void clickSortingDescending() {
		System.out.println("Selecting sorting descending");
		wait.until(ExpectedConditions.elementToBeClickable(sortingDescending)).click();
	}

	// Subtask
	public void clickSubtaskNextType() {
		try {
			driver.findElement(subtaskNextType17).click();
		} catch (Exception e1) {
			try {
				driver.findElement(subtaskNextType15).click();
			} catch (Exception e2) {
				// Last resort: scroll
				driver.findElement(MobileBy
						.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
								+ "new UiSelector().className(\"android.view.View\").instance(15))"))
						.click();
			}
		}
	}

	public void clickSubtaskAscending() {
		System.out.println("Selecting subtask ascending");
		wait.until(ExpectedConditions.elementToBeClickable(subtaskAscending)).click();
	}

	public void clickSubtaskDescending() {
		System.out.println("Selecting subtask descending");
		wait.until(ExpectedConditions.elementToBeClickable(subtaskDescending)).click();
	}

	public void clickSubtaskMyOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(subtaskMyOrder)).click();
	}

	public void clickSubtaskByTitle() {
		wait.until(ExpectedConditions.elementToBeClickable(subtaskByTitle)).click();
	}

	public void clickSubtaskByDueDate() {
		wait.until(ExpectedConditions.elementToBeClickable(subtaskByDueDate)).click();
	}

	public void clickSubtaskByStartDate() {
		wait.until(ExpectedConditions.elementToBeClickable(subtaskByStartDate)).click();
	}

	public void clickSubtaskByPriority() {
		wait.until(ExpectedConditions.elementToBeClickable(subtaskByPriority)).click();
	}

	public void clickSubtaskByLastModified() {
		wait.until(ExpectedConditions.elementToBeClickable(subtaskByLastModified)).click();
	}

	public void clickSubtaskByCreationTime() {
		wait.until(ExpectedConditions.elementToBeClickable(subtaskByCreationTime)).click();
	}

	public void clickSubtaskSmartSort() {
		wait.until(ExpectedConditions.elementToBeClickable(subtaskSmartSort)).click();
	}

	public void clickCompletedNextType() {
		try {
			driver.findElement(completedNextType17).click();
		} catch (Exception e1) {
			try {
				driver.findElement(completedNextType25).click();
			} catch (Exception e2) {
				try {
					driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
							+ ".scrollIntoView(new UiSelector().className(\"android.view.View\"))")).click();
				} catch (Exception e3) {
					System.out.println("Completed option not found even after scrolling!");
					throw e3;
				}
			}
		}
	}

	public void clickCompletedAscending() {
		System.out.println("Selecting completed ascending");
		wait.until(ExpectedConditions.elementToBeClickable(completedAscending)).click();
	}

	public void clickCompletedDescending() {
		System.out.println("Selecting completed descending");
		wait.until(ExpectedConditions.elementToBeClickable(completedDescending)).click();
	}

	private MobileElement getCompletedCheckCloseOpen() {
		System.out.println("Switching Completed Toggle");
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(completedCheckCloseOpen));
		element.click();
		return element;
	}

	public void clickCompletedByMyOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(completedByMyOrder)).click();
	}

	public void clickCompletedByDueDate() {
		wait.until(ExpectedConditions.elementToBeClickable(completedByDueDate)).click();
	}

	public void clickCompletedByStartDate() {
		wait.until(ExpectedConditions.elementToBeClickable(completedByStartDate)).click();
	}

	public void clickCompletedByPriority() {
		wait.until(ExpectedConditions.elementToBeClickable(completedByPriority)).click();
	}

	public void clickCompletedByTitle() {
		wait.until(ExpectedConditions.elementToBeClickable(completedByTitle)).click();
	}

	public void clickCompletedByLastModified() {
		wait.until(ExpectedConditions.elementToBeClickable(completedByLastModified)).click();
	}

	public void clickCompletedByCreationTime() {
		wait.until(ExpectedConditions.elementToBeClickable(completedByCreationTime)).click();
	}

	public void clickCompletedBySmartSort() {
		wait.until(ExpectedConditions.elementToBeClickable(completedBySmartSort)).click();
	}

	public void ensureCompletedToggleOpen() {
		clickSortButton();
		MobileElement toggle = getCompletedCheckCloseOpen();

		if (!toggle.isSelected()) {
			toggle.click();
			System.out.println("Completed toggle was CLOSED → now OPENED");
		} else {
			System.out.println("Completed toggle already OPEN");
		}

		clickCloseSheet();
	}

	public void assertSortingApplied(String expectedText, boolean wantAsc) {
		System.out.println("Verifying sorting applied for: " + expectedText + " Asc=" + wantAsc);

		List<MobileElement> tasks = driver.findElements(
				MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/task_list_item_title\")"));

		List<String> taskTexts = tasks.stream().map(MobileElement::getText).collect(Collectors.toList());

		List<String> sorted = new ArrayList<>(taskTexts);
		if (wantAsc) {
			Collections.sort(sorted);
		} else {
			Collections.sort(sorted, Collections.reverseOrder());
		}

		Assert.assertEquals(taskTexts, sorted, "Tasks are not sorted correctly for: " + expectedText);
	}

	public void selectGroupingOption(String option) {
		System.out.println("Selecting grouping option: " + option);
		switch (option.toLowerCase()) {
		case "by due date":
			clickByDueDate();
			break;
		case "by start date":
			clickByStartDate();
			break;
		case "by priority":
			clickByPriority();
			break;
		case "by last modified":
			clickByLastModified();
			break;
		case "by creation time":
			clickByCreationTime();
			break;
		case "by list":
			clickByList();
			break;
		case "none":
			clickNoneOption();
			break;
		default:
			throw new IllegalArgumentException("Invalid grouping option: " + option);
		}
	}

	public void selectSortingOption(String option) {
		System.out.println("Selecting sorting option: " + option);
		switch (option.toLowerCase()) {
		case "by due date":
			clickSortingByDueDate();
			break;
		case "by start date":
			clickSortingByStartDate();
			break;
		case "by priority":
			clickSortingByPriority();
			break;
		case "by title":
			clickSortingByTitle();
			break;
		case "by last modified":
			clickSortingByLastModified();
			break;
		case "smart sort":
			clickSortingBySmartSort();
			break;
		case "by creation time":
			clickSortingByCreationTime();
			break;
		default:
			throw new IllegalArgumentException("Invalid sorting option: " + option);
		}
	}

	public void selectSubtaskOption(String option) {
		System.out.println("Selecting subtask option: " + option);
		switch (option.toLowerCase()) {
		case "my order":
			clickSubtaskMyOrder();
			break;
		case "by due date":
			clickSubtaskByDueDate();
			break;
		case "by start date":
			clickSubtaskByStartDate();
			break;
		case "by priority":
			clickSubtaskByPriority();
			break;
		case "by title":
			clickSubtaskByTitle();
			break;
		case "by last modified":
			clickSubtaskByLastModified();
			break;
		case "smart sort":
			clickSubtaskSmartSort();
			break;
		case "by creation time":
			clickSubtaskByCreationTime();
			break;
		default:
			throw new IllegalArgumentException("Invalid subtask option: " + option);
		}
	}

	public void selectCompletedOption(String option) {
		System.out.println("Selecting completed option: " + option);
		switch (option.toLowerCase()) {
		case "by my order":
			clickCompletedByMyOrder();
			break;
		case "by due date":
			clickCompletedByDueDate();
			break;
		case "by start date":
			clickCompletedByStartDate();
			break;
		case "by priority":
			clickCompletedByPriority();
			break;
		case "by title":
			clickCompletedByTitle();
			break;
		case "by last modified":
			clickCompletedByLastModified();
			break;
		case "by creation time":
			clickCompletedByCreationTime();
			break;
		case "by smart sort":
			clickCompletedBySmartSort();
			break;
		default:
			throw new IllegalArgumentException("Invalid completed option: " + option);
		}
	}

	private void clickFirstVisibleIfNeeded(MobileBy ascLocator, MobileBy descLocator, boolean wantAsc) {
		try {
			List<MobileElement> ascElements = driver.findElements(ascLocator);
			List<MobileElement> descElements = driver.findElements(descLocator);

			boolean ascVisible = ascElements.stream().anyMatch(MobileElement::isDisplayed);
			boolean descVisible = descElements.stream().anyMatch(MobileElement::isDisplayed);

			if (wantAsc) {
				if (ascVisible) {
					System.out.println("Ascending already selected, do nothing.");
				} else if (descVisible) {
					System.out.println("Descending selected, clicking to change to Ascending.");
					descElements.stream().filter(MobileElement::isDisplayed).findFirst().get().click();
				} else {
					System.out.println("No visible Asc/Desc button found!");
				}
			} else {
				if (descVisible) {
					System.out.println("Descending already selected, do nothing.");
				} else if (ascVisible) {
					System.out.println("Ascending selected, clicking to change to Descending.");
					ascElements.stream().filter(MobileElement::isDisplayed).findFirst().get().click();
				} else {
					System.out.println("No visible Asc/Desc button found!");
				}
			}
		} catch (Exception e) {
			System.out.println("Error in clickFirstVisibleIfNeeded: " + e.getMessage());
		}
	}

	public void clickGroupingVisibleOption(boolean wantAsc) {
		clickFirstVisibleIfNeeded(groupingAscending, groupingDescending, wantAsc);
	}

	public void clickSortingVisibleOption(boolean wantAsc) {
		clickFirstVisibleIfNeeded(sortingAscending, sortingDescending, wantAsc);
	}

	public void clickSubtaskVisibleOption(boolean wantAsc) {
		clickFirstVisibleIfNeeded(subtaskAscending, subtaskDescending, wantAsc);
	}

	public void clickCompletedVisibleOption(boolean wantAsc) {
		clickFirstVisibleIfNeeded(completedAscending, completedDescending, wantAsc);
	}

	public boolean applyFullSortingFlow(String groupingOption, boolean groupingAsc, String sortingOption,
			boolean sortingAsc, String subtaskOption, boolean subtaskAsc, String completedOption,
			boolean completedAsc) {
		try {
			System.out.println("Applying sorting flow with smart Asc/Desc");
			clickCloseSheet();
			clickSortButton();
			clickGroupingSort();
			selectGroupingOption(groupingOption);
			clickGroupingVisibleOption(groupingAsc);

			clickSortingNextType();
			selectSortingOption(sortingOption);
			clickSortingVisibleOption(sortingAsc);

			clickSubtaskNextType();
			selectSubtaskOption(subtaskOption);
			clickSubtaskVisibleOption(subtaskAsc);

			clickCompletedNextType();
			selectCompletedOption(completedOption);
			clickCompletedVisibleOption(completedAsc);
			clickCloseSheet();
			assertSortingApplied(completedOption, completedAsc);
			assertSortingApplied(groupingOption, groupingAsc);
			assertSortingApplied(sortingOption, sortingAsc);
			assertSortingApplied(subtaskOption, subtaskAsc);

			System.out.println("Sorting flow completed successfully.");
			return true;
		} catch (Exception e) {
			System.out.println("Error in applyFullSortingFlow: " + e.getMessage());
			return false;
		}
	}

	public void workflowCompletedToggleClose() {
		clickCloseSheet();
		clickSortButton();
		MobileElement toggle = getCompletedCheckCloseOpen();

		if (toggle.isSelected()) {
			Assert.fail("Expected Completed to be CLOSED, but it's OPEN");
		} else {
			System.out.println("Completed is CLOSED as expected");
		}
		clickCloseSheet();
	}

	public void workflowCompletedToggleOpen() {
		clickCloseSheet();
		clickSortButton();
		MobileElement toggle = getCompletedCheckCloseOpen();

		if (!toggle.isSelected()) {
			System.out.println("Completed is OPEN as expected");
		} else {
			Assert.fail("Expected Completed to be OPEN, but it's CLOSED");
		}
		clickCloseSheet();
	}

}