package ru.falseteam.appiumcucumbertestng.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import ru.falseteam.appiumcucumbertestng.Constants;

public class Driver {
    public static AndroidDriver<WebElement> driver;

    public static void setUp() {
        String nodeJsHome = System.getenv("NODE_JS_HOME");
        if (nodeJsHome == null) Assert.fail("NODE_JS_HOME environment variable is not set");

        CapabilitiesBuilder builder = new CapabilitiesBuilder(
//                BrowserType.CHROME
                Capabilities.findApk(),
                Constants.CHROME_CANARY_PACKAGE_NAME,
                Constants.CHROME_CANARY_LAUNCHER_ACTIVITY_NAME
        );
        DesiredCapabilities capabilities = builder
                .setFullReset(false)
                .setNoReset(true)
                .getCapabilities();
        driver = new AndroidDriver<>(
                new AppiumServiceBuilder()
                        .usingAnyFreePort()
                        .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER,
                                String.valueOf(findFreePort()))
                        .usingDriverExecutable(new File(nodeJsHome))
                , capabilities);
    }

    public static void tearDown() {
        driver.close();
        driver.quit();
    }

    private static int findFreePort() {
        try {
            ServerSocket socket = new ServerSocket(0);
            int port = socket.getLocalPort();
            socket.close();
            return port;
        } catch (IOException e) {
            Assert.fail("Can not find available port");
        }
        return -1;
    }
}

