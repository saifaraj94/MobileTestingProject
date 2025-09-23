package Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class Badawi_TasksPage {

    @SuppressWarnings("rawtypes")
	private final AndroidDriver driver;
    private final WebDriverWait wait;

    public static final By TASK_NAME_FIELD       = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Task name\")");
    public static final By TASK_ROW_INSTANCE_0   = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/row\").instance(0)");
    public static final By MORE_OPTIONS_TOP_2    = MobileBy.AndroidUIAutomator("new UiSelector().description(\"More options\").instance(2)");
    public static final By SELECT_ALL_OPTION     = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Select all\")");    
    public static final By SHARE_OPTION          = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Share\")");
    public static final By COPY_OPTION           = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Copy\")");
    public static final By DELETE_OPTION         = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Delete\")");
    public static final By DEFAULT_LIST_ITEM     = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Default list\").instance(0)");
    public static final By MAIN_MENU_BTN         = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\").instance(0)"); 
    public static final By COMPLETE_BOX_INSTANCE0= MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/completeBox\").instance(0)");
    public static final By COMPLETED_LIST_ITEM   = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Completed\")");
    public static final By MORE_OPTIONS_BOTTOM_1 = MobileBy.AndroidUIAutomator("new UiSelector().description(\"More options\").instance(1)");
    public static final By CLEAR_COMPLETED       = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Clear Completed\")");
    public static final By ADD_LOCATION_TEXT     = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Add location\")");
    public static final By UNCOMPLETE_BOX		 = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/completeBox\").instance(2)");
    public static final By ADD_SUBTASK			 = MobileBy.AndroidUIAutomator("new UiSelector().text(\"Add subtask\")");
    public static final By ADD_SUBTASK_TASK		 = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(24)");
    public static final By DETAIL_PAGE_CHECKBOX	 = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)");
    public static final By PRIORITY1			 = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RadioButton\").instance(0)");
    public static final By PRIORITY2			 = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RadioButton\").instance(1)");
    public static final By PRIORITY3			 = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RadioButton\").instance(2)");
    public static final By PRIORITY4			 = MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RadioButton\").instance(3)");
    public static final By SEARCH_ICON           = MobileBy.AccessibilityId("Search");
    public static final By INBOX_ALL             = MobileBy.AccessibilityId("all_inbox");   
    public static final By DELETE_TASK_ICON      = MobileBy.AccessibilityId("Delete task");
    public static final By SAVE_BTN              = MobileBy.AccessibilityId("Save");
    public static final By ADD_TASK_BTN          = MobileBy.AccessibilityId("Create new task");
    public static final By OK_BTN                = MobileBy.id("android:id/button1");
    public static final By CANCEL_BTN            = MobileBy.id("android:id/button2");
    public static final By TASK_CLICK_AREA       = MobileBy.id("org.tasks:id/rowBody");
    public static final By SELECT_THIS_LOCATION  = MobileBy.id("org.tasks:id/select_this_location");
    public static final By UNDO					 = MobileBy.id("org.tasks:id/snackbar_action");
    public static final By SEARCH_FIELD          = MobileBy.id("org.tasks:id/search_src_text");
    
    
    @SuppressWarnings("rawtypes")
	public Badawi_TasksPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void DeleteAll() {
        longPress(Badawi_TasksPage.TASK_ROW_INSTANCE_0, java.time.Duration.ofSeconds(2));
        openMoreOptionsTop();
        tapSelectAll();
        openMoreOptionsTop();
        tapDeleteOption();
        confirmOk();
    }

    public void SetPriority(int p) {
    	wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RadioButton\").instance("+(p-1)+")"))).click();
    }
    
    public void tapTask() {
    	wait.until(ExpectedConditions.elementToBeClickable(TASK_ROW_INSTANCE_0)).click();
    }
    
    public void tapAddTask() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_TASK_BTN)).click();
    }

    public void typeTaskName(String name) {
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(TASK_NAME_FIELD));
        box.clear();
        box.sendKeys(name);
        try { driver.hideKeyboard(); } catch (Exception ignored) {}
    }

    public void tapSave() {
        wait.until(ExpectedConditions.elementToBeClickable(SAVE_BTN)).click();
    }
    
    public void AddSubtask() {
    	wait.until(ExpectedConditions.elementToBeClickable(ADD_SUBTASK)).click();
    }
    
    public void AddSubtaskTask(int  count) throws InterruptedException {
    	for(int counter = 1; counter <= count; counter++) {
    		AddSubtask();
    		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance("+counter+")"))).click();
    		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance("+counter+")"))).sendKeys("SubTask: "+ counter+"");
    	}
    }

    public void openDefaultListFromMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(MAIN_MENU_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(INBOX_ALL)).click();
        wait.until(ExpectedConditions.elementToBeClickable(DEFAULT_LIST_ITEM)).click();
    }

    public void addSingleTask(String name) {
        tapAddTask();
        typeTaskName(name);
        tapSave();
    }

    public int addDemoTasks(int count) {
        for (int counter = 0; counter < count; counter++) {
            addSingleTask("Demo Task: " + counter);
        }
        return count;
    }

    public void longPress(By locator, Duration hold) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence seq = new Sequence(finger, 1);
        seq.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(element), 0, 0));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(new org.openqa.selenium.interactions.Pause(finger, hold));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));
    }

    public void longPressDefaultFirstRow() {
        longPress(TASK_ROW_INSTANCE_0, Duration.ofSeconds(2));
    }

    public void openMoreOptionsTop() {
        wait.until(ExpectedConditions.elementToBeClickable(MORE_OPTIONS_TOP_2)).click();
    }

    public void tapDeleteOption() {
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_OPTION)).click();
    }

    public void confirmOk() {
        wait.until(ExpectedConditions.elementToBeClickable(OK_BTN)).click();
    }

    public void confirmCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(CANCEL_BTN)).click();
    }

    public void tapTaskRowBody() {
        wait.until(ExpectedConditions.elementToBeClickable(TASK_CLICK_AREA)).click();
    }

    public void tapDeleteTaskIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_TASK_ICON)).click();
    }

    public void tapSelectAll() {
        wait.until(ExpectedConditions.elementToBeClickable(SELECT_ALL_OPTION)).click();
    }

    public void markFirstTaskComplete() {
        wait.until(ExpectedConditions.elementToBeClickable(COMPLETE_BOX_INSTANCE0)).click();
    }

    public void openCompletedList() {
        wait.until(ExpectedConditions.elementToBeClickable(COMPLETED_LIST_ITEM)).click();
    }

    public void openMoreOptionsBottom() {
        wait.until(ExpectedConditions.elementToBeClickable(MORE_OPTIONS_BOTTOM_1)).click();
    }

    public void tapClearCompleted() {
        wait.until(ExpectedConditions.elementToBeClickable(CLEAR_COMPLETED)).click();
    }

    public void openSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_ICON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD)).click();
    }

    public void typeInSearch(String text) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(SEARCH_FIELD));
        field.clear();
        field.sendKeys(text);
        try { driver.hideKeyboard(); } catch (Exception ignored) {}
    }

    public By taskRowBodyInstance(int index) {
 
        String uia = String.format("new UiSelector().resourceId(\"org.tasks:id/rowBody\").instance(%d)", index);
        return MobileBy.AndroidUIAutomator(uia);
    }

    public void selectAdditionalTasks(int startInclusive, int endInclusive) {
        for (int i = startInclusive; i <= endInclusive; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(taskRowBodyInstance(i))).click();
        }
    }

    public void addLocationToCurrentEditor() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_LOCATION_TEXT)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SELECT_THIS_LOCATION)).click();
    }
    
    public void Undo() {
    	wait.until(ExpectedConditions.elementToBeClickable(UNDO)).click();
    }
    
    public void UncompleteTask() {
    	wait.until(ExpectedConditions.elementToBeClickable(UNCOMPLETE_BOX)).click();
    }
    
    public void Copy() {
    	wait.until(ExpectedConditions.elementToBeClickable(COPY_OPTION)).click();
    }
    
    public void DetailPageCheckbox() {
    	wait.until(ExpectedConditions.elementToBeClickable(DETAIL_PAGE_CHECKBOX)).click();
    }
   
}