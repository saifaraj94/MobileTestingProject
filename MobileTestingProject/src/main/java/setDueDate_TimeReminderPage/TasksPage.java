package setDueDate_TimeReminderPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class TasksPage {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    // Locators
    private final String addTaskButton = "new UiSelector().description(\"Create new task\")";
    private final String taskTitleField = "new UiSelector().text(\"Task name\")";
    private final String noStartDateField = "new UiSelector().className(\"android.view.View\").instance(6)";
    private final String dueDateButton = "new UiSelector().text(\"Due date\")";
    private final String noDueDateButton = "new UiSelector().text(\"No due date\")";
    private final String tomorrowButton = "new UiSelector().text(\"Tomorrow\")";
    private final String saveTaskButton = "new UiSelector().className(\"android.widget.Button\").instance(1)";
    private final String completedTab = "new UiSelector().text(\"Completed\")";
    private final String completeTaskCheckbox = "new UiSelector().resourceId(\"org.tasks:id/completeBox\")";
    private final String deleteIcon = "new UiSelector().className(\"android.widget.Button\").instance(2)";
    private final String duplicateIcon = "new UiSelector().description(\"Duplicate\")";
    private final String okButtonText = "OK";
    private final String threeDotMenu = "new UiSelector().description(\"More options\")";
    private final String deleteSelectedButton = "new UiSelector().text(\"Delete\")";
    private final String priorityCircle = "new UiSelector().className(\"android.view.View\").instance(1)"; 

    
    public TasksPage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Open Add Task screen
    public void openAddTask() {
        MobileElement button = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(addTaskButton)));
        button.click();
    }

    // Enter task title
    public void enterTaskTitle(String title) {
        MobileElement field = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(taskTitleField)));
        field.click();
        field.clear();
        field.sendKeys(title);
    }

    // Press OK dynamically
    public void pressOkButton() {
        MobileElement okBtn = wait.until(driver -> {
            List<MobileElement> elements = driver.findElements(MobileBy.xpath("//*[contains(@text,'" + okButtonText + "')]"));
            for (MobileElement el : elements) {
                if (el.isDisplayed() && el.isEnabled()) return el;
            }
            return null;
        });
        okBtn.click();
    }

    // Add due date & reminder
    public void addDueDateReminder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(noStartDateField))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(dueDateButton))).click();
        pressOkButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(noDueDateButton))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(tomorrowButton))).click();
        pressOkButton();
    }

    // Save task
    public void saveTask() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(saveTaskButton))).click();
    }

 // Complete a task by title (mark before saving)
    public void completeTaskByTitle(String title) {
        try {
            // Open task creation page
            openAddTask();
            enterTaskTitle(title);

            // Click on the completion checkbox BEFORE saving
            MobileElement completeCheckbox = (MobileElement) wait.until(
                    ExpectedConditions.elementToBeClickable(
                            MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)")
                    ));
            completeCheckbox.click();

            saveTask();
        } catch (Exception e) {
            System.out.println("Could not complete task: " + title + " -> " + e.getMessage());
        }
    }

    // Open Completed tab (via narrow)
    public void goToCompletedTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(completedTab))).click();
    }

 // Delete a task by title
    public void deleteTaskByTitle(String title) {
        List<MobileElement> tasks = driver.findElements(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + title + "\")"));
        if (!tasks.isEmpty()) {
            // Click on the task to open it
            tasks.get(0).click();

            // Click on Delete icon
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.AndroidUIAutomator(deleteIcon))).click();

            // Click OK in the confirmation dialog
            pressOkButton();
        }
    }

 // Duplicate task
    public void duplicateTaskByTitle(String title) {
        List<MobileElement> tasks = driver.findElements(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + title + "\")"));
        if (!tasks.isEmpty()) {
            // Click on the task to open it
            tasks.get(0).click();

            // Click on Duplicate icon
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(duplicateIcon))).click();

            // Click on the Task Name field to make sure the UI is ready
            MobileElement titleField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.AndroidUIAutomator(taskTitleField)));
            titleField.click();

            saveTask();
        }
    
    }
 // Edit task by title
    public void editTaskByTitle(String oldTitle, String newTitle) {
        // 1. Click on the task to open it
        MobileElement task = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + oldTitle + "\")")));
        task.click();

        // 2. Locate the text field by old title
        MobileElement titleFieldOld = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + oldTitle + "\")")));
        titleFieldOld.click();
        titleFieldOld.clear();

        // 3. After clearing, locate the field using placeholder "Task name"
        MobileElement titleFieldNew = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")")));
        titleFieldNew.click();
        titleFieldNew.sendKeys(newTitle);

        // 5. Save the task
        saveTask();
    }
    
 // Long press on a task
    public void longPressTask(String title) {
        List<MobileElement> tasks = driver.findElements(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + title + "\")"));
        if (!tasks.isEmpty()) {
            MobileElement task = tasks.get(0);
            new io.appium.java_client.TouchAction<>(driver)
                    .longPress(io.appium.java_client.touch.offset.ElementOption.element(task))
                    .release()
                    .perform();
        }
    }

    // Select another task (tap)
    public void selectTask(String title) {
        List<MobileElement> tasks = driver.findElements(
                MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + title + "\")"));
        if (!tasks.isEmpty()) {
            tasks.get(0).click();
        }
    }

    // Delete multiple selected tasks
    public void deleteMultipleTasks() {
        // Click the 3-dot menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(threeDotMenu))).click();

        // Click Delete
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(deleteSelectedButton))).click();

        // Confirm deletion
        pressOkButton();
    }

    // Check task exists
    public boolean isTaskPresent(String title) {
        return !driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + title + "\")")).isEmpty();
    }
    
    public void markTaskAsCompletedBeforeSave() {
        MobileElement completeCheckbox = (MobileElement) wait.until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)")
                ));
        completeCheckbox.click();
    }

    // Check task in completed
    public boolean isTaskInCompleted(String title) {
        goToCompletedTab();
        return isTaskPresent(title);
    }
}