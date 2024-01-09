package techpro.day11;

import org.testng.annotations.Test;
import techpro.basestest.DeviceBaseTest;

import java.time.Duration;

public class C24_EkranKilidi extends DeviceBaseTest {
    @Test
    public void testLockDevice() throws InterruptedException {
        // 5 sn liğine ekran kilidini kapalı tut
        driver.lockDevice(Duration.ofSeconds(5));
        Thread.sleep(3000);
    }

    @Test
    public void testUnlockDevice() throws InterruptedException {
        // ekran kilidini kapat
        driver.lockDevice();
        Thread.sleep(3000);

        //ekran kilidini aç
        driver.unlockDevice();
        Thread.sleep(3000);
    }

    @Test
    public void testIsDeviceLocked() throws InterruptedException {
        //ekran kilitli mi
        System.out.println(driver.isDeviceLocked());

        // ekranı kilitle
        driver.lockDevice();
        bekle(3);

        //ekran kilitli mi
        System.out.println(driver.isDeviceLocked());
    }
}
