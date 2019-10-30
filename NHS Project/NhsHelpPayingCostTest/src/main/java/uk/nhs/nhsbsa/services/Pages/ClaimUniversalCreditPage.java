package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClaimUniversalCreditPage extends BasePage{
    public ClaimUniversalCreditPage(WebDriver driver) {
        super(driver);
    }

    public TakeHomePayPage answerClaimQuestion(String claimquestion){
        if(claimquestion.toLowerCase().contains("Yes".toLowerCase())) {
            yesElement.click();
        }else if(claimquestion.toLowerCase().contains("No".toLowerCase())) {
            noElement.click();
        }else{
            throw new IllegalArgumentException("There is no such" + claimquestion);
        }
        nextButtonElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver,TakeHomePayPage.class);
    }
    
}
