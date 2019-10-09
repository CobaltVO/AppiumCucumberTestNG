package ru.falseteam.appiumcucumbertestng.pages.FRW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.BasicPage;
import ru.falseteam.appiumcucumbertestng.pages.locators.Id;

public class SyncPage extends BasicPage {

    @AndroidFindBy(id = Id.BUTTON_NO_THANKS)
    public WebElement buttonNoThanks;

    @AndroidFindBy(id = Id.BUTTON_ADD_ACCOUNT)
    public WebElement buttonAddAccount;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    @Override
    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout, ExpectedConditions.visibilityOfAllElements(
                buttonNoThanks, buttonAddAccount));
    }
}
