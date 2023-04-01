package wrappers;

import io.appium.java_client.remote.SupportsContextSwitching;

public class IosWebWrappers extends IosNativeWrappers {

    public boolean launchSafariBrowser(String deviceName, String URL, String udid, String platformVersion) {
        return launchBrowser("iOS", "Safari", deviceName, URL, udid, "", "", "", "", platformVersion);
    }

    public boolean launchSafariBrowserInParallel(String deviceName, String URL, String udid, String wdaLocalPort,
                                                 String webkitDebugProxyPort, String platformVersion) {
        return launchBrowser("iOS", "Safari", deviceName, URL, udid, "", wdaLocalPort, "", webkitDebugProxyPort, platformVersion);
    }

    public boolean deleteSafariCookies() {
        stopRunningApp("com.apple.Preferences");
        switchToAnotherApp("com.apple.Preferences");
        switchNativeView();
        swipeDownInApp();
        enterValue(getWebElement(Locators.XPATH.toString(), "//*[@label='Search']"), "Safari");
        try {
            click(getWebElement(Locators.XPATH.toString(), "//XCUIElementTypeCell[2]//*[@name='Safari']"));
        } catch (Exception e) {
            click(getWebElement(Locators.XPATH.toString(), "//*[@label='Safari']"));
        }
        sleep(1000);
        swipeUpInAppUntilElementIsVisible(Locators.XPATH.toString(),
                "//*[@value='Clear History and Website Data' and @visible='true']");
        click(getWebElement(Locators.XPATH.toString(),
                "//*[@value='Clear History and Website Data' and @visible='true']"));
        click(getWebElement(Locators.XPATH.toString(), "//*[@label='Clear' or @label='Clear History and Data']"));
        stopRunningApp("com.apple.Preferences");
        switchToAnotherApp("com.apple.mobilesafari");
        switchWebView();
        return true;
    }

    public void clickGivenKeyboardButtonInIosByName(String name) {
        boolean isNative = ((SupportsContextSwitching) driver).getContext().equalsIgnoreCase("NATIVE_APP");
        String context = ((SupportsContextSwitching) driver).getContext();
        if (!isNative) {
            switchNativeView();
        }
        if (isKeyboardShown()) {
            click(getWebElement(Locators.NAME.toString(), name));
        }
        if (!isNative) {
            switchContext(context);
        }
    }

    public void clickGivenKeyboardButtonInIosByAccessibilityId(String accessId) {
        boolean isNative = ((SupportsContextSwitching) driver).getContext().equalsIgnoreCase("NATIVE_APP");
        System.out.println(isNative);
        String context = ((SupportsContextSwitching) driver).getContext();
        if (!isNative) {
            switchNativeView();
        }
        if (isKeyboardShown()) {
            try {
                click(getWebElement(Locators.ACCESSIBILITY_ID.toString(), accessId));
            } catch (Exception e) {
                System.err.println("Clicked the element via catch block");
                getWebElement(Locators.ACCESSIBILITY_ID.toString(), accessId).click();
            }
        }
        if (!isNative) {
            switchContext(context);
        }
    }

    public void clickGivenKeyboardButtonInIosByXpath(String xPath) {
        boolean isNative = ((SupportsContextSwitching) driver).getContext().equalsIgnoreCase("NATIVE_APP");
        String context = ((SupportsContextSwitching) driver).getContext();
        if (!isNative) {
            switchNativeView();
        }
        if (isKeyboardShown()) {
            click(getWebElement(Locators.XPATH.toString(), xPath));
        }
        if (!isNative) {
            switchContext(context);
        }
    }
}
