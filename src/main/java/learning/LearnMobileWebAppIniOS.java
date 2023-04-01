package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnMobileWebAppIniOS extends GenericWrappers {
    @Test
    public void runCode() {
        launchSafariBrowser("iPhone 11 real device", "http://www.google.com", "00008030-000A708E01F0C02E", "");
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Lokesh Kumar Thyagarajan");
        sleep(5000);
//        click(getWebElement(Locators.NAME.asString(), "q"));
//        clickWebElementUsingCoOrdinates(getWebElement(Locators.NAME.asString(), "q"));
        clickWebElementUsingCoOrdinatesWithAdditionalValues(getWebElement(Locators.NAME.asString(), "q"), 0, 120);
//        System.out.println(driver.getPageSource());
//        clickGivenKeyboardButtonInIosByAccessibilityId("Go");
        switchNativeView();
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Go"));
        switchWebView();

    }
}