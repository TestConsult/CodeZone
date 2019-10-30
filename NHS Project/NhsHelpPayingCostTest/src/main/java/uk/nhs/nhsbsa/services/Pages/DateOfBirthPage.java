package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DateOfBirthPage extends BasePage{
    @FindBy(id = "dob-day")
    private WebElement dayOfBirthElement = null;
    @FindBy(id = "dob-month")
    private WebElement monthOfBirthElement = null;
    @FindBy(id = "dob-year")
    private WebElement yearOfBirthElement = null;

    public DateOfBirthPage(WebDriver driver) {
        super(driver);
    }

    public PartnersPage inputYourDateOfBirth(String dayValue, String month, String yearValue) {
        dayOfBirthElement.sendKeys(dayValue);
        monthOfBirthElement.sendKeys(month);
        yearOfBirthElement.sendKeys(yearValue);
        nextButtonElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver,PartnersPage.class);
    }
}
