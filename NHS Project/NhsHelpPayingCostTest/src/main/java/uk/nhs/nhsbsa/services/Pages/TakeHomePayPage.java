package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TakeHomePayPage extends BasePage{
    public TakeHomePayPage(WebDriver driver) {
        super(driver);
    }
    public QualifyingPage answerTakeHomePayQuestion(String takeHomePay){
        if(takeHomePay.equals("935")) {
            yesElement.click();
        }else if(takeHomePay.equals("0")){
            noElement.click();
        }else{
            throw new IllegalArgumentException("Please select an"+ takeHomePay);
        }
        nextButtonElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver,QualifyingPage.class);
    }
}
