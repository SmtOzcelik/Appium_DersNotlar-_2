package techpro.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetupDriver {

    @Test
    public void testDesiredCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("app", "/Users/sametozcelik/IdeaProjects/Appium_2024/src/test/resources/ApiDemos-debug.apk");
        //capabilities.setCapability("appPackage","io.appium.android.apis");
       //capabilities.setCapability("appActivity",".ApiDemos t16");

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver=new AndroidDriver(url,capabilities);
    }

    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options() // platformName ve automationName defealt olarak tanımlı
                .setUdid("emulator-5554") // birden fazla cihaz var ise gerekli
                //.setApp("/Users/sametozcelik/IdeaProjects/Appium_2024/src/test/resources/ApiDemos-debug.apk")
               .setAppPackage("io.appium.android.apis")
                 .setAppActivity(".ApiDemos t16")
                ;

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver=new AndroidDriver(url,options);
    }
}
