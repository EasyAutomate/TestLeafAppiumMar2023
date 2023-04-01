package learning;

import org.testng.annotations.Test;
import wrappers.CommonNativeWrappers;
import wrappers.GenericWrappers;

public class LearnPickerWheelIniOSUsingSendKeys extends GenericWrappers {
    @Test
    public void runCode() {
        launchIosApp("my real device", "00008030-000A708E01F0C02E", "", "com.example.apple-samplecode.UICatalog", "");
        click(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Picker View"));
        enterValue(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Red color component value"), "100");
        enterValue(getWebElement(CommonNativeWrappers.Locators.ACCESSIBILITY_ID.asString(), "Green color component value"), "200");
        sleep(5000);
        closeApp();

    }
}