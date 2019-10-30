package uk.nhs.nhsbsa.services.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhereYouLivePage extends BasePage {
    @FindBy(id = "label-england")
    private WebElement englandElement = null;
    @FindBy(id = "label-scotland")
    private WebElement scotlandElement = null;
    @FindBy(id = "label-wales")
    private WebElement walesElement = null;
    @FindBy(id = "label-nire")
    private WebElement northernIrelandElement = null;


    public WhereYouLivePage(WebDriver driver) {
        super(driver);
    }

    public DateOfBirthPage selectCountry(String countryName) {
        if (countryName.toLowerCase().contains("England".toLowerCase())) {
            englandElement.click();
        } else if (countryName.toLowerCase().contains("Scotland".toLowerCase())) {
            scotlandElement.click();
        } else if (countryName.toLowerCase().contains("Wales".toLowerCase())) {
            walesElement.click();
        } else if (countryName.toLowerCase().contains("Northern Ireland".toLowerCase())) {
            northernIrelandElement.click();
        } else {
            throw new IllegalArgumentException("There is no such" + countryName);
        }

        nextButtonElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PageFactory.initElements(driver,DateOfBirthPage.class);


    }
}





