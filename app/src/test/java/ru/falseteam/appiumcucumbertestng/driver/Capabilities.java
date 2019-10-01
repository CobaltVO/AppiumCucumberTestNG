package ru.falseteam.appiumcucumbertestng.driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import ru.falseteam.appiumcucumbertestng.Constants;

public class Capabilities {

    DesiredCapabilities capabilities;

    static final String ADB_EXEC_TIMEOUT_CAPABILITY = "adbExecTimeout";

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

    public static String findApk() {
        Pattern patternApk = Pattern.compile(".+([^apk].apk)");
        try (Stream<Path> stream = Files.walk(Paths.get(Constants.PROJECT_APP_SEARCH_PATH))) {
            Optional<Path> optionalPath = stream
                    .filter(path -> patternApk.matcher(path.getFileName().toString()).matches())
                    .findFirst();
            return optionalPath.orElseThrow(() -> new FileNotFoundException(
                    "Can not find apk at the resources/apk/ folder of project"))
                    .toAbsolutePath().toString();
        } catch (IOException e) {
            Assert.fail("Can't find apk to test", e);
        }
        return null;
    }
}
