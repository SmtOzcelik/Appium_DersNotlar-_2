package techpro.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

public class C10_DragGesture extends ApiDemosBaseTest {

    @Test
    public void testDragGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

         driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 850,
                "endY", 750,
                 "speed",500   // sürüklenmesini görmek için koyduk
        ));
         Thread.sleep(2000);
    }
    @Test
    public void testDragGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX",300,
                "startY",750,
                "endX", 850,
                "endY", 750,
                "speed",500   // sürüklenmesini görmek için koyduk
        ));
        Thread.sleep(2000);
    }
}
