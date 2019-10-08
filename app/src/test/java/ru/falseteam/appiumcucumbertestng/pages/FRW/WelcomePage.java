package ru.falseteam.appiumcucumbertestng.pages.FRW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.BasicPage;

public class WelcomePage extends BasicPage {

    @AndroidFindBy(id = "com.chrome.canary:id/fre_pager")
    public WebElement page;

    @AndroidFindBy(id = "com.chrome.canary:id/send_report_checkbox")
    public WebElement checkboxAccept;

    @AndroidFindBy(id = "com.chrome.canary:id/terms_accept")
    public WebElement buttonContinue;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    public WelcomePage() {
        super();
    }

    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout, ExpectedConditions.visibilityOfAllElements(
                page, checkboxAccept, buttonContinue));
    }

    public boolean checkboxAcceptIsChecked() {
        return super.checkboxIsChecked(checkboxAccept);
    }
}