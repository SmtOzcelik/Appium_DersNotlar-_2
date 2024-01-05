package techpro.day05_Practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techpro.basestest.MyDemoBaseTest;

import java.util.List;

public class Practice04_MyDemoApp_ColorTest extends MyDemoBaseTest {
    /*
    Uygulama: MyDemoApp
        1. MyDemoApp uygulamasına gir
        2. Menüyü aç
        3. Login ol (bob@example.com, 10203040)
        4. Login butonuna tıkla
        5. İlk ürünü seç
        6. Renk olarak mavi seç
        7. Add To Cart butonuna tıkla
        8. Renk olarak kırmızı seç
        9. Add To Cart butonuna tıkla
        10. Sepete git
        11. Listede iki ürün olduğunu doğrla
        12. Listedeki ürünlerin mavi ve kırmızı olduğunu doğrula
     */

    @Test
    public void testColor() {
        WebElement menu=driver.findElement(AppiumBy.accessibilityId("open menu"));
        menu.click();

        WebElement login=driver.findElement(AppiumBy.accessibilityId("menu item log in"));
        login.click();

        WebElement username=driver.findElement(AppiumBy.accessibilityId("Username input field"));
        username.click();
        username.sendKeys("bob@example.com");

        WebElement password=driver.findElement(AppiumBy.accessibilityId("Password input field"));
        password.sendKeys("10203040");
        driver.hideKeyboard();

        WebElement loginButton=driver.findElement(AppiumBy.accessibilityId("Login button"));
        loginButton.click();

        WebElement productTitle=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        productTitle.click();

        //WebElement blue=driver.findElement(AppiumBy.accessibilityId("blue circle"));
        //Sayfa değiştiginde bayatlamaması için by ile yapmalıyım
        By blue=AppiumBy.accessibilityId("blue circle");
        driver.findElement(blue).click();

        WebElement addToCart=driver.findElement(AppiumBy.accessibilityId("Add To Cart button"));
        addToCart.click();

        //WebElement red=driver.findElement(AppiumBy.accessibilityId("red circle"));
        By red=AppiumBy.accessibilityId("red circle");
        driver.findElement(red).click();

        addToCart.click();

        WebElement cart=driver.findElement(AppiumBy.accessibilityId("cart badge"));
        cart.click();

        List<WebElement> cartList=driver.findElements(AppiumBy.accessibilityId("product row"));
        Assert.assertEquals(cartList.size(),2);

        //Sayfada olup olmadığını doğruladık
        Assert.assertTrue(driver.findElement(blue).isDisplayed());
        Assert.assertTrue(driver.findElement(red).isDisplayed());

        //Burda ise ilk seçilen ürün blue 2. ürün red olduğunu doğruladık
        WebElement blue2=driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"product row\"]//android.view.ViewGroup[@content-desc=\"blue circle\"]"));
        Assert.assertTrue(blue2.isDisplayed());
        WebElement red2=driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"product row\"]//android.view.ViewGroup[@content-desc=\"red circle\"]"));
        Assert.assertTrue(red2.isDisplayed());



    }
}
