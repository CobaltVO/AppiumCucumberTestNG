package ru.falseteam.appiumcucumbertestng.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class CapabilitiesBuilder extends BasicCapabilities {

    private static final String PLATFORM_NAME = MobilePlatform.ANDROID;
    private static final String AUTOMATION_NAME = AutomationName.ANDROID_UIAUTOMATOR2;

    private static final int ADB_EXEC_TIMEOUT_MS = 180 * 1000;
    private static final int NEW_COMMAND_TIMEOUT_MS = 180 * 1000;

    public CapabilitiesBuilder(String browserType) {
        super(browserType);
        setStandardExtraCapabilities();
    }

    public CapabilitiesBuilder(String apkPath, String apkPackage, String apkActivity) {
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
        dc.setCapability(Capabilities.ADB_EXEC_TIMEOUT_CAPABILITY, ADB_EXEC_TIMEOUT_MS);
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, NEW_COMMAND_TIMEOUT_MS);
        capabilities.merge(dc);
    }

    /**
     * Reset app before test, don't delete after
     */
    public CapabilitiesBuilder setNoReset(boolean state) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.NO_RESET, state);
        capabilities.merge(dc);
        return this;
    }

    /**
     * Reinstall app before test, delete after
     */
    public CapabilitiesBuilder setFullReset(boolean state) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.FULL_RESET, state);
        capabilities.merge(dc);
        return this;
    }

    public CapabilitiesBuilder setAdbExecTimeout(int millis) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, millis);
        capabilities.merge(dc);
        return this;
    }

    public CapabilitiesBuilder setNewCommandTimeout(int seconds) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, seconds);
        capabilities.merge(dc);
        return this;
    }

    public CapabilitiesBuilder setAutoLaunch(boolean state) {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(Capabilities.AUTOLAUNCH_CAPABILITY, state);
        capabilities.merge(dc);
        return this;
    }
}
