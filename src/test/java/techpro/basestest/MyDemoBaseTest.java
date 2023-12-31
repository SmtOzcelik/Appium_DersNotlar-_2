package techpro.basestest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import techpro.utilities.ReusableMethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MyDemoBaseTest extends ReusableMethods {
    public AndroidDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        String appPath = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
        UiAutomator2Options options = new UiAutomator2Options() // platformName ve automationName defealt olarak tanımlı
                .setApp(appPath)
                .setUdid("emulator-5554");
        URL url = new URL("http://0.0.0.0:4723");
         driver = new AndroidDriver(url, options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
