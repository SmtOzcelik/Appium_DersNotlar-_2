package techpro.day03;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techpro.basestest.HesapMasinesiBaseTest;

import java.time.Duration;

public class Odev_HesapMakinesi_Excercise extends HesapMasinesiBaseTest {

    @Test
    public void testToplama(){
        driver.findElement(num8).click();
        driver.findElement(topla).click();
        driver.findElement(num9).click();
        String first=driver.findElement(resultContain).getText();
        System.out.println("first = " + first);
        driver.findElement(eq).click();
        String finall=driver.findElement(resultFinal).getText();
        System.out.println("finall = " + finall);
        Assert.assertEquals(first,finall);

    }

    @Test
    public void testCikarma(){
        driver.findElement(num8).click();
        driver.findElement(cikar).click();
        driver.findElement(num9).click();
        String first=driver.findElement(resultContain).getText();
        driver.findElement(eq).click();
        String finall=driver.findElement(resultFinal).getText();

        Assert.assertEquals(first,finall);

    }
}
