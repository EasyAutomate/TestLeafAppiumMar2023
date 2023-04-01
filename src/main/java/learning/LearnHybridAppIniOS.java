package learning;

import org.testng.annotations.Test;
import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnHybridAppIniOS extends GenericWrappers {
    @Test
    public void runCode() {
        launchIosApp("iPhone 14 Pro", "B88361EF-6968-4345-AB1B-19C8A814BB67", "", "", "/apks/UICatalog.zip");
        swipeUpInApp();
        click(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Web View"));
        printContext();
        sleep(5000);
        printContext();
        switchWebView();
        click(getWebElement(Locators.XPATH.asString(), "//a[@id=\"globalnav-menubutton-link-search\"]"));
        enterValue(getWebElement(Locators.XPATH.asString(), "//input[@name='search']"), "Macbook Pro");
        sleep(5000);
        closeApp();
    }
}