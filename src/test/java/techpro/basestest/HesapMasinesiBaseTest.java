package techpro.basestest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import techpro.utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HesapMasinesiBaseTest extends ReusableMethods {

    public AndroidDriver driver;
    public By num0= AppiumBy.accessibilityId("0");
    public By num1=AppiumBy.accessibilityId("1");
    public By num2=AppiumBy.accessibilityId("2");
    public By num3=AppiumBy.accessibilityId("3");
    public By num4=AppiumBy.accessibilityId("4");
    public By num5=AppiumBy.accessibilityId("5");
    public By num6=AppiumBy.accessibilityId("6");
    public By num7=AppiumBy.accessibilityId("7");
    public By num8=AppiumBy.accessibilityId("8");
    public By num9=AppiumBy.accessibilityId("9");
    public By topla=AppiumBy.accessibilityId("plus");
    public By cikar=AppiumBy.accessibilityId("minus");
    public By carp=AppiumBy.accessibilityId("multiply");
    public By bol=AppiumBy.accessibilityId("divide");
    public By eq=AppiumBy.accessibilityId("equals");
    public By resultContain=AppiumBy.id("com.google.android.calculator:id/result_preview");
    public By resultFinal=AppiumBy.id("com.google.android.calculator:id/result_final");

    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setAppPackage("com.google.android.calculator")
                .setAppActivity("com.android.calculator2.Calculator t21");
        URL url=new URL("http://0.0.0.0:4723");
         driver=new AndroidDriver(url,options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
