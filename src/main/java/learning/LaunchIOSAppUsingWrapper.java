package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

public class LaunchIOSAppUsingWrapper extends GenericWrappers {

    @Test
    public void runScript() {
        launchIosApp("my real device", "00008030-000A708E01F0C02E", "", "com.example.apple-samplecode.UICatalog", "");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Action Sheets"));
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Okay / Cancel"));
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "OK"));
        closeApp();
    }
}