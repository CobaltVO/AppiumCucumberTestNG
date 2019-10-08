package ru.falseteam.appiumcucumbertestng.cucumber;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import ru.falseteam.appiumcucumbertestng.driver.Driver;
import ru.falseteam.appiumcucumbertestng.util.Constants;
import ru.falseteam.appiumcucumbertestng.util.Helpers;

@CucumberOptions(
        monochrome = true,
        tags = "@bvt",
        features = Constants.PROJECT_FEATURES_PATH,
        glue = Constants.GLUE,
        plugin = {
                "pretty",
                "html:build/cucumber-reports/cucumber-pretty",
                "json:build/cucumber-reports/CucumberTestReport.json",
                "rerun:build/cucumber-reports/rerun.txt",
        }
)
public class CucumberRunner {

    private TestNGCucumberRunner runner;

    @BeforeClass
    public void setUp() {
        runner = new TestNGCucumberRunner(CucumberRunner.class);
        Driver.setUp();
        Helpers.logDriverCapabilities();
    }

    @AfterClass
    public void tearDown() {
        runner.finish();
        Driver.tearDown();
    }

    @DataProvider
    public Object[][] scenarios() {
        return runner.provideScenarios();
    }

    @Test(groups = "cucumber", description = "Run Cucumber scenarios", dataProvider = "scenarios")
    public void runScenarios(PickleEventWrapper pickle, CucumberFeatureWrapper feature) throws Throwable {
        runner.runScenario(pickle.getPickleEvent());
    }
}
