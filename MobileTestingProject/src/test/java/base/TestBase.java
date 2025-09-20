package base;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

import java.net.URL;

public class TestBase {
	protected AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "13.0");
		caps.setCapability("deviceName", "pixel_7_Pro_api_33");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "org.tasks");
		caps.setCapability("appActivity", "org.tasks/com.todoroo.astrid.activity.TaskListActivity");
		caps.setCapability("noReset", true);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"), caps);
	}

	 @AfterClass
	 public void tearDown() {
	 if (driver != null) {
	 driver.quit();
	 }
	 }
}