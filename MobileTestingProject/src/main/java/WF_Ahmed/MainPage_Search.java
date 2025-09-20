package WF_Ahmed;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class MainPage_Search {

	private AndroidDriver<AndroidElement> driver;
	private WebDriverWait wait;

	public MainPage_Search(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}

	private AndroidElement searchButton() {
		return (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search")));
	}

	private AndroidElement searchBar() {
		return (AndroidElement) wait
				.until(ExpectedConditions.elementToBeClickable(MobileBy.id("org.tasks:id/search_src_text")));
	}

	private AndroidElement clearSearchButton() {
		return (AndroidElement) wait
				.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Clear query")));
	}

	private AndroidElement collapseArrow() {
		return (AndroidElement) wait
				.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Collapse")));
	}

	private AndroidElement myTasksTitle() {
		return (AndroidElement) wait.until(ExpectedConditions
				.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().text(\"My Tasks\")")));
	}

	private List<AndroidElement> taskTitles() {
		return driver.findElements(MobileBy.id("org.tasks:id/title"));
	}

	public void clickSearch() {
		searchButton().click();
	}

	public void typeInSearchBar(String taskName) {
		searchBar().click();
		searchBar().clear();
		searchBar().sendKeys(taskName);
	}

	public void clearSearchBar() {
		clearSearchButton().click();
	}

	public boolean isSearchBarEmpty() {
		String text = searchBar().getText(); // your search bar element
		System.out.println("Current search bar text: '" + text + "'");
		return text == null || text.trim().isEmpty();
	}

	public boolean isTaskTitleContains(String taskName) {
		for (AndroidElement title : taskTitles()) {
			if (title.getText().toLowerCase().contains(taskName.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public void clickCollapseArrow() {
		collapseArrow().click();
	}

	public boolean isDashboardDisplayed() {
		try {
			return myTasksTitle().isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validSearchWorkflow(String taskName) {
		clickSearch();
		typeInSearchBar(taskName);
		boolean found = isTaskTitleContains(taskName);
		return found;
	}

	public boolean invalidSearchWorkflow(String taskName) {
		clickSearch();
		typeInSearchBar(taskName);
		boolean found = isTaskTitleContains(taskName);
		return !found;
	}

	public boolean resetSearchWorkflow(String taskName) {
		clickSearch();
		typeInSearchBar(taskName);
		clearSearchBar();
		return isSearchBarEmpty();
	}

	public boolean collapseArrowWorkflow() {
		clickCollapseArrow();
		return isDashboardDisplayed();
	}
}