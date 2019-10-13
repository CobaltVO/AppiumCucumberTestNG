package ru.falseteam.appiumcucumbertestng.pages.FRW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.BasicPage;
import ru.falseteam.appiumcucumbertestng.pages.locators.Id;

public class TurboPage extends BasicPage {

    @AndroidFindBy(id = Id.SWITCH_TURBO)
    private WebElement switchTurbo;

    @AndroidFindBy(id = Id.BUTTON_CONTINUE)
    private WebElement buttonContinue;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    @Override
    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout,
                ExpectedConditions.visibilityOfAllElements(switchTurbo, buttonContinue),
                "turbo page didn't become visible after " + timeout + " seconds");
    }

    public void clickSwitchTurbo() {
        switchTurbo.click();
    }

    public void clickButtonContinue() {
        buttonContinue.click();
    }

    public boolean isSwitchTurboOn() {
        return super.checkboxIsChecked(switchTurbo);
    }
}
