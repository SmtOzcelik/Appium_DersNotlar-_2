package techpro.day02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Odev_Locate_Sekilleri_attributeDogrulama {
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        String appPath = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";
        UiAutomator2Options options = new UiAutomator2Options() // platformName ve automationName defealt olarak tanımlı
                .setApp(appPath);
        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);
    /*
    Media Altındaki
    1-AudioFx  -> className ile görünüyor(displeyed)
    2-MediaPlayer -> UiAutomator ile ulaşilabiliyor
    3-VideView -> xpath ile seçilebemez checkable is false
    locate al doğrula
     */
        //önce Media dan içeri girelim
        driver.findElement(AppiumBy.accessibilityId("Media")).click();

        //1
        String audioFx=driver.findElements(AppiumBy.className("android.widget.TextView")).get(1).getAttribute("displayed");
        Assert.assertEquals(audioFx,"true");
        //2
        String mediaPlayer=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"MediaPlayer\")")).getAttribute("enabled");
        Assert.assertEquals(mediaPlayer,"true");
        //3
        String videView=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"VideoView\"]")).getAttribute("checkable");
        Assert.assertEquals(videView,"false");


    }
}