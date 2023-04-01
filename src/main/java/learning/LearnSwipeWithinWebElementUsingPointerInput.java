package learning;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class LearnSwipeWithinWebElementUsingPointerInput {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("appium:deviceName", "my emulator");
        dc.setCapability("appPackage", "com.android.vending");
        dc.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        dc.setCapability("noReset", true);
        // dc.setCapability("platformName", "Android");
        // AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),
        // dc);
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement ele = driver.findElement(
                By.xpath("//android.view.View[@content-desc='Ads']/following-sibling::android.view.View"));
        String bounds = ele.getAttribute("bounds");
        String[] split = bounds.replace("][", "!").replace("[", "").replace("]", "").split("!");
        String[] eleStart = split[0].split(",");
        String[] eleEnd = split[1].split(",");
        int startX = (int) ((Integer.parseInt(eleEnd[0]) - Integer.parseInt(eleStart[0])) * 0.8)
                + Integer.parseInt(eleStart[0]);
        int startY = (int) ((Integer.parseInt(eleEnd[1]) - Integer.parseInt(eleStart[1])) * 0.5)
                + Integer.parseInt(eleStart[1]);
        int endX = (int) ((Integer.parseInt(eleEnd[0]) - Integer.parseInt(eleStart[0])) * 0.2)
                + Integer.parseInt(eleStart[0]);
        int endY = (int) ((Integer.parseInt(eleEnd[1]) - Integer.parseInt(eleStart[1])) * 0.5)
                + Integer.parseInt(eleStart[1]);
        swipe(startX, startY, endX, endY, driver);
        Thread.sleep(2000);
        swipe(startX, startY, endX, endY, driver);
        Thread.sleep(2000);
        swipe(startX, startY, endX, endY, driver);
        Thread.sleep(2000);
        driver.quit();
    }

    public static void swipe(int startX, int startY, int endX, int endY, AndroidDriver driver) {
        PointerInput finger1 = new PointerInput(Kind.TOUCH, "finger 1");
        Sequence seq = new Sequence(finger1, 1);
        seq.addAction(finger1.createPointerMove(Duration.ZERO, Origin.viewport(), startX, startY));
        seq.addAction(finger1.createPointerDown(MouseButton.LEFT.asArg()));
        seq.addAction(finger1.createPointerMove(Duration.ofSeconds(2), Origin.viewport(), endX, endY));
        seq.addAction(finger1.createPointerUp(MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(seq));
    }
}
