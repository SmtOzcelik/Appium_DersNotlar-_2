package techpro.day09;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techpro.basestest.HesapMasinesiBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C16_PointerInput_DoubleTab extends HesapMasinesiBaseTest {

    @Test
    public void testDoubleTab() throws InterruptedException {
        driver.findElement(num9).click();
        driver.findElement(num8).click();
        driver.findElement(num7).click();

        //x=875,y=400  kordinatlar

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence sequence=new Sequence(finger,1)
                //ilk tıklama adımı
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),875,400))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

                //ikinci tıklama adımı
                .addAction(finger.createPointerMove(Duration.ofMillis(10),PointerInput.Origin.viewport(),870,405))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

        Thread.sleep(1000);

        //cut tik yap
        clickGesture(driver,718,831);

        Thread.sleep(1000);

    }
}
