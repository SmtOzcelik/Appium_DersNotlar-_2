package techpro.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

public class C11_ScrollGesture extends ApiDemosBaseTest {
    @Test
    public void testScrollToElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //Bu test de istediğimiz elemente scrool yapacağız
        //scrollIntoView() icine atribute("value")-> scrollIntoView(attribute("value")) şeklinde
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Layouts\"))"));

    }
    @Test
    public void testScrollElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //verilen element kadar oranda kaydırma

        WebElement element=driver.findElement(AppiumBy.id("android:id/list"));
        //en genel locate aldım tam sayfa kadar istersek sadece 1 button kadar alanıbilir
        //o zaman da tam kaydırma cok az olur sürekli tekrar etmek durumunda kalınır

         driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                 "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",  //aşağı kadrımak için kod
                "percent", 1.0,           //istenilen alan kadar tam(1),yarım(0,5) kaydır
                 "speed",500
        ));
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",  //yukarı kadrımak için kod
                "percent", 0.5,           //istenilen alan kadar tam(1),yarım(0,5) kaydır
                "speed",500
        ));
         Thread.sleep(1000);
    }
    @Test
    public void testScrollCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        // element alanını kendimiz oluşturduk ve isteğimiz oran kadar kaydırma
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(

                /*
                left=x eksini ve telin sol üst köşeden sağa doğru artar
                top=y ekseni ve telin sol üst köşesinden aşağı doğru artar
                width=x eksini değeri gir scroll yapacak alanın x değeri
                height=y ekseni değeri gir scrool yapacak alanın y değeri
                 */
                "left", 100, "top", 150, "width", 200, "height", 1000,
                "direction", "down",
                "percent", 1.0,
                "speed",400
        ));

        Thread.sleep(1000);

    }

}
