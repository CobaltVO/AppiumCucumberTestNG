package ru.falseteam.appiumcucumbertestng.pages.FRW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.BasicPage;
import ru.falseteam.appiumcucumbertestng.pages.locators.Id;

public class MainPage extends BasicPage {

    @AndroidFindBy(id = Id.EDIT_TEXT_SEARCH)
    WebElement editTextSearch;

    @AndroidFindBy(id = Id.BUTTON_HOME)
    WebElement buttonHome;

    @AndroidFindBy(id = Id.BUTTON_TABS)
    WebElement buttonTabs;

    @AndroidFindBy(id = Id.BUTTON_SETTINGS)
    WebElement buttonSettings;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    @Override
    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout, ExpectedConditions.visibilityOfAllElements(
                editTextSearch, buttonHome, buttonTabs, buttonSettings));
    }
}
