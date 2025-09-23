package QA_Bootcamp.Badawi_Test;

import base.TestBase;
import org.testng.annotations.Test;

import Pages.Badawi_TasksPage;

public class TS3_DeleteTask extends TestBase {

    @Test(priority = 1)
    public void AddDemoTasks() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        page.addDemoTasks(3);
    }

    @Test(priority = 2)
    public void DeleteTask() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        page.longPressDefaultFirstRow();
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }

    @Test(priority = 3)
    public void CancelDeleteTask() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        page.longPressDefaultFirstRow();
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmCancel();
    }

    @Test(priority = 4)
    public void DeleteFromTask() throws InterruptedException {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        Thread.sleep(1000);
        page.tapTaskRowBody();    
        page.tapTaskRowBody();    
        page.tapDeleteTaskIcon();
        page.confirmOk();
    }

    @Test(priority = 5)
    public void DeleteMultipleTasks() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(3);
        page.openDefaultListFromMenu();
        page.longPressDefaultFirstRow();
        page.selectAdditionalTasks(1, 2);
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }

    @Test(priority = 6)
    public void DeleteAllTask() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(3);
        page.openDefaultListFromMenu();
        page.longPressDefaultFirstRow();
        page.openMoreOptionsTop();
        page.tapSelectAll();
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }

    @Test(priority = 7)
    public void ClearCompleteTask() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(2);
        page.markFirstTaskComplete();
        page.openCompletedList();
        page.openMoreOptionsBottom();
        page.tapClearCompleted();
        page.confirmOk();
    }

    @Test(priority = 8)
    public void DeleteMixedTask() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(3);
        page.markFirstTaskComplete();
        page.markFirstTaskComplete();
        page.longPressDefaultFirstRow();
        page.openMoreOptionsTop();
        page.tapSelectAll();
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }

    @Test(priority = 9)
    public void DeleteFromSearch() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.openSearch();
        page.typeInSearch("Demo Task");
        page.longPress(Badawi_TasksPage.TASK_ROW_INSTANCE_0, java.time.Duration.ofSeconds(2));
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }
    
    @Test(priority = 10)
    public void DeletePriority1() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.SetPriority(1);
        page.tapSave();
        page.longPress(Badawi_TasksPage.TASK_ROW_INSTANCE_0, java.time.Duration.ofSeconds(2));
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }
    
    @Test(priority = 11)
    public void DeletePriority2() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.SetPriority(2);
        page.tapSave();
        page.longPress(Badawi_TasksPage.TASK_ROW_INSTANCE_0, java.time.Duration.ofSeconds(2));
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }
    
    @Test(priority = 12)
    public void DeletePriority3() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.SetPriority(3);
        page.tapSave();
        page.longPress(Badawi_TasksPage.TASK_ROW_INSTANCE_0, java.time.Duration.ofSeconds(2));
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }
    
    @Test(priority = 13)
    public void DeletePriority4() {
        Badawi_TasksPage page = new Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.SetPriority(4);
        page.tapSave();
        page.longPress(Badawi_TasksPage.TASK_ROW_INSTANCE_0, java.time.Duration.ofSeconds(2));
        page.openMoreOptionsTop();
        page.tapDeleteOption();
        page.confirmOk();
    }
    
}
