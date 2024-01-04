package techpro.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techpro.basestest.VodQABaseTest;

public class C14_PinchOpenAndCloseGesture extends VodQABaseTest {
    @Test
    public void testPinchOpenAndCloseGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("login")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        WebElement element=driver.findElement(AppiumBy.className("android.widget.ImageView"));
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
               "elementId", ((RemoteWebElement) element).getId(),
                "percent",0.75, // 0-1 arası yazılabilir
                "speed",500
                ));
        Thread.sleep(1000);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent",0.75, // 0-1 arası yazılabilir
                "speed",500
        ));
        Thread.sleep(1000);
    }
    @Test
    public void testPinchOpenAndCloseGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("login")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        Thread.sleep(1000);
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 300, "top", 1300, "width", 800, "height", 500,
                "percent",0.75, // 0-1 arası yazılabilir
                "speed",500
        ));
        Thread.sleep(1000);

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 300, "top", 1300, "width", 800, "height", 500,
                "percent",0.75, // 0-1 arası yazılabilir
                "speed",500
        ));

    }
}
