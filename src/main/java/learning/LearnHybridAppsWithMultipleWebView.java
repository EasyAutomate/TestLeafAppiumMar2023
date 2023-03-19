package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LearnHybridAppsWithMultipleWebView extends GenericWrappers {

    @Test
    public void runCode() {
        launchAndroidApp("my device", "", "", "", "/apks/TheApp-v1.10.0.apk");
        click(getWebElement(Locators.XPATH.asString(), "//*[@text='Dual Webview Demo']"));
        sleep(2000);
        System.out.println(getText(getWebElement(Locators.XPATH.asString(), "(//android.view.View)[1]")));
        System.out.println(getText(getWebElement(Locators.XPATH.asString(), "(//android.view.View)[2]")));
        switchContext("WEBVIEW_io.cloudgrey.the_app");
        System.out.println(getText(getWebElement(Locators.XPATH.asString(), "//h2")));
        switchToLastWindow();
        System.out.println(getText(getWebElement(Locators.XPATH.asString(), "//h2")));
    }
}