package QA_Bootcamp.Saif_Test;
import base.TestBase;
import setDueDate_TimeReminderPage.TasksPageSaif;
import org.testng.Assert;
import org.testng.annotations.Test;
	public class TestingS extends TestBase {
		@Test(priority = 1)
		public void testEnableAndAddReminder() {
		    TasksPageSaif page = new TasksPageSaif(driver, wait);
		    String title = "Task_Reminder_1";
		    page.openAddTask();
		    page.enterTaskTitle(title);
		    page.enableRemindersAndSetReminderDefault15();
		    page.saveTask();
		    Assert.assertTrue(page.isTaskPresent(title));
		}
		
		@Test(priority = 2)
		public void testEditDueDateReminder() {
		    TasksPageSaif page = new TasksPageSaif(driver, wait);
		    String title = "Task_Reminder_1";
		    page.openTaskByTitle(title);
		    page.editReminderRandomToCustom("20");
		    page.saveTask();
		    Assert.assertTrue(page.isTaskPresent(title));
		}
		@Test(priority = 3)
		public void testSetDueDateThenClear() {
		    TasksPageSaif page = new TasksPageSaif(driver, wait);
		    String title = "Task_Reminder_1";
		    page.openTaskByTitle(title);
		    page.toggleDueDateTomorrowToNoDate();
		    page.saveTask();
		    Assert.assertTrue(page.isTaskPresent(title));
		}
		
		@Test(priority = 4)
		public void testAddReminderWhenStarted() {
		    TasksPageSaif page = new TasksPageSaif(driver, wait);
		    String title = "Task_WhenStarted";
		    page.openAddTask();
		    page.enterTaskTitle(title);
		    page.addReminderWhenStartedWithDates();
		    page.saveTask();
		    Assert.assertTrue(page.isTaskPresent(title));
		}
		
	
		@Test(priority = 5)
		public void testAddReminderWhenOverdue() {
		    TasksPageSaif page = new TasksPageSaif(driver, wait);
		    String title = "Task_WhenOverdue";
		    page.openAddTask();
		    page.enterTaskTitle(title);
		    page.addReminderWhenOverdueWithDueDate();
		    page.saveTask();
		    Assert.assertTrue(page.isTaskPresent(title));
		}
		
	    @Test(priority = 6)
	    public void testMultipleReminders() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        for (int input = 1; input <= 3; input++) {
	            String title = "Task_Reminder_" + input;
	            page.openAddTask();
	            page.enterTaskTitle(title);
	            page.addReminderRandomDefault15();
	            page.saveTask();
	            Assert.assertTrue(page.isTaskPresent(title));
	        }
	    }
	    @Test(priority = 7)
	    public void testEditMultipleRemindersTo20Min() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        for (int input = 1; input <= 3; input++) {
	            String title = "Task_Reminder_" + input;
	            page.openTaskByTitle(title);
	            page.addReminderRandomCustom("20");
	            page.saveTask();
	            Assert.assertTrue(page.isTaskPresent(title));
	        }
	    }
	   
	    @Test(priority = 8)
	    public void testRemoveMultipleReminders() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        for (int input = 1; input <= 3; input++) {
	            String title = "Task_Reminder_" + input;
	            page.openTaskByTitle(title);
	            page.removeReminder();  // clicks the X button beside the reminder
	            page.saveTask();        // save the task
	            Assert.assertTrue(page.isTaskPresent(title));
	        }
	    }
	  
	  
	    @Test(priority = 9)
	    public void testRemoveDefaultWhenDueReminder() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        String title = "Task_RemoveDefaultReminder";
	        page.openAddTask();
	        page.enterTaskTitle(title);
	        page.removeDefaultReminder();
	        page.saveTask();
	        Assert.assertTrue(page.isTaskPresent(title));
	    }
	   
	    @Test(priority = 10)
	    public void testAddAfterRemovingReminder() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        String title = "Task_AddAgain";
	        page.openAddTask();
	        page.enterTaskTitle(title);
	        page.addReminderRandomDefault15();
	        page.saveTask();
	        page.openTaskByTitle(title);
	        page.removeReminder();
	        page.addReminderWhenOverdueWithDueDate();
	        page.saveTask();
	        Assert.assertTrue(page.isTaskPresent(title));
	    }
	    @Test(priority = 11)
	    public void testAddReminderPickDateTime() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        String title = "Task_Reminder_DateTime";
	        page.openAddTask();
	        page.enterTaskTitle(title);
	        page.addReminderPickDateTime();
	        page.saveTask();
	        Assert.assertTrue(page.isTaskPresent(title));
	    }
	    @Test(priority = 12)
	    public void testCreateRecurringTaskDaily() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        String title = "Recurring_Daily_Task";
	        page.openAddTask();
	        page.enterTaskTitle(title);
	        page.addRecurringTaskDaily();
	        page.saveTask();
	        Assert.assertTrue(page.isTaskPresent(title));
	    }
	    @Test(priority = 13)
	    public void testCreateRecurringTaskWeekly() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        String title = "Recurring_Weekly_Task";
	        page.openAddTask();
	        page.enterTaskTitle(title);
	        page.addRecurringTaskWeekly();
	        page.saveTask();
	        Assert.assertTrue(page.isTaskPresent(title));
	    }
	    @Test(priority = 14)
	    public void testEditRecurringTaskToDaily() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        String title = "Recurring_Weekly_Task";
	        page.openTaskByTitle(title);
	        page.addRecurringTaskDaily();
	        page.saveTask();
	        Assert.assertTrue(page.isTaskPresent(title));
	    }
	    @Test(priority = 15)
	    public void testRemoveRecurringFromTask() {
	        TasksPageSaif page = new TasksPageSaif(driver, wait);
	        String title = "Recurring_Daily_Task";
	        page.openTaskByTitle(title);
	        page.removeRecurringTask();
	        page.saveTask();
	        Assert.assertTrue(page.isTaskPresent(title));
	    }
	}