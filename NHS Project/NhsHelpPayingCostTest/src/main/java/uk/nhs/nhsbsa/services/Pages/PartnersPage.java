package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnersPage extends BasePage{
    public PartnersPage(WebDriver driver) {
        super(driver);
    }

    public BenefitAndTaxCreditPage answerPartnerQuestion(String option) {
        if (option.toLowerCase().contains("Yes".toLowerCase())) {
            yesElement.click();
        } else if (option.toLowerCase().contains("No")) {
            noElement.click();
        } else {
            throw new IllegalArgumentException("Please select an" + option);
        }
        nextButtonElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver,BenefitAndTaxCreditPage.class);
    }

}
