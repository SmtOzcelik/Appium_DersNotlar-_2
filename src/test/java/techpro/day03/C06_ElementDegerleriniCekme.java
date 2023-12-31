package techpro.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C06_ElementDegerleriniCekme extends ApiDemosBaseTest {
    @Test
    public void testElementDegerleri() throws MalformedURLException, InterruptedException {

        By app= AppiumBy.accessibilityId("App");

        System.out.println("isDisplayed : "+driver.findElement(app).isDisplayed());
        System.out.println("isEnabled : " +driver.findElement(app).isEnabled());
        System.out.println("isSelected : "+driver.findElement(app).isSelected());

        System.out.println("getSize : "+driver.findElement(app).getSize());
        System.out.println("getLocation : "+driver.findElement(app).getLocation());


    }
}
