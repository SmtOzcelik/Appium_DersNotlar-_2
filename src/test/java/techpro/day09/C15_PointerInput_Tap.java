package techpro.day09;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C15_PointerInput_Tap extends ApiDemosBaseTest {
    @Test
    public void testTap() throws InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence=new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),750,1750))//parmaği kordinata götür
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//parmağı bas
                .addAction(new Pause(finger,Duration.ofMillis(300))) //ne kadar basılı bekleyecek
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); //parmağı kaldır

        driver.perform(Collections.singleton(sequence));//Sıralı adımları topluca eyleme dönüştürür.

        Thread.sleep(2000);
    }
}
