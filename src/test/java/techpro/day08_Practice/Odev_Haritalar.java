package techpro.day08_Practice;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techpro.basestest.HaritalarBaseTest;

public class Odev_Haritalar extends HaritalarBaseTest {
    @Test
    public void testHaritalar() throws InterruptedException {

        /*
        Uygulama: Haritalar
        1. Haritalar uygulamasına gir
        2. Harita türü olarak Uydu seçeneğini seç
        3. Arama motorunda Taj Mahal kelimelerini arat
        4. Haritada Taj Mahal bölgesine zoom in ve zoom out işlemlerini yap
         */

        WebElement layersButton=driver.findElement(AppiumBy.accessibilityId("Layers"));
        clickGesture(driver,layersButton);

        WebElement uydu=driver.findElement(AppiumBy.accessibilityId("Satellite"));
        clickGesture(driver,uydu);

        WebElement closeMenu=driver.findElement(AppiumBy.accessibilityId("Close menu"));
        clickGesture(driver,closeMenu);

        WebElement searchBox= driver.findElement(AppiumBy.accessibilityId("Search here"));
        clickGesture(driver,searchBox);

        WebElement searchData=driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/search_omnibox_edit_text"));

        searchData.sendKeys("Taj Mahal");

        KeyEvent enter=new KeyEvent(AndroidKey.ENTER);
        driver.pressKey(enter);

        Thread.sleep(5000);//sayfanın yüklenmesi için

        pinchOpenGesture(driver,300,800,1000,400,0.9); // yakınlaştır

        Thread.sleep(2000);

        pinchCloseGesture(driver,300,800,1000,400,0.9);//uzaklaş








    }
}
