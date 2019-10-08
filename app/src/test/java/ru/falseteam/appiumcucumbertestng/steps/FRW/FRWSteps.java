package ru.falseteam.appiumcucumbertestng.steps.FRW;

import java.util.Arrays;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.FRW.TurboPage;
import ru.falseteam.appiumcucumbertestng.pages.FRW.WelcomePage;
import ru.falseteam.appiumcucumbertestng.util.Logger;

public class FRWSteps extends Driver {

    private WelcomePage welcomePage = new WelcomePage();
    private TurboPage turboPage = new TurboPage();

    private enum Page {
        Welcome,
        Turbo,
        SearchEngine,
        Sync
    }

    private Page castStringToPage(String s) {
        StringBuilder sb = new StringBuilder();
        Arrays.asList(s.split("\\W")).forEach(
                out -> sb.append(out.replace(out.charAt(0), Character.toUpperCase(out.charAt(0))))
        );
        return Page.valueOf(sb.toString());
    }

    @When("{word} page appears")
    public void welcomePageAppears(String s) {
        int timeout = 10;
        Page page = castStringToPage(s);
        switch (page) {
            case Welcome:
                welcomePage.waitPageVisible(timeout);
                Logger.debug("'Welcome' page appears");
                break;
            case Turbo:
                turboPage.waitPageVisible(timeout);
                Logger.debug("'Turbo' page appears");
                break;
            case SearchEngine:
                break;
            case Sync:
                break;
        }

    }

    @Then("set checkbox to disabled at the welcome page")
    public void setCheckboxToDisabledAtTheWelcomePage() {
        if (welcomePage.checkboxAcceptIsChecked()) {
            welcomePage.checkboxAccept.click();
        }
        Logger.debug("checkbox 'Accept' was unchecked");
    }

    @And("click continue button at the welcome page")
    public void clickContinueAtTheWelcomePage() {
        welcomePage.buttonContinue.click();
        Logger.debug("'Continue' button was clicked");
    }

    @When("set switch to disabled at the turbo page")
    public void setSwitchToDisabledAtTheTurboPage() {
        if (turboPage.isSwitchTurboOn()) {
            turboPage.switchTurbo.click();
        }
        Logger.debug("switch 'Turbo' was unchecked");
    }

    @Then("click continue button at the turbo page")
    public void clickContinueButtonAtTheTurboPage() {
        turboPage.buttonContinue.click();
    }
}
