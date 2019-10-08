package ru.falseteam.appiumcucumbertestng.steps;

import org.testng.Assert;

import io.cucumber.java.en.When;
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
}
