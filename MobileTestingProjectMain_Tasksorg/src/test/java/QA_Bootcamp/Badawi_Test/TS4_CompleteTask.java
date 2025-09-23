package QA_Bootcamp.Badawi_Test;

import base.TestBase;
import org.testng.annotations.Test;
 
public class TS4_CompleteTask extends TestBase {
	
    @Test(priority = 1)
    public void AddDemoTasks() {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
	
        page.addDemoTasks(3);
    }
    
    @Test(priority = 2)
    public void MarkTaskComplete() {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
	
        for(int counter = 1; counter < 3; counter++) {
        page.markFirstTaskComplete();
        }
    }
    
    @Test(priority = 3)
    public void UndoCompletion() {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
	
        page.Undo();
    }
    
    @Test(priority = 4)
    public void MarkTaskUncomplete() {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
	
        page.markFirstTaskComplete();
        page.openCompletedList();
        page.UncompleteTask();
    }
    
    @Test(priority = 5)
    public void RabidCompleteClick() {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
        
        page.longPress(Pages.Badawi_TasksPage.TASK_ROW_INSTANCE_0, java.time.Duration.ofSeconds(2));
        page.openMoreOptionsTop();
        page.tapSelectAll();
        page.openMoreOptionsTop();
        page.Copy();
        page.confirmOk();
        
        for(int counter = 0; counter < 6; counter++) {
        page.markFirstTaskComplete();
        }
        page.openCompletedList();
        
        page.DeleteAll();
    }
    
    @Test(priority = 6)
    public void MarkTaskUncompleteDetail() throws InterruptedException {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.markFirstTaskComplete();
        page.openCompletedList();
        page.tapTask();
        page.DetailPageCheckbox();
        page.tapSave();
        
        page.DeleteAll();
    }
	
  @Test(priority = 7)
  public void MarkTaskCompleteDetail() throws InterruptedException {
      Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
      
      page.addDemoTasks(1);
      page.tapTask();
      page.DetailPageCheckbox();
      
      page.DeleteAll();
  }
    
    
    @Test(priority = 8)
    public void MarkCompleteWithSubtasks() throws InterruptedException {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.AddSubtaskTask(5);
        page.tapSave();
        page.markFirstTaskComplete();
	
        page.DeleteAll();
    }
	
    @Test(priority = 9)
    public void CompletePriority1() throws InterruptedException {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.SetPriority(1);
        page.AddSubtaskTask(2);
        page.tapSave();
        page.markFirstTaskComplete();
        
        page.DeleteAll();
    }
    
    @Test(priority = 10)
    public void CompletePriority2() throws InterruptedException {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.SetPriority(2);
        page.AddSubtaskTask(2);
        page.tapSave();
        page.markFirstTaskComplete();
        
        page.DeleteAll();
    }
    
    @Test(priority = 11)
    public void CompletePriority3() throws InterruptedException {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.SetPriority(3);
        page.AddSubtaskTask(2);
        page.tapSave();
        page.markFirstTaskComplete();
        
        page.DeleteAll();
    }
    
    @Test(priority = 12)
    public void CompletePriority4() throws InterruptedException {
        Pages.Badawi_TasksPage page = new Pages.Badawi_TasksPage(driver, wait);
        
        page.addDemoTasks(1);
        page.tapTask();
        page.SetPriority(4);
        page.AddSubtaskTask(2);
        page.tapSave();
        page.markFirstTaskComplete();
        
        page.DeleteAll();
    }
    
    

}