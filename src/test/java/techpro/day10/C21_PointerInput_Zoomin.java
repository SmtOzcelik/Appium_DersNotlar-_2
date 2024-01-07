package techpro.day10;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techpro.basestest.VodQABaseTest;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;

public class C21_PointerInput_Zoomin extends VodQABaseTest {
    @Test
    public void testZoomIn() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("login")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        Thread.sleep(2000);

        PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger2");

        Sequence sequence1=new Sequence(finger1,1);
        Sequence sequence2=new Sequence(finger2,2);

        // y kordinat ı sabit tut ve iki parmaktaki x aralığını da eşit yaparsak daha sağlıklı
        sequence1
                .addAction(finger1.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),550,1550))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(300)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(),200,1550))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        sequence2
                .addAction(finger2.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),750,1550))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2,Duration.ofMillis(300)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(),1200,1550))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence1,sequence2));

        Thread.sleep(2000);

    }
}
