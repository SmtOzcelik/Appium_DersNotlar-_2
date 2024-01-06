package techpro.day08_Practice;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techpro.basestest.KitapYurduBaseTest;

import java.util.List;

public class P06_KitapYurdu_ScrollSwipeGesture extends KitapYurduBaseTest {

    @Test
    public void testKitapYurdu() {
        /*
        Uygulama: Kitap Yurdu
        1. Kitap Yurdu uygulamasına gir
        2. İlgi Görenler bölümündeki 5. kitaba tıkla
        3. Kitap adı, Yazar adı ve Yayınevi adı bilgilerini
        yazdır
        4. Künye başlıklarını ve bilgilerini yazdır
         */
        WebElement swipeElement=driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/recyclerViewList"));

        swipeGesture(driver,swipeElement,"left",0.9,1500); //percent ayarlama kitap iyi konumlandır locate kolay olsun

        // 5. kitabi seç dediği icin gidip bakıp kitabın şahsi locate almayacağız ileride locate değişebilir
        // tavsiye edilmeyen fakat burda asil yapılmasi gereken indeks ile 5. kitap olarak alacaksın
        driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/mainLayout")).get(1).click();
        //2. indeksi aldık çünkü swip yaptırdım ekran durdu istediğim kitap 2. de durdu ona göre locate aldım
        // daha az swip yapsaydım belki 3. de olacaktı ve ya daha çok swipe yapsaydım belki ekranda bile bulamazdım

        String kitapAdi=driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewProductName")).getText();
        System.out.println("kitapAdi = " + kitapAdi);

        String yazarAdi=driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAuthor")).getText();
        System.out.println("yazarAdi = " + yazarAdi);

        String yayinEviAdi=driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewPublisher")).getText();
        System.out.println("yayinEviAdi = " + yayinEviAdi);
        System.out.println("-----------------------------------");

        // kunye aşağıda olduğu için scroll yapacağız aşagıdaki her zaman çalışmayabiliyor devoloper kullanmadığı için
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Künye\"))"));

        //künye başlığına kadar scroll yapacağız o yüzden en geniş kapsayan ve scroll özelliği true olan element seç
        WebElement scrollElement=driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/productDetailScrollView"));
        scrollGesture(driver,scrollElement,"down",2.3,1500);

        // künye başlıklarını yazdırma, tek tek ayrı ayrı locate alabilirim fakat böyle durumlarda hepsi aynı locate içinde
        // child oldukları için, child in birincde locate alınca hepsi gözükecek 7 tane mesala o lacate list yap
        // fakat şunu yapma parentdan alıp aşağı ineyip olmaz

        List<WebElement>kunyeBasliklari=driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeTitle"));
        List<WebElement>kunyeName=driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeName"));

        for (int i = 0; i < kunyeBasliklari.size(); i++) {
            System.out.println(kunyeBasliklari.get(i).getText()+kunyeName.get(i).getText());
        }
    }
}
