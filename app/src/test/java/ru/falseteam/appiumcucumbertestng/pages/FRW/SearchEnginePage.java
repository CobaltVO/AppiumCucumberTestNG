package ru.falseteam.appiumcucumbertestng.pages.FRW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.BasicPage;
import ru.falseteam.appiumcucumbertestng.pages.locators.ClassName;
import ru.falseteam.appiumcucumbertestng.pages.locators.Id;

public class SearchEnginePage extends BasicPage {

    @AndroidFindBy(id = Id.RADIO_GROUP_SEARCH_ENGINE)
    public WebElement radioGroupSearchEngines;

    @AndroidFindBy(id = Id.BUTTON_OK)
    public WebElement buttonOk;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    @Override
    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout, ExpectedConditions.visibilityOfAllElements(
                radioGroupSearchEngines, buttonOk));
    }

    public void selectSearchEngine(String engine) {
        radioGroupSearchEngines
                .findElements(By.className(ClassName.RADIO_BUTTON))
                .forEach(radioButton -> {
                    if (radioButton.getText().toLowerCase().equals(engine.toLowerCase())) {
                        radioButton.click();
                    }
                });
    }
}
