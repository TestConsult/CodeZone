package uk.nhs.nhsbsa.services.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import uk.nhs.nhsbsa.services.browserUtil.BrowserFactory;

public class ScenarioHooks {
    private  BrowserFactory bf;
    private WebDriver driver;

    public ScenarioHooks(BrowserFactory bf) {
        this.bf = bf;
    }

    @Before
    public void before(){
        this.driver = bf.initialiserBrowser();

    }

    @After
    public void after(){
        bf.deInitialiseBrowser();
    }
}
