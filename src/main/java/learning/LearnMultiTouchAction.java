package learning;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LearnMultiTouchAction {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("appium:app", System.getProperty("user.dir") + "/apks/MultiTouch Tester_v1.2.apk");
        dc.setCapability("appium:deviceName", "my emulator");
        dc.setCapability("noReset", true);
        // dc.setCapability("platformName", "Android");
        // AppiumDriver driver = new AppiumDriver(new
        // URL("http://0.0.0.0:4723/wd/hub"),dc);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        Thread.sleep(3000);
        int maxX = driver.manage().window().getSize().getWidth();
        int maxY = driver.manage().window().getSize().getHeight();
        // Swipe Up
        int startX = (int) (maxX * 0.5);
        int startY = (int) (maxY * 0.8);
        int endX = (int) (maxX * 0.5);
        int endY = (int) (maxY * 0.2);

        new MultiTouchAction(driver)
                .add(new TouchAction<>(driver).press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                        .moveTo(PointOption.point(endX, endY))
                        .release())
                .add(new TouchAction<>(driver).press(PointOption.point(endX, endY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                        .moveTo(PointOption.point(startX, startY))
                        .release()).perform();
        driver.quit();

    }
}