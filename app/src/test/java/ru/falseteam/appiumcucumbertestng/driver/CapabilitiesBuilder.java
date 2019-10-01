package ru.falseteam.appiumcucumbertestng.driver;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilitiesBuilder extends BasicCapabilities {

    private static final String PLATFORM_NAME = "Android";
    private static final String AUTOMATION_NAME = "UiAutomator2";

    private static final int ADB_EXEC_TIMEOUT = 60000;

    CapabilitiesBuilder(String browserType) {
        super(browserType);
        setStandardExtraCapabilities();
    }

    CapabilitiesBuilder(String apkPath, String apkPackage, String apkActivity) {
        super(apkPath, apkPackage, apkActivity);
        setStandardExtraCapabilities();
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    private void setStandardExtraCapabilities() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        dc.setCapability(Capabilities.ADB_EXEC_TIMEOUT_CAPABILITY, ADB_EXEC_TIMEOUT);
        capabilities.merge(dc);
    }

    public CapabilitiesBuilder setNoReset(boolean state) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.NO_RESET, state);
        capabilities.merge(dc);
        return this;
    }

    public CapabilitiesBuilder setFullReset(boolean state) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.FULL_RESET, state);
        capabilities.merge(dc);
        return this;
    }
}
