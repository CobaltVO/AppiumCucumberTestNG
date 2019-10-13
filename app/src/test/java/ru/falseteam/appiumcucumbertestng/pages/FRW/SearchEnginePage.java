package ru.falseteam.appiumcucumbertestng.pages.FRW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.BasicPage;
import ru.falseteam.appiumcucumbertestng.pages.locators.ClassName;
import ru.falseteam.appiumcucumbertestng.pages.locators.Id;

public class SearchEnginePage extends BasicPage {

    @AndroidFindBy(id = Id.RADIO_GROUP_SEARCH_ENGINE)
    private WebElement radioGroupSearchEngines;

    @AndroidFindBy(id = Id.BUTTON_OK)
    private WebElement buttonOk;

    @AndroidFindBy(id = Id.RADIO_GROUP_SEARCH_ENGINE)
    @AndroidFindBy(className = ClassName.RADIO_BUTTON)
    private List<WebElement> radioButtonsSearchEngine;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    @Override
    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout,
                ExpectedConditions.visibilityOfAllElements(radioGroupSearchEngines, buttonOk),
                "search engine page didn't become visible after " + timeout + " seconds");
    }

    public void clickButtonOk() {
        buttonOk.click();
    }

    public void selectSearchEngine(String engine) {
        clickToElementWithText(radioButtonsSearchEngine,
                engine,
                "search engine '" + engine + "' was not found");
    }
}
