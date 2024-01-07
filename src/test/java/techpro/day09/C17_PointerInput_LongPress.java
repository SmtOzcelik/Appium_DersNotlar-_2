package techpro.day09;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C17_PointerInput_LongPress extends ApiDemosBaseTest {

    @Test
    public void testLongTab() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();

        //x=700,y=550 duration=1000 coordinate

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence sequence=new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),700,550))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(1000)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

        Thread.sleep(1000);

    }
}
