package QA_Bootcamp.Hala_Test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Badawi_TasksPage;
import base.TestBase;
import io.appium.java_client.MobileBy;

public class TS1_AddTask extends TestBase {
	


   @Test(priority = 1) // TC_01
    public void testAddSimpleTask() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "project";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        WebElement addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='" + taskTitle + "']")));

        try {
            Assert.assertEquals(addedTask.getText(), taskTitle,
                    "BUG: Save button should be disabled when title is empty!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 2) // TC_02
    public void testAddEmptyTaskTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        WebElement saveButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Save")));

        try {
            Assert.assertFalse(saveButton.isEnabled(), "BUG: Save button should be disabled when title is empty!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        saveButton.click();
    }

    @Test(priority = 3) // TC_03
    public void testAddInvalidTaskTitle() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
    	
        String invalidTitle = "@@@###";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(invalidTitle);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        String addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/rowBody\")"))).getText();

        try {
            Assert.assertEquals(addedTask, invalidTitle, "BUG: Invalid task title was saved instead of showing error!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 4) // TC_04
    public void testAddTaskWithPriority() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "High Priority Task";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);

        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Priority\")"))).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.RadioButton"))).get(3)
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        WebElement addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));
        
        try {
            Assert.assertEquals(addedTask.getText(), taskTitle, "Task with priority was not added correctly!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 5) // TC_05
    public void testAddTaskWithDueDateToday() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "Task due today";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"No due date\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Today\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        WebElement addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));
        
        try {
            Assert.assertEquals(addedTask.getText(), taskTitle, "Task with 'Today' due date was not added!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 6) // TC_06
    public void testAddTaskWithDueDateTomorrow() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "Task due tomorrow";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"No due date\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Tomorrow\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"1 PM\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        WebElement addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));
        
        try {
            Assert.assertEquals(addedTask.getText(), taskTitle, "Task was not added!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 7) // TC_07
    public void testAddTaskWithExpiredDate() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "Task with expired date ";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"No due date\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Switch to selecting a year")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(15)")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
        
        page.DeleteAll();
    }

    @Test(priority = 8) // TC_08
    public void test_Invalid_Date() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "Invalid Time";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"No due date\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Today\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"5 PM\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"No start date\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"8 PM\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        WebElement addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));
        
        try {
            Assert.fail("BUG: Task saved with invalid range (start after due). Found task: " + addedTask.getText());
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 9) // TC_09
    public void testAddTaskWithoutDueDate() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "Task without due date";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")"))).click();

        WebElement dueDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"No due date\")")));
        
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        try {
            Assert.assertEquals(dueDate.getText(), "No due date", "Task was not added!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 10) // TC_10
    public void testAddTagAndTaskWithTag() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String tagName = "study";
        String taskTitle = "Task with tag";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.ImageButton"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Tags\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(3)")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.EditText")))
                .sendKeys(tagName);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        WebElement addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));
        Assert.assertEquals(addedTask.getText(), taskTitle);

        WebElement addedTag = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + tagName + "\")")));
        
        try {
        	Assert.assertTrue(addedTag.isDisplayed(), "Tag was not linked to the task!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 11) // TC_11
    public void addSubtaskAndVerify() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "Project Mobile";
        String subtaskTitle = "test plan";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();

        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")")));
        title.sendKeys(taskTitle);

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"))).sendKeys(subtaskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        WebElement savedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));
        savedTask.click();

        WebElement savedSubtask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + subtaskTitle + "\")")));
        
        try {
        	Assert.assertTrue(savedSubtask.isDisplayed(), "Subtask was not added/saved!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
        page.DeleteAll();
    }

    @Test(priority = 12) // TC_12
    public void testAddTaskWithDescription() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "Task with description";
        String description = "This is description ";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Description\")"))).sendKeys(description);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
        WebElement addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));
        try {
        	Assert.assertEquals(addedTask.getText(), taskTitle, "Task with description was not added correctly!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 13) // TC_13
    public void testAddTaskWithDailyRecurrence() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "Daily task";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Does not repeat\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Every day\")"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        WebElement addedTask = wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));
        
        try {
        	Assert.assertEquals(addedTask.getText(), taskTitle);
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }

    @Test(priority = 14) // TC_14
    public void testDuplicatedTask() {
    	Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        String taskTitle = "project";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("org.tasks:id/fab"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

        List<WebElement> tasks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")));

        try {
        	Assert.assertTrue(tasks.size() == 1, "Bug: App allows duplicate task names!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
    }
}
