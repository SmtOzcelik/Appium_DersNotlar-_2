package techpro.day13practice;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techpro.basestest.GeneralStoreBaseTest;

import java.util.List;

public class P08_HibritUygulama_GeneralStore extends GeneralStoreBaseTest {

    /*
    Uygulama: GeneralStore
        1. GeneralStore uygulamasına gir
        2. Menüden Angola seçeneğini seç
        3. Your Name kutusuna Safinaz yaz
        4. Gender bölümünden Female seçeneğini seç
        5. Let’s Shop butonuna tıkla
        6. Ürün listesindeki iki ürünü sepete ekle
        7. Sepete gir
        8. Sepette iki ürün olduğunu doğrula
        9. Ürün fiyatlarını topla
        10. Total Purchase Amount bölümündeki tutarın doğru
        olduğunu doğrula
        11. Send me e-mails.. kutusunu seç
        12. Visit to the website.. butonuna tıkla
     */
    @Test
    public void testGeneralStore() throws InterruptedException {
        //Menü
        WebElement menu=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();

        //ülke seçimi Turkey scroll
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Turkey\"))"));
        scrollToElementText(driver,"Aruba");

        WebElement angola=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Brazil\"]"));
        angola.click();

        WebElement nameBox=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        nameBox.sendKeys("Safinaz");

        WebElement female=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        female.click();

        WebElement button=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
        button.click();

        // 2 tane ye tıklayacağım ve ekranda zaten görünen 2 tane var list e al ayrı ayrı tikla
        //list olunca get(0).click() ve get(1).click() yap ama normal olursa tek tek aşagıdaki gibi

        //aşağıda bulunan ürünleri seçelim
        scrollToElementText(driver,"Converse All Star");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();
        scrollToElementText(driver,"LeBron Soldier 12 ");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();

        WebElement cart= driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();

        //Sepet de 2 ürün olduğunu doğrulayalım
        List<WebElement> products=driver.findElements(AppiumBy.className("android.widget.ImageView"));
        Assert.assertEquals(products.size(),2);

        //CheckBox
        WebElement checkBox=driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        checkBox.click();

        //visit
        WebElement visitButton= driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
        visitButton.click();
        bekle(4);
        //Hibrit uygulama
//        Set<String>list=driver.getContextHandles(); // kodu aldıktan sonra burayı sil
//        for (String each:list){
//            System.out.println(each);
//        }
        driver.context("WEBVIEW_com.androidsample.generalstore");

        // artık web ortamındayız locate de AppiumBy yok By var
        //arama motoru
        driver.findElement(By.name("q")).sendKeys("Temel Reis", Keys.ENTER);

        //Native uygulamaya dönelim
        driver.pressKey(new KeyEvent(AndroidKey.BACK));//geri tuşuna bastık
        driver.context("NATIVE_APP");//driver ı da Native geçirdik

        //Başlık Doğrulama
        String baslik=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(baslik,"General Store");
    }
}
