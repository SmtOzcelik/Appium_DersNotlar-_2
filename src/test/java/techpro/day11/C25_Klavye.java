package techpro.day11;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

public class C25_Klavye extends ApiDemosBaseTest {
    @Test
    public void testApiDemos() throws InterruptedException {
        By preferences= AppiumBy.accessibilityId("Preference");
        By dependencies=AppiumBy.accessibilityId("3. Preference dependencies");
        By checBox= By.id("android:id/checkbox");
        By wifiSettings=AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
        By textBox=AppiumBy.className("android.widget.EditText");

        driver.findElement(preferences).click();
        driver.findElement(dependencies).click();

        //checkBox tıkla
        if (!driver.findElement(checBox).isSelected()){//secili değilse seç
            driver.findElement(checBox).click();
        }
        driver.findElement(wifiSettings).click();

        //Klavye gözüküyor mu
        System.out.println(driver.isKeyboardShown());//false

        driver.findElement(textBox).click();

        //Klavye gözüküyor mu
        System.out.println(driver.isKeyboardShown());//true
        bekle(2);

        //Klavyeyi kapat
        driver.hideKeyboard();
        bekle(2);

        //Klavye gözüküyor mu
        System.out.println(driver.isKeyboardShown());//false

    }

    @Test
    public void testPressKey() throws InterruptedException {
        By preferences= AppiumBy.accessibilityId("Preference");
        By dependencies=AppiumBy.accessibilityId("3. Preference dependencies");
        By checBox= By.id("android:id/checkbox");
        By wifiSettings=AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")");
        By textBox=AppiumBy.className("android.widget.EditText");

        driver.findElement(preferences).click();
        driver.findElement(dependencies).click();

        //checkBox tıkla
        if (!driver.findElement(checBox).isSelected()){//secili değilse seç
            driver.findElement(checBox).click();
        }
        driver.findElement(wifiSettings).click();
        driver.findElement(textBox).click();

        //Her harfide tanımlayıp basabiliriz
        KeyEvent aHarfi=new KeyEvent(AndroidKey.A);
        driver.pressKey(aHarfi);

//        //Arka arkaya basmak için tanımlamadan direk ÇALIŞMADI ÖDEV BAK
//        driver.pressKey(new KeyEvent(AndroidKey.B).withKey(AndroidKey.C).withKey(AndroidKey.L));
//        bekle(2);

        KeyEvent back=new KeyEvent(AndroidKey.BACK);
        driver.pressKey(back);
        bekle(2);

        KeyEvent appSwitch=new KeyEvent(AndroidKey.APP_SWITCH);
        driver.pressKey(appSwitch);
        bekle(2);

        KeyEvent home=new KeyEvent(AndroidKey.HOME);
        driver.pressKey(home);
        bekle(2);
        
    }
}
