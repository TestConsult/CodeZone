package uk.nhs.nhsbsa.services.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.nhs.nhsbsa.services.fileUtil.Props;

public class BasePage {
    protected  WebDriver driver;
    @FindBy(id = "next-button")
    protected WebElement nextButtonElement = null;
    @FindBy(id = "label-yes")
    protected WebElement yesElement = null;
    @FindBy(id = "label-no")
    protected WebElement noElement = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage loadNhsCheckerApplication() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String url = Props.getConfig("nhs-pay-checker-url");
        driver.navigate().to(url);
        return PageFactory.initElements(driver, HomePage.class);
    }
}
