package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class LearnPointerInput {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("app", System.getProperty("user.dir") + "/apks/MultiTouch Tester_v1.2.apk");
        dc.setCapability("deviceName", "my android emulator device");
        dc.setCapability("noReset", true);
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        int maxX = driver.manage().window().getSize().getWidth();
        int maxY = driver.manage().window().getSize().getHeight();

        //Swipe up
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "index finger");
        Sequence swipeUp = new Sequence(finger1, 1);
        swipeUp.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.8)));
        swipeUp.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeUp.addAction(finger1.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.2)));
        swipeUp.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeUp));
        Thread.sleep(2000);

        //Swipe down
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "index finger");
        Sequence swipeDown = new Sequence(finger2, 1);
        swipeDown.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.2)));
        swipeDown.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeDown.addAction(finger2.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int) (maxX * 0.5), (int) (maxY * 0.8)));
        swipeDown.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeDown));
        Thread.sleep(2000);

        //Swipe left
        PointerInput finger3 = new PointerInput(PointerInput.Kind.TOUCH, "index finger");
        Sequence swipeLeft = new Sequence(finger3, 1);
        swipeLeft.addAction(finger3.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.8), (int) (maxY * 0.5)));
        swipeLeft.addAction(finger3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeLeft.addAction(finger3.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int) (maxX * 0.2), (int) (maxY * 0.5)));
        swipeLeft.addAction(finger3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeLeft));
        Thread.sleep(2000);

        //Swipe right
        PointerInput finger4 = new PointerInput(PointerInput.Kind.TOUCH, "index finger");
        Sequence swipeRight = new Sequence(finger4, 1);
        swipeRight.addAction(finger4.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), (int) (maxX * 0.2), (int) (maxY * 0.5)));
        swipeRight.addAction(finger4.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipeRight.addAction(finger4.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), (int) (maxX * 0.8), (int) (maxY * 0.5)));
        swipeRight.addAction(finger4.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipeRight));
        Thread.sleep(2000);
        driver.quit();
    }

}
