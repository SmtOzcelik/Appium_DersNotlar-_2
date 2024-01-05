package techpro.day08_Practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techpro.basestest.TelefonBaseTest;

public class P05_Telefon_LongClickGesture extends TelefonBaseTest {

    /*
    Uygulama: Telefon
        1. Telefon uygulamasına gir
        2. +90 545 657 4043 numarasını ara
        3. Mesajda, Arama başarısız oldu. metnini doğrula
        4. Tamam butonuna bas
     */

    @Test
    public void testTelefon() throws InterruptedException {
        By keyPad=AppiumBy.accessibilityId("key pad");
        By bir=AppiumBy.accessibilityId("1,");
        By iki=AppiumBy.accessibilityId("2,ABC");
        By uc=AppiumBy.accessibilityId("3,DEF");
        By dort=AppiumBy.accessibilityId("4,GHI");
        By bes=AppiumBy.accessibilityId("5,JKL");
        By alti=AppiumBy.accessibilityId("6,MNO");
        By yedi=AppiumBy.accessibilityId("7,PQRS");
        By sekiz=AppiumBy.accessibilityId("8,TUV");
        By dokuz=AppiumBy.accessibilityId("9,WXYZ");
        By sifir=AppiumBy.accessibilityId("0");
        By ara=AppiumBy.accessibilityId("dial");

        //numara klavye aç
        clickGesture(driver,driver.findElement(keyPad));
        // + işaretini yap
        longClickGesture(driver,driver.findElement(sifir),1200);
        //numarayı gir
        clickGesture(driver,driver.findElement(dokuz));
        clickGesture(driver,driver.findElement(sifir));
        clickGesture(driver,driver.findElement(bes));
        clickGesture(driver,driver.findElement(dort));
        clickGesture(driver,driver.findElement(bes));
        clickGesture(driver,driver.findElement(alti));
        clickGesture(driver,driver.findElement(bes));
        clickGesture(driver,driver.findElement(yedi));
        clickGesture(driver,driver.findElement(dort));
        clickGesture(driver,driver.findElement(sifir));
        clickGesture(driver,driver.findElement(dort));
        clickGesture(driver,driver.findElement(uc));

        clickGesture(driver,driver.findElement(ara));
        Thread.sleep(2000);

    }
}
