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

public class MainPage extends BasicPage {

    @AndroidFindBy(id = Id.EDIT_TEXT_SEARCH)
    private WebElement editTextSearch;

    @AndroidFindBy(id = Id.BUTTON_HOME)
    private WebElement buttonHome;

    @AndroidFindBy(id = Id.BUTTON_TABS)
    private WebElement buttonTabs;

    @AndroidFindBy(id = Id.BUTTON_SETTINGS)
    private WebElement buttonSettings;

    @AndroidFindBy(id = Id.CONTAINER_RECENT_SITES)
    @AndroidFindBy(className = ClassName.TEXT_VIEW)
    @AndroidFindBy(id = Id.BUTTON_RECENT_SITE)
    private List<WebElement> recentSites;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    @Override
    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout,
                ExpectedConditions.visibilityOfAllElements(
                        editTextSearch, buttonHome, buttonTabs, buttonSettings),
                "main page didn't become visible after " + timeout + " seconds");
    }

    public void clickRecentSite(String userSite) {
        clickToElementWithText(recentSites,
                userSite,
                "recent size '" + userSite + "' was not found");
    }
}
