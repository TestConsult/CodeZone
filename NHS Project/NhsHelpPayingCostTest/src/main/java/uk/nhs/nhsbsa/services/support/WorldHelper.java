package uk.nhs.nhsbsa.services.support;

import org.openqa.selenium.support.PageFactory;
import uk.nhs.nhsbsa.services.Pages.BasePage;
import uk.nhs.nhsbsa.services.browserUtil.BrowserFactory;

public class WorldHelper {
    private static BasePage basePage;


    public BasePage getBasePage() {
        if (basePage != null) return basePage;
        return PageFactory.initElements(BrowserFactory.getDriver(), BasePage.class);
    }
}