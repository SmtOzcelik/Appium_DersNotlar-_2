package techpro.day04;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;
import techpro.basestest.GeneralStoreBaseTest;

import java.util.List;

public class Practice02_GeneralStore extends GeneralStoreBaseTest {
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
       WebElement menu=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
       menu.click();

       WebElement angola=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Angola\"]"));
       angola.click();

       WebElement nameBox=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
       nameBox.sendKeys("Safinaz");

       WebElement female=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
       female.click();

       WebElement button=driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
       button.click();

        // 2 tane ye tıklayacağım ve ekranda zaten görünen 2 tane var list e al ayrı ayrı tikla
        //list olunca get(0).click() ve get(1).click() yap ama normal olursa tek tek aşagıdaki gibi
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();

        WebElement cart= driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
        cart.click();

        //Sepet de 2 ürün olduğunu doğrulayalım
        List<WebElement> products=driver.findElements(AppiumBy.className("android.widget.ImageView"));
        Assert.assertEquals(products.size(),2);

        //Ürün fiyatlarını topla ve doğrula
        double total=0;
        for (int i = 0; i < products.size(); i++) {
            String priceText=products.get(i).getText(); //$160.97
            double price=Double.parseDouble(priceText.substring(1));//160.97
            total+=price;
        }
        double totalAmount=Double.parseDouble(driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
        Assert.assertEquals(total,totalAmount);
    }
}
