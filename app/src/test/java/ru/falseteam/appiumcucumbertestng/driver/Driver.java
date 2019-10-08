package ru.falseteam.appiumcucumbertestng.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import ru.falseteam.appiumcucumbertestng.capabilities.CapabilitiesBuilder;
import ru.falseteam.appiumcucumbertestng.util.Constants;
import ru.falseteam.appiumcucumbertestng.util.Helpers;

public class Driver {

    public static AndroidDriver<WebElement> driver;

    public static void setUp() {
        String nodeJsHome = System.getenv("NODE_JS_HOME");
        if (nodeJsHome == null) Assert.fail("NODE_JS_HOME environment variable is not set");
        CapabilitiesBuilder builder = new CapabilitiesBuilder(
//                BrowserType.CHROME
                Helpers.findApk(),
                Constants.CHROME_CANARY_PACKAGE_NAME,
                Constants.CHROME_CANARY_LAUNCHER_ACTIVITY_NAME
        );

        DesiredCapabilities capabilities = builder
                .setNoReset(false)
                .setAutoLaunch(true)
                .getCapabilities();
        driver = new AndroidDriver<>(
                new AppiumServiceBuilder()
                        .usingAnyFreePort()
                        .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER,
                                String.valueOf(Helpers.findFreePort()))
                        .usingDriverExecutable(new File(nodeJsHome))
                , capabilities);
    }

    public static void tearDown() {
        driver.quit();
    }
}

