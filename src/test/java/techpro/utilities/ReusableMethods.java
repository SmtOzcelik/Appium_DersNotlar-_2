package techpro.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class ReusableMethods {
    //driver classi olmadığı için methodlara parametre olarak ekledik
    //normalde static yaparak çağırırdık burda testBase classlarınıda ReusableMethods a exten yaptık
    //Direk çağırıp kullanabiliyorum. Değişik bir yöntem olarak bulunsun

    public void clickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }
    public void clickGesture(AndroidDriver driver,int x,int y){
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x",x,
                "y",y
        ));
    }

    public void doubleClickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }
    public void doubleClickGesture(AndroidDriver driver,int x,int y){
        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x",x,
                "y",y
        ));
    }
    public void longClickGesture(AndroidDriver driver, WebElement element){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration",1000 //istersek parametre olarak da koyabiliriz
        ));
    }
    public void longClickGesture(AndroidDriver driver, WebElement element,int duration){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration",duration //istersek parametre olarak da koyabiliriz
        ));
    }
    public void longClickGesture(AndroidDriver driver,int x,int y){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x",x,
                "y",y,
                "duration",1000 //istersek parametre olarak da koyabiliriz
        ));
    }
    public void dragGesture(AndroidDriver driver, WebElement element,int endX,int endY){
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY,
                "speed",500   // sürüklenmesini görmek için koyduk
        ));
    }
    public void dragGesture(AndroidDriver driver,int startX,int startY,int endX,int endY){
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX",startX,
                "startY",startY,
                "endX", endX,
                "endY", endY,
                "speed",500   // sürüklenmesini görmek için koyduk
        ));
    }
    public void swipeGesture(AndroidDriver driver,WebElement element,String direction,double percent,int speed){
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,  //sağı görmek için kaydırma sola
                "percent", percent ,  //0-1 arasında olmak zorunda
                "speed",speed
        ));
    }
    public void scrollGesture(AndroidDriver driver,WebElement element,String direction,double percent,int speed){
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,  //yönü belli et
                "percent", percent ,  //0-1 arasında olmak zorunda
                "speed",speed
        ));
    }
    public void pinchOpenGesture(AndroidDriver driver,int left,int top,int width,int heihgt,double percent){
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", left, "top", top, "width", width, "height", heihgt,
                "percent",percent, // 0-1 arası yazılabilir
                "speed",500
        ));
    }

    public void pinchCloseGesture(AndroidDriver driver,int left,int top,int width,int heihgt,double percent){
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", left, "top", top, "width", width, "height", heihgt,
                "percent",percent, // 0-1 arası yazılabilir
                "speed",500
        ));
    }
    public void scrollToElementText(AndroidDriver driver,String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
        //bu method androidUIAutomator her zaman çalışmaz developer kullanmadı ise
    }

    public void bekle(int sn) throws InterruptedException {
        Thread.sleep(sn*1000);

    }



}
