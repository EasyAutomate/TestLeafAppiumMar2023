package learning;

import org.testng.annotations.Test;
import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnPickerWheelIniOS extends GenericWrappers {

    @Test
    public void runCode() {
        launchIosApp("my real device", "00008030-000A708E01F0C02E", "", "com.example.apple-samplecode.UICatalog", "");
        stopRunningApp("com.example.apple-samplecode.UICatalog");
        switchToAnotherApp("com.example.apple-samplecode.UICatalog");
        click(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Picker View"));
//        swipeUpInAppWithWebElement(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        chooseNextOptionInPickerWheel(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        choosePreviousOptionInPickerWheel(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Green color component value"));
        choosePreviousOptionInPickerWheel(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Blue color component value"));
        sleep(5000);
        closeApp();
    }
}