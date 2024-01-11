package techpro.day13practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techpro.basestest.ChromeBrowserBaseTest;

import java.time.Duration;

public class P09_MobilWebUygulama_KitapYurdu extends ChromeBrowserBaseTest {
    @Test
    public void testName() {
        //url
        driver.get("https://www.kitapyurdu.com/");

        //çerez Explicit Wait kullandım obje kullanarak
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10)); // 10 saniyeye kadar bekleyecek
//        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookiescript_accept")));
        WebElement cookiesButton=driver.findElement(By.id("cookiescript_accept"));
        cookiesButton.click();

        //giriş
        driver.findElement(By.xpath("//i[@class=\"main-sprite icon-header-account-nologin d-block\"]")).click();
        //Üye ol
        driver.findElement(By.partialLinkText("Ücretsiz Üye Ol")).click();

        // Ad kutusu
        driver.findElement(By.id("firstname")).sendKeys("Ayşe");
        //Soyadı kutusu
        driver.findElement(By.id("lastname")).sendKeys("Ay");
        //Email Kutusu
        driver.findElement(By.id("email")).sendKeys("ayse12e34@gmail.com");
        //Sifre Kutusu
        driver.findElement(By.id("password")).sendKeys("12345678");
        //Şifre kutusu tekrarı
        driver.findElement(By.id("confirm")).sendKeys("12345678");
        //check button
        driver.findElement(By.id("form-check-input")).click();
        //üye ol button
        driver.findElement(By.xpath("//button[text()=\"Üye Ol\"]")).click();

        //üye olunduğunun doğrulanması
        WebElement headersText= driver.findElement(By.xpath("//h1[text()=\"Hesabınız Oluşturuldu!\"]"));
        Assert.assertTrue(headersText.isDisplayed());
    }
}
