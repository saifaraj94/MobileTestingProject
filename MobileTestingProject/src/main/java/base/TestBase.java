package base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
	protected AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "16.0");
        caps.setCapability("deviceName", "pixel_9_pro_api_36.0"); // Emulator name
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "C:\\Users\\user\\Downloads\\duolingo.apk");
        caps.setCapability("appPackage", "com.duolingo");
        caps.setCapability("appActivity", "com.duolingo.app.LoginActivity");
        caps.setCapability("noReset", false);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"), caps);
    }

   @AfterMethod
   public void tearDown() {
       if (driver != null) {
           driver.quit();
       }
    }
}

	