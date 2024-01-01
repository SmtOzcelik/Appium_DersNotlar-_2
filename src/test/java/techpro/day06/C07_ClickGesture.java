package techpro.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

public class C07_ClickGesture extends ApiDemosBaseTest {

    @Test
    public void testClickGesture(){
        WebElement os=driver.findElement(AppiumBy.accessibilityId("OS"));
        /*
        Aşagıdaki kod os.click() ile aynı neden buna ihtiyac var bazen zor yerlerde
         click yapamıyor bu kesin çözüm diyebiliriz.2 yerde değişiklik yapıyoruz clickGesture ve os yeri element
         clickGesture,doubleClickGesture,longClickGesture,dragGesture,scrollGesture,swipeGesture
        */

        //driver.executeScript("mobile: clickGesture", ImmutableMap.of(
        //        "elementId", ((RemoteWebElement) os).getId()
        //        ));
        clickGesture(driver,os);
    }
    @Test
    public void testClickGestureCoordinate(){
        // kordinat vererek tıklama işlemi
        //driver.executeScript("mobile: clickGesture", ImmutableMap.of(
        //        "x",740,
        //        "y",1088
        //   ));
        clickGesture(driver,740,1088);

    }

    public void clickGesture(WebElement element){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

}
