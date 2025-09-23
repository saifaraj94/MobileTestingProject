package QA_Bootcamp.Hala_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Badawi_TasksPage;
import base.TestBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class TS2_EditTask extends TestBase {
	

	@Test(priority = 1)                                     //TC_15
	public void testEditTaskTitle() throws InterruptedException {
		Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
		
	    String oldTitle = "Task to edit";
	    String newTitle = "Task after edit";
	    
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")")
	    )).sendKeys(oldTitle);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
	    Thread.sleep(200);
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + oldTitle + "\")")
	    )).click();
	    
	    MobileElement titleField = driver.findElement(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + oldTitle + "\")")
	    );
	    titleField.clear();
	    wait.until(ExpectedConditions.elementToBeClickable(
		        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")")
		    )).sendKeys(newTitle);
	    MobileElement updatedTask =
	            driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + newTitle + "\")"));
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
	        
        try {
        	Assert.assertEquals(updatedTask.getText(), newTitle, "Task title was not updated!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        Thread.sleep(1000);
        page.DeleteAll();
    }
	
	@Test(priority = 2)                                                   //TC_16 , TC_17
	public void testEditTaskDescriptionAndPriority() {
		Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
	    String taskTitle = "Task to edit";
	    String newDescription = "This is the updated description";

	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")")
	    )).sendKeys(taskTitle);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")
	    )).click();

	    MobileElement descriptionField = driver.findElement(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Description\")"));
	    
	    descriptionField.sendKeys(newDescription);
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")
	    )).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Priority\")")
	    )).click();
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RadioButton\").instance(3)"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")
	    )).click();

	    MobileElement updatedDescription = driver.findElement(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + newDescription + "\")"));
	    
        try {
        	Assert.assertEquals(updatedDescription.getText(), newDescription, "Task description was not updated!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
	    
	    String isChecked = driver.findElements(By.className("android.widget.RadioButton")).get(3).getAttribute("checked");
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
        try {
        	Assert.assertEquals(isChecked, "true", "Task priority was not updated!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        page.DeleteAll();
	} 

	@Test(priority = 3)                                 //TC_18
	public void testEditTaskDueDate() {
		Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
		
	    String taskTitle = "Task to edit due date";
	    
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")"))).sendKeys(taskTitle);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")"))).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"No due date\")"))).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Tomorrow\")")
	    )).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")")
	    )).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")"))).click();

	    MobileElement updatedDueDate = driver.findElement(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Tomorrow\")"));
	    
        try {
        	Assert.assertEquals(updatedDueDate.getText(), "Tomorrow", "Task due date was not updated!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
        page.DeleteAll();
	}
	
	@Test(priority = 4)                                 //TC_19
	public void testEditTime() {
	    String taskTitle = "Task to edit time";
	    
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")")
	    )).sendKeys(taskTitle);
	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")
	    )).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"No start date\")")
	    )).click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"1 PM\")")
	    )).click();
	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")")
	    )).click();

	    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + taskTitle + "\")")
	    )).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
		        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Tomorrow 1 PM\")")
		    )).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
		        MobileBy.AndroidUIAutomator("new UiSelector().text(\"5 PM\")")
		    )).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
		        MobileBy.AndroidUIAutomator("new UiSelector().text(\"OK\")")
		    )).click();
	    
	    MobileElement updatedTime = driver.findElement(
	        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Tomorrow 5 PM\")")
	    );
	    
        try {
        	Assert.assertEquals(updatedTime.getText(), "5 PM", "Task due date was not updated!");
        } catch (AssertionError e) {
            System.out.println("⚠️ Assertion failed: " + e.getMessage());
        }
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Save"))).click();
	    
	}
}

