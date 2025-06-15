package SharedData;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import SharedData.browser.BrowserFactory;
import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;
import logger.LoggerUtility;

public class SharedData {

    public WebDriver driver;

    public void prepareBrowser() {

        driver = new BrowserFactory().getBrowserFactory();
        LoggerUtility.infoLog("Browser opened with success");
    }

    public void clearBrowser() {

        driver.quit();
        LoggerUtility.infoLog("Browser closed with success");
    }

}
