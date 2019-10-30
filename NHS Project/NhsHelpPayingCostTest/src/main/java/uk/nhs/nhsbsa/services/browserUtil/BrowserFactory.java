package uk.nhs.nhsbsa.services.browserUtil;
import org.openqa.selenium.WebDriver;
import uk.nhs.nhsbsa.services.fileUtil.Props;

public class BrowserFactory{
    protected static WebDriver driver;

    public WebDriver initialiserBrowser() {
        String placeOfExecution = Props.getConfig("nhs-placeOfExec");
        if (placeOfExecution.toLowerCase().contains("local".toLowerCase())) {
            LocalBrowserManager lbm = new LocalBrowserManager();
            this.driver = lbm.createLocalBrowser();
        }else{
            throw new IllegalArgumentException("There is no such" + placeOfExecution);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        throw new IllegalAccessError("Browser has not been initialised");
    }

    public void deInitialiseBrowser() {
        if (driver != null)
            driver.quit();
    }



}
