package ru.falseteam.appiumcucumbertestng.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {

    DesiredCapabilities capabilities;

    public static final String ADB_EXEC_TIMEOUT_CAPABILITY = "adbExecTimeout";
    public static final String AUTOLAUNCH_CAPABILITY = "autoLaunch";

    Capabilities(String deviceName,
                 String browserType) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserType);
    }

    Capabilities(String deviceName,
                 String apkPath, String apkPackage, String apkActivity) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.APP, apkPath);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apkPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, apkActivity);
    }
}
