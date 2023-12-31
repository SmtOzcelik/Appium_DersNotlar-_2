package techpro.day02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C03_Locators extends ApiDemosBaseTest {
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {

        //1-accessbilityId
        WebElement element=driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility ID: "+element.getText());

        //2-id
        //Burda sayfadaki tüm sekmelerin id si ayın olduğu icin list atım indexs kullanacağız
        element=driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("ID : "+element.getText());

        //3-className
        element=driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("ClassName : "+element.getText()); // className de başlıktan başladığı için index 2 yaptık

        //4-andoidUIAutomator
        //burda sadece android için kullanılan locate yöntemi new UiSelctor. dan sonra unique olacağını attribute ve value kulan
        //genelde text tercih edilir attribute text ve içine string olarak value yaz \\ kullan yoksa hata veriyor
        element=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("Android UI Automator : "+element.getText());

        //5-xpath          //classNameValue[@atribute=\"Value\"]" şeklinde kullanılır text de () yok
        element=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Accessibility\"]"));
        System.out.println("xPath : "+element.getText());
    }
}
