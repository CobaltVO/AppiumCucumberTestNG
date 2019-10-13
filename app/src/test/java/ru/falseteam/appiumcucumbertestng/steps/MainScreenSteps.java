package ru.falseteam.appiumcucumbertestng.steps;

import cucumber.api.java.en.When;
import ru.falseteam.appiumcucumbertestng.pages.FRW.MainPage;

public class MainScreenSteps {
    private MainPage mainPage = new MainPage();

    @When("click {word} recent site")
    public void clickYouTubeRecentSite(String site) {
        mainPage.clickRecentSite(site);
    }

}
