package techpro.day11;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import techpro.basestest.ApiDemosBaseTest;

import java.io.File;
import java.time.Duration;

public class C23_UygulamaEtkileşimleri extends ApiDemosBaseTest {
    @Test
    public void testTerminateApp() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(2000);

        // Bu komutla uygumayı kapattık
        // adb shell dumpsys window | find "mCurrentFocus" terminal e yazarak aldık bundleld yi
        driver.terminateApp("io.appium.android.apis");
        Thread.sleep(2000);

    }

    @Test
    public void testActivateApp() throws InterruptedException {
        //Başka bir uyguma da işlem yaparken başka bir uygulmayı açma

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(2000);

        // Bu kodla başka bir uygulamayı açtık
        driver.activateApp("com.google.android.calculator");
        Thread.sleep(2000);

        // Tekrar apiDemos aç
        driver.activateApp("io.appium.android.apis");

    }

    @Test
    public void testRunAppInBackground() throws InterruptedException {
        // uygulamayı arka planda çalıştırır

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        Thread.sleep(2000);

        // 5 sn boyunca arka plana at sonra devam et
        driver.runAppInBackground(Duration.ofSeconds(5));
        Thread.sleep(3000);
    }

    @Test
    public void testInstallApp() {
        // path ini verdiğimiz uygulayı yükler
        String appPath = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
        driver.installApp(appPath);
    }

    @Test
    public void testIsInstallApp() {
        // isteğimiz uygulama yüklü mü diye kontrol etme
        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn")); //true
    }

    @Test
    public void testQueryAppState() throws InterruptedException {
        // uygulamanın hangi planda çalışıyor
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        Thread.sleep(2000);

        driver.terminateApp("io.appium.android.apis");//kapattık

        System.out.println(driver.queryAppState("io.appium.android.apis"));
        Thread.sleep(2000);

        driver.activateApp("io.appium.android.apis");//açtık
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        Thread.sleep(2000);

        driver.activateApp("com.google.android.calculator");//açtık
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        Thread.sleep(2000);

//        RUNNING_IN_FOREGROUND
//        NOT_RUNNING
//        NOT_RUNNING
//        RUNNING_IN_BACKGROUND
    }
}
