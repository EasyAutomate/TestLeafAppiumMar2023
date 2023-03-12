package learning;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidFirstScriptUsingApp {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("app",System.getProperty("user.dir")+"/apks/leaforg.apk");
        dc.setCapability("deviceName","my android emulator device");
        AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.className("android.widget.EditText")).sendKeys("rajkumar@testleaf.com");
        driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("Leaf@123");
        driver.findElement(By.className("android.widget.Button")).click();
        Thread.sleep(5000);
        driver.quit();
    }

}
