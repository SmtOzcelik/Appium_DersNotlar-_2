package techpro.utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

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
    public void longClickGesture(AndroidDriver driver,int x,int y){
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x",x,
                "y",y,
                "duration",1000 //istersek parametre olarak da koyabiliriz
        ));
    }

}
