package techpro.basestest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiDemosBaseTest {
    public AndroidDriver driver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        String appPath = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";
        UiAutomator2Options options = new UiAutomator2Options() // platformName ve automationName defealt olarak tanımlı
                .setApp(appPath);
        URL url = new URL("http://0.0.0.0:4723");
         driver = new AndroidDriver(url, options);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
