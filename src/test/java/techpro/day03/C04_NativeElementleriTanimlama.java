package techpro.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C04_NativeElementleriTanimlama extends ApiDemosBaseTest {

    @Test
    public void testElement() throws MalformedURLException {

        //Locateleri arka arkaya sıralayıp aşağıda ayrı ayrı tıklarsak hata verir çünkü 2.ve 3. bulamaz
        WebElement app=driver.findElement(AppiumBy.accessibilityId("App"));
        app.click();
        WebElement alarm=driver.findElement(AppiumBy.accessibilityId("Alarm"));
        alarm.click();
        WebElement alarmController=driver.findElement(AppiumBy.accessibilityId("Alarm Controller"));
        alarmController.click();
    }
    @Test
    public void testBy() throws MalformedURLException {

        By app=AppiumBy.accessibilityId("App");
        By alarm=AppiumBy.accessibilityId("Alarm");
        By alarmController=AppiumBy.accessibilityId("Alarm Controller");
        // Bu şekilde hata vermez findElement yok arama yok sadece tanımlama var o yüzden bunu tercih et
        //Aynı class içinde kullanırsak mantıklı fakat pom olursa @AndroidFindBy kullan
        //@FindBy webelementler için geçerli accesibilty ve uiautomator yok o yüzden @AndroidFindBy kullanılır

        driver.findElement(app).click();
        driver.findElement(alarm).click();
        driver.findElement(alarmController).click();

    }
}
