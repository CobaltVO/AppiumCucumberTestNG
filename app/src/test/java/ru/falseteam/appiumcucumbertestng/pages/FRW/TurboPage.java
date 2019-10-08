package ru.falseteam.appiumcucumbertestng.pages.FRW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.BasicPage;

public class TurboPage extends BasicPage {

    @AndroidFindBy(id = "com.chrome.canary:id/fre_pager")
    public WebElement page;

    @AndroidFindBy(id = "com.chrome.canary:id/enable_data_saver_switch")
    public WebElement switchTurbo;

    @AndroidFindBy(id = "com.chrome.canary:id/next_button")
    public WebElement buttonContinue;

    @Override
    public WebDriver getDriver() {
        return Driver.driver;
    }

    public TurboPage() {
        super();
    }

    public void waitPageVisible(int timeout) {
        super.waitUntil(timeout, ExpectedConditions.visibilityOfAllElements(
                page, switchTurbo, buttonContinue));
    }

    public boolean isSwitchTurboOn() {
        return super.checkboxIsChecked(switchTurbo);
    }
}
