package setDueDate_TimeReminderPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class TasksPageSaif {
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    private final String addTaskButton = "new UiSelector().description(\"Create new task\")";
    private final String taskTitleField = "new UiSelector().text(\"Task name\")";
    private final String saveTaskButton = "Save";
    private final String addReminderText = "new UiSelector().textContains(\"Add reminder\")";
    private final String reminderWhenStarted = "new UiSelector().textContains(\"When started\")";
    private final String reminderRandom = "new UiSelector().textContains(\"Random\")";
    private final String reminderWhenOverdue = "new UiSelector().textContains(\"When overdue\")";
    private final String reminderTimeField = "new UiSelector().className(\"android.widget.EditText\")";
    private final String okButtonText = "OK";
    private final String reminderPickDateTime = "new UiSelector().textContains(\"Pick a date and time\")";
    private final String reminderWhenDue = "new UiSelector().textContains(\"When due\")";
    private final String calendarDay26 = "new UiSelector().text(\"Friday, September 26, 2025\")";
    private final String clockHour2 = "new UiSelector().description(\"2 o'clock\")";
    private final String clockMinute50 = "new UiSelector().description(\"50 minutes\")";
    private final String repeatOption = "new UiSelector().textContains(\"Repeat\")";
    private final String repeatDaily = "new UiSelector().textContains(\"Every day\")";
    private final String repeatWeekly = "new UiSelector().textContains(\"Every week\")";
    private final String repeatNever = "new UiSelector().textContains(\"Does not repeat\")";
    private final String noStartDate = "new UiSelector().textContains(\"No start date\")";
    private final String dueTimeOption = "new UiSelector().text(\"Due time\")";
    private final String noDueDate = "new UiSelector().textContains(\"No due date\")";
    private final String tomorrowOption = "new UiSelector().text(\"Tomorrow\")";
    private final String removeReminderX = "new UiSelector().className(\"android.widget.Button\").instance(1)";
    private final String removeDefaultReminderX = 
    	    "new UiSelector().textContains(\"When due\").fromParent(new UiSelector().className(\"android.widget.Button\"))";

    public TasksPageSaif(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void saveTask() {
    	driver.findElement(MobileBy.AccessibilityId(saveTaskButton)).click();
    }
    
    public void openTaskByTitle(String title) {
        scrollToElement("new UiSelector().text(\"" + title + "\")");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + title + "\")"))).click();
    }

    public boolean isTaskPresent(String title) {
        return !driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + title + "\")")).isEmpty();
    }

    public void addReminderRandomDefault15() {
        scrollToElement(addReminderText);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(addReminderText))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderRandom))).click();
        pressOkButton();
    }
    
    public void addReminderRandomCustom(String minutes) {
        scrollToElement(addReminderText);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(addReminderText))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderRandom))).click();
        MobileElement reminderField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderTimeField)));
        reminderField.click();
        reminderField.clear();
        reminderField.sendKeys(minutes);
        pressOkButton();
    }

    public void addReminderWhenOverdueWithDueDate() {
        scrollToElement(addReminderText);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(addReminderText))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderWhenOverdue))).click();
        scrollToElement(noDueDate);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(noDueDate))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(tomorrowOption))).click();
        pressOkButton();
    }
    
    public void removeReminder() {
        scrollToElement(addReminderText);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(removeReminderX))).click();
    }

    public void addReminderPickDateTime() {
        scrollToElement(addReminderText);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(addReminderText))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderPickDateTime))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(calendarDay26))).click();
        pressOkButton();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(clockHour2))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(clockMinute50))).click();
        pressOkButton();
    }

    public void addReminderWhenDue() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(addReminderText))).click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderWhenDue))).click();
        pressOkButton();
    }

    public void addReminderWhenStartedWithDates() {
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(addReminderText))).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderWhenStarted))).click();
    	 scrollToElement(noStartDate);
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(noStartDate))).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(dueTimeOption))).click();
    	 pressOkButton();
    	 scrollToElement(noDueDate);
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(noDueDate))).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(tomorrowOption))).click();
    	 pressOkButton();
    	}
       
    public void addRecurringTaskDaily() {
    	 scrollToElement(repeatOption);
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(repeatOption))).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(repeatDaily))).click();
    	}

	public void addRecurringTaskWeekly() {
	    scrollToElement(repeatOption);
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(repeatOption))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(repeatWeekly))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(noDueDate))).click();
   	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(tomorrowOption))).click();
   	    pressOkButton();
	    }
	public void removeRecurringTask() {
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(repeatOption))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(repeatNever))).click();
	    }
	public void openAddTask() {
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(addTaskButton))).click();
	    }

	 public void removeDefaultReminder() {
	    scrollToElement(addReminderText);
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(removeDefaultReminderX))).click();
	    }

	    public void enterTaskTitle(String title) {
	        MobileElement field = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(taskTitleField)));
	        field.click();
	        field.clear();
	        field.sendKeys(title);
	        try {
	        	driver.hideKeyboard(); 
	        } catch (Exception ignored) {}
	    }

	    public void scrollToElement(String uiSelector) {
	        int attempts = 0;
	        while (attempts < 5) {
	            try {
	                MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(uiSelector));
	                if (element.isDisplayed()) break;
	            } catch (Exception e) {
	                new TouchAction<>(driver).press(PointOption.point(500, 1500))
	                        .moveTo(PointOption.point(500, 500))
	                        .release()
	                        .perform();
	            }
	            attempts++;
	        }
	    }

	    public void pressOkButton() {
	        MobileElement okBtn = wait.until(driver -> {
	            List<MobileElement> elements = driver.findElements(MobileBy.xpath("//*[contains(@text,'" + okButtonText + "')]"));
	            for (MobileElement el : elements) {
	                if (el.isDisplayed() && el.isEnabled()) return el;
	            }
	            return null;});
	        okBtn.click();
	    }

	    public void enableRemindersAndSetReminderDefault15() {
	        try {
	            driver.hideKeyboard();
	        } catch (Exception e) {
	        	
	        }
	        boolean enabledClicked = false;
	        int attempts = 0;
	        while (attempts < 5) {
	            try {
	                List<MobileElement> enableButtons = driver.findElements(
	                        MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Enable reminders\")"));
	                if (!enableButtons.isEmpty() && enableButtons.get(0).isDisplayed()) {
	                    enableButtons.get(0).click();
	                    enabledClicked = true;
	                    try {
	                        MobileElement allowBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
	                                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Allow\")")));
	                        allowBtn.click();
	                    } catch (Exception e) {
	                        System.out.println("No Allow popup detected.");
	                    }
	                    break;
	                } else {
	                    new TouchAction<>(driver)
	                            .press(PointOption.point(500, 1500))
	                            .moveTo(PointOption.point(500, 800))
	                            .release()
	                            .perform();
	                    Thread.sleep(500);
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            attempts++;
	        }
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(addReminderText))).click();
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderRandom))).click();
	        pressOkButton();
	    }

	    public void editReminderRandomToCustom(String minutes) {
	        scrollToElement(addReminderText);
	        MobileElement addReminderBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable( MobileBy.AndroidUIAutomator(addReminderText)));
	        addReminderBtn.click();
	        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderRandom))).click();
	        MobileElement reminderField = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(reminderTimeField)));
	        reminderField.click();
	        reminderField.clear();
	        reminderField.sendKeys(minutes);
	        pressOkButton();

		}
	    public void toggleDueDateTomorrowToNoDate() {
	        scrollToElement(addReminderText); 
	        MobileElement dueDateBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
	                MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"No due date\")")));
	        dueDateBtn.click();
	        MobileElement tomorrowBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
	                MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Tomorrow\")")));
	        tomorrowBtn.click();
	        pressOkButton();
	        dueDateBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
	                MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Tomorrow\")")));
	        dueDateBtn.click();
	        MobileElement noDateBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
	                MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"No date\")")));
	        noDateBtn.click();
	        pressOkButton();
	       
	       
	    }
	    public void removeDueDate() {
	        scrollToElement(addReminderText);
	        MobileElement dueDateBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
	                MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Tomorrow\")")));
	        dueDateBtn.click();
	        MobileElement noDueDateBtn = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(
	                MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"No due date\")")));
	        noDueDateBtn.click();
	        pressOkButton();
	    }


	        
	       

	   
	    }
			

	    
	

		
	

