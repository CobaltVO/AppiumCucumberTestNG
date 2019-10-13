package ru.falseteam.appiumcucumbertestng.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class BasicPage {

    public BasicPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public abstract WebDriver getDriver();

    public abstract void waitPageVisible(int timeout);

    public boolean checkboxIsChecked(WebElement checkbox) {
        return checkbox.getAttribute("checked").equals("true");
    }

    public <V> void waitUntil(int timeout, Function<? super WebDriver, V> conditions, String errorMessage) {
        try {
            new WebDriverWait(getDriver(), timeout).until(conditions);
        } catch (TimeoutException e) {
            Assert.fail(errorMessage);
        }
    }

    public void clickToElementWithText(List<WebElement> elements, String expectedText, String errorMessage) {
        try {
            elements.stream()
                    .filter(element -> element.getText().equals(expectedText))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new)
                    .click();
        } catch (NoSuchElementException e) {
            Assert.fail(errorMessage);
        }
    }
}
