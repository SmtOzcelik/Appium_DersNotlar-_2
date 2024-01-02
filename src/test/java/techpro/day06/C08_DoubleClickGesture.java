package techpro.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techpro.basestest.HesapMasinesiBaseTest;

public class C08_DoubleClickGesture extends HesapMasinesiBaseTest {
    @Test
    public void testDoubleClickGesture(){
        //Bu test de sayıyı duble clik yapıp seçemedik o yuzden cordinat a ile aşağıda yaptık
        driver.findElement(num9).click();
        driver.findElement(num8).click();
        driver.findElement(num7).click();

        WebElement element=driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));

       // driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
       //         "elementId", ((RemoteWebElement) element).getId()
       //   ));
        doubleClickGesture(driver,element);
    }

    @Test
    public void testDoubleClickGestureCoordinate(){
        driver.findElement(num9).click();
        driver.findElement(num8).click();
        driver.findElement(num7).click();

        //driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
        //        "x",875,
        //        "y",400
        //   ));
        doubleClickGesture(driver,875,400);
    }

}
