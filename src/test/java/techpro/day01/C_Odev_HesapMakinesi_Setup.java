package techpro.day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C_Odev_HesapMakinesi_Setup {

    @Test
    public void test() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setAppPackage("com.google.android.calculator")
                .setAppActivity("com.android.calculator2.Calculator t21");
        URL url=new URL("http://0.0.0.0:4723");
        AndroidDriver driver=new AndroidDriver(url,options);
    }
}
