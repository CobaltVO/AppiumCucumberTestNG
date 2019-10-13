package ru.falseteam.appiumcucumbertestng.pages.FRW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.BasicPage;
import ru.falseteam.appiumcucumbertestng.pages.locators.Id;

public class WelcomePage extends BasicPage {

    @AndroidFindBy(id = Id.CHECKBOX_ACCEPT)
    private WebElement checkboxAccept;

    @AndroidFindBy(id = Id.BUTTON_TERMS_ACCEPT)
    private WebElement buttonContinue;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    @Override
    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout,
                ExpectedConditions.visibilityOfAllElements(checkboxAccept, buttonContinue),
                "welcome page didn't become visible after " + timeout + " seconds");
    }

    public void clickCheckboxAccept() {
        checkboxAccept.click();
    }

    public void clickButtonContinue() {
        buttonContinue.click();
    }

    public boolean checkboxAcceptIsChecked() {
        return super.checkboxIsChecked(checkboxAccept);
    }
}