package techpro.day04;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

public class Practice01_ApiDemos extends ApiDemosBaseTest {
    /*
    Uygulama: ApiDemos
1. API Demos uygulamasına gir
2. Preference seçeneğine tıkla
3. 3. Preference dependencies seçeneğine tıkla
4. WiFi kontrol kutusunu seç
5. WiFi settings seçeneğine tıkla
6. Açılan ekrandaki başlığın WiFi settings olduğunu
doğrula
7. Metin kutusuna adını yaz
8. Tamam butonuna tıkla
     */
    @Test
    public void testApiDemos(){
        By preferences= AppiumBy.accessibilityId("Preference");
        By dependencies=AppiumBy.accessibilityId("3. Preference dependencies");
        By checBox= By.id("android:id/checkbox");
        By wifiSettings=AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
        By title=By.id("android:id/alertTitle");
        By textBox=AppiumBy.className("android.widget.EditText");
        By okButton=By.id("android:id/button1");

        driver.findElement(preferences).click();
        driver.findElement(dependencies).click();
        //Wifi setting ulaşılamadığını doğrula
        Assert.assertEquals(driver.findElement(wifiSettings).getAttribute("enabled"),"false");
        //checkBox tıkla
        if (!driver.findElement(checBox).isSelected()){//secili değilse seç
            driver.findElement(checBox).click();
        }
        //Wifi setting ulaşıldığını doğrula
        Assert.assertEquals(driver.findElement(wifiSettings).getAttribute("enabled"),"true");
        driver.findElement(wifiSettings).click();
        //title WiFi settings olduğunu doğrula
        Assert.assertEquals(driver.findElement(title).getText(),"WiFi settings");
        //metin kutusuna samet yaz
        driver.findElement(textBox).click();
        driver.findElement(textBox).sendKeys("samet");
        driver.findElement(okButton).click();




    }
}
