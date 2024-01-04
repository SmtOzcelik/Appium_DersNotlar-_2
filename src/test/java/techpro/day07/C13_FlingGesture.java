package techpro.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

public class C13_FlingGesture extends ApiDemosBaseTest {
    @Test
    public void testSwipeGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //Application olacak olan en geniş alanı locate ettik
        //locatin kapladığı alanı seçtik demek
        WebElement element=driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "speed",5000
        ));
        Thread.sleep(1000);
    }
    @Test
    public void testSwipeGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        //left ve top ile başlangıç belirle width ve height ile tekrar edecek alan
        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "left", 100, "top", 300, "width", 0, "height", 1000,
                "direction", "down",
                "speed",8000
        ));
        Thread.sleep(1000);
    }
}
