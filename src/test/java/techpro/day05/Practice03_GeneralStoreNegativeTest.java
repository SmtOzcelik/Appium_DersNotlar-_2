package techpro.day05;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import techpro.basestest.GeneralStoreBaseTest;

public class Practice03_GeneralStoreNegativeTest extends GeneralStoreBaseTest {

    @Test
    public void testGeneralStoreNegativeTest() {
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage=driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");

        Assert.assertEquals(toastMessage,"Please enter your name");
    }
}
