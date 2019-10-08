package ru.falseteam.appiumcucumbertestng.capabilities;

public class BasicCapabilities extends Capabilities {

    private static final String DEVICE_NAME = "Android";

    BasicCapabilities(String browserType) {
        super(DEVICE_NAME, browserType);
    }

    BasicCapabilities(String apkPath, String apkPackage, String apkActivity) {
        super(DEVICE_NAME, apkPath, apkPackage, apkActivity);
    }
}
