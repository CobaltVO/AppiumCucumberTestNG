package ru.falseteam.appiumcucumbertestng.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Driver {
    public static AndroidDriver<WebElement> driver;

    public static void setUp() {
        String nodeJsHome = System.getenv("NODE_JS_HOME");
        if (nodeJsHome == null) Assert.fail("NODE_JS_HOME environment variable is not set");

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Capabilities.PLATFORM_NAME);
        driver = new AndroidDriver<>(
                new AppiumServiceBuilder()
                        .usingAnyFreePort()
                        .usingDriverExecutable(new File(nodeJsHome))
                , dc);
    }

    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}

