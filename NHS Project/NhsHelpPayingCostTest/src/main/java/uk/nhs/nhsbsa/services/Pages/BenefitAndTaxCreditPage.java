package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BenefitAndTaxCreditPage extends BasePage{
    public BenefitAndTaxCreditPage(WebDriver driver) {
        super(driver);
    }

    public PaidUniversalCreditPage answerBenefitAndTaxCreditQuestion(String option) {
        if (option.toLowerCase().contains("Yes".toLowerCase())) {
            yesElement.click();
        } else if (option.toLowerCase().contains("No".toLowerCase())) {
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
        return PageFactory.initElements(driver,PaidUniversalCreditPage.class);
    }
}
