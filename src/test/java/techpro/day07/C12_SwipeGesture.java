package techpro.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

public class C12_SwipeGesture extends ApiDemosBaseTest {
    @Test
    public void testSwipeGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        //Application olacak olan en geniş alanı locate ettik
        //locatin kapladığı alanı seçtik demek
        WebElement element=driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",  //sağı görmek için kaydırma sola
                "percent", 1 ,  //0-1 arasında olmak zorunda
                "speed",500
        ));
        Thread.sleep(1000);
    }
    @Test
    public void testSwipeGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        //left ve top ile başlangıç belirle width ve height ile tekrar edecek alan
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 300, "width", 900, "height", 200,
                "direction", "left",  //sağı görmek için kaydırma sola
                "percent", 1 ,  //0-1 arasında olmak zorunda
                "speed",500
        ));
        Thread.sleep(1000);
    }
}
