package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaidUniversalCreditPage extends BasePage {
    @FindBy(id = "paidUniversalCredit_fieldset")
    private WebElement creditYesElement = null;
    @FindBy(id = "paidUniversalCredit_fieldset")
    private WebElement creditNotYetElement = null;
    @FindBy(id = "paidUniversalCredit_fieldset")
    private WebElement creditNoElement = null;

    public PaidUniversalCreditPage(WebDriver driver) {
        super(driver);
    }

    public ClaimUniversalCreditPage answerUniversalCreditQuestion(String universalCreditOption) {
        for (WebElement creditYes : creditYesElement.findElements(By.tagName("label"))) {
            if (creditYes.getAttribute("for").contains("yes-universal")) {
                creditYes.click();
                break;
            }
            for (WebElement creditNoTyET : creditNotYetElement.findElements(By.tagName("label"))) {
                if (creditNoTyET.getAttribute("for").contains("not-yet")) {
                    creditNoTyET.click();
                    break;

                }
                for (WebElement creditNo : creditNoElement.findElements(By.tagName("label"))) {
                    if (creditNo.getAttribute("for").contains("nO")) {
                        creditNo.click();
                        break;
                    }
                }
            }
        }
                    nextButtonElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver, ClaimUniversalCreditPage.class);
                }
            }


