package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.WebDriver;

public class QualifyingPage extends BasePage{
    public QualifyingPage(WebDriver driver) {
        super(driver);
    }
    public boolean validateClaimStatus(String message){
        return driver.getPageSource().toLowerCase().contains(message.toLowerCase());

    }
}
