package uk.nhs.nhsbsa.services.browserUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import uk.nhs.nhsbsa.services.fileUtil.Props;

import static uk.nhs.nhsbsa.services.browserUtil.BrowserFactory.driver;

public class LocalBrowserManager {

    public WebDriver createLocalBrowser() {
            String browserName = Props.getConfig("nhs-browserName");
            if (browserName.toLowerCase().contains("chrome".toLowerCase())) {
                createChromeBrowser();
            } else if (browserName.toLowerCase().contains("firefox")) {
                createFirefoxBrowser();
            } else{
                throw new IllegalArgumentException("There is no such"+browserName);
            }
            return driver;
        }

    private void createChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--enable-javascript");
        options.addArguments("--disable-websecurity");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);


    }
    private void createFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", false);
        FirefoxOptions options = new FirefoxOptions();
        options.merge(capabilities);

    }
}
