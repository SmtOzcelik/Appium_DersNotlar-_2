package techpro.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

public class C09_LongClickGesture extends ApiDemosBaseTest {
    @Test
    public void testLongClickGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();

        WebElement longPressMe=driver.findElement(AppiumBy.accessibilityId("Long press me"));

       // driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
       //         "elementId", ((RemoteWebElement) longPressMe).getId(),
       //         "duration",1000
       //   ));
        longClickGesture(driver,longPressMe);

        Thread.sleep(2000);
    }
    @Test
    public void testLongClickGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();

       // driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
       //         "x",700,
       //         "y",550,
       //         "duration",1000
       //  ));

        longClickGesture(driver,700,550);


        Thread.sleep(2000);
    }
}
