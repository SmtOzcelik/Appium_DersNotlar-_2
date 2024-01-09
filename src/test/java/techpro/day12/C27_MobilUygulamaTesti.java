package techpro.day12;

import org.testng.annotations.Test;
import techpro.basestest.ChromeBrowserBaseTest;

public class C27_MobilUygulamaTesti extends ChromeBrowserBaseTest {
    @Test
    public void testBrowser() {
        driver.get("https://www.amazon.com");
    }
}
