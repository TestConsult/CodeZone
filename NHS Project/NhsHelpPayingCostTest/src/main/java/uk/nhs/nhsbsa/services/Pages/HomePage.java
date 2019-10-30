package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @FindBy(id ="next-button")
    private WebElement startButtonElement = null;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    public WhereYouLivePage clickOnStartButton(){
        startButtonElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver,WhereYouLivePage.class);
    }
}

