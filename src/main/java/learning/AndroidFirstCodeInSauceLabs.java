package learning;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidFirstCodeInSauceLabs extends GenericWrappers {

    @Test
    public void runCode() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=leaforg.apk"); // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Google Pixel 3 XL GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0-beta56");
        sauceOptions.setCapability("build", "<your build id>");
        sauceOptions.setCapability("name", "<your test name>");
        caps.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://oauth-appiummar2023-ff8b7:cfbd906b-fe3a-4ae9-b1b8-c82f97466f75@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);
        driver.findElement(By.className("android.widget.EditText")).sendKeys("rajkumar@testleaf.com");
        driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("Leaf@123");
        driver.findElement(By.className("android.widget.Button")).click();
        driver.quit();
    }
}