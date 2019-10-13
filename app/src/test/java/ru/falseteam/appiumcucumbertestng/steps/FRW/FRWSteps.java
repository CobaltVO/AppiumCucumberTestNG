package ru.falseteam.appiumcucumbertestng.steps.FRW;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.pages.FRW.MainPage;
import ru.falseteam.appiumcucumbertestng.pages.FRW.SearchEnginePage;
import ru.falseteam.appiumcucumbertestng.pages.FRW.SyncPage;
import ru.falseteam.appiumcucumbertestng.pages.FRW.TurboPage;
import ru.falseteam.appiumcucumbertestng.pages.FRW.WelcomePage;
import ru.falseteam.appiumcucumbertestng.util.Logger;

public class FRWSteps extends Driver {

    private WelcomePage welcomePage = new WelcomePage();
    private TurboPage turboPage = new TurboPage();
    private SearchEnginePage searchEnginePage = new SearchEnginePage();
    private SyncPage syncPage = new SyncPage();
    private MainPage mainPage = new MainPage();

    private static final int PAGE_VISIBLE_TIMEOUT = 10;

    @When("welcome page appears")
    public void welcomePageAppears() {
        welcomePage.waitPageVisible(PAGE_VISIBLE_TIMEOUT);
        Logger.debug("'Welcome' page appears");
    }

    @Then("set checkbox to disabled at the welcome page")
    public void setCheckboxToDisabledAtTheWelcomePage() {
        if (welcomePage.checkboxAcceptIsChecked()) {
            welcomePage.clickCheckboxAccept();
        }
        Logger.debug("checkbox 'Accept' was unchecked");
    }

    @And("click continue button at the welcome page")
    public void clickContinueAtTheWelcomePage() {
        welcomePage.clickButtonContinue();
        Logger.debug("'Continue' button was clicked");
    }

    @When("turbo page appears")
    public void turboPageAppears() {
        turboPage.waitPageVisible(PAGE_VISIBLE_TIMEOUT);
        Logger.debug("'Turbo' page appears");
    }

    @When("set switch to disabled at the turbo page")
    public void setSwitchToDisabledAtTheTurboPage() {
        if (turboPage.isSwitchTurboOn()) {
            turboPage.clickSwitchTurbo();
        }
        Logger.debug("switch 'Turbo' was unchecked");
    }

    @Then("click continue button at the turbo page")
    public void clickContinueButtonAtTheTurboPage() {
        turboPage.clickButtonContinue();
        Logger.debug("'Continue' button was clicked at the 'Turbo' page");
    }

    @When("search engine page appears")
    public void searchEnginePageAppears() {
        searchEnginePage.waitPageVisible(PAGE_VISIBLE_TIMEOUT);
        Logger.debug("'Search engine' page appears");
    }

    @When("set radio button to {word} at the search engine page")
    public void setRadioButtonToGoogleAtTheSearchEnginePage(String searchEngine) {
        searchEnginePage.selectSearchEngine(searchEngine);
        Logger.debug("Search engine was set to '" + searchEngine + "'");
    }

    @Then("click OK button at the search engine page")
    public void clickOKButtonAtTheSearchEnginePage() {
        searchEnginePage.clickButtonOk();
        Logger.debug("'OK' button was clicked at the 'Search Engine' page");
    }

    @When("sync page appears")
    public void syncPageAppears() {
        syncPage.waitPageVisible(PAGE_VISIBLE_TIMEOUT);
        Logger.debug("'Sync' page appears");
    }

    @Then("click no thanks button at the sync page")
    public void clickNoThanksButtonAtTheSyncPage() {
        syncPage.clickButtonNoThanks();
        Logger.debug("'No, thanks' button was clicked at the 'Sync' page");
    }

    @Then("main page of Chrome appears")
    public void mainPageOfChromeAppears() {
        mainPage.waitPageVisible(PAGE_VISIBLE_TIMEOUT);
        Logger.debug("Main screen of Chrome appears");
    }
}
