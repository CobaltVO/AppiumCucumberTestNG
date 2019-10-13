package ru.falseteam.appiumcucumbertestng.steps;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import ru.falseteam.appiumcucumbertestng.driver.Driver;

public class BasicSteps extends Driver {

    public static void startRecordingScreen() {
        driver.startRecordingScreen();
        System.out.println("page recorder was started");
    }

    public static void stopRecordingScreen() {
        driver.stopRecordingScreen();
        System.out.println("page recorder was stopped");
    }

    @When("wait for {int} seconds")
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Assert.fail("Can not wait for " + seconds + " seconds", e);
        }
    }

    @And("click android back button")
    public void clickAndroidBackButton() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
