package techpro.day12;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

import java.util.Set;

public class C26_HibritUygulama extends ApiDemosBaseTest {
    @Test
    public void testTestHibrit() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        bekle(1); //Sayfanın yüklenmesi için bekleme süresi her zaman ihtiyaç olmayabilir

        Set<String> contexHandles=driver.getContextHandles();
        for (String contexName : contexHandles){
            System.out.println(contexName);
        }
//        NATIVE_APP
//        WEBVIEW_io.appium.android.apis  yazdırdık geldi
        // Eğer hata mesajı alırsak chrome driver uygun değildir derse notion a yapılmasını gereken kod koydum.

        //web geçiş yaptık
        driver.context("WEBVIEW_io.appium.android.apis");

        //web de locate aldık ve yazdırdık
        //web e geçince AppiumBy kullanılmıyor ve locate alırken inspector terçih edilmez
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        //geri tuşuna bastık
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        //app ekranını gördük ve driver i taşıyalım
        driver.context("NATIVE_APP");

        //app de herhangi bir yere tıklattık ki geçtiğini görelim
        driver.findElement(AppiumBy.accessibilityId("Visibility")).click();

    }
}
