package techpro.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class C02_SetupDriver {
    //bu class setAvd icin dir. jenkıns de koşmak için oluşturulur
    @Test
    public void testUiAutomator2Options() throws MalformedURLException {
        // Bu yöntem sayesinde bu path bütün işletim sistemlerine uydu
        String appPath=System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";
        UiAutomator2Options options = new UiAutomator2Options() // platformName ve automationName defealt olarak tanımlı
                .setUdid("emulator-5554") // birden fazla cihaz var ise gerekli
                .setApp(appPath)
                .setAvd("pixel_q")  //jenkinsde çalışması icin ve bu değer yeri slaytda anlatıyor
                .setAvdLaunchTimeout(Duration.ofMinutes(5))//uzun sürerse kapanmasındiye 5 dk yaptık
                ;

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver=new AndroidDriver(url,options);
    }
}
