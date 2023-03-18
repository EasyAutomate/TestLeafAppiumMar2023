package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidFirstCodeToIdentifyCorrectAppPackageAndAppActivity {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        dc.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        dc.setCapability("deviceName", "my android emulator device");
        dc.setCapability("noReset", true);
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Thread.sleep(10000);
        driver.quit();
    }

}
