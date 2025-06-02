package SharedData;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import SharedData.browser.BrowserFactory;
import configFile.ConfigFile;
import configFile.configNode.ConfigurationNode;

public class SharedData {

    public WebDriver driver;

    @BeforeMethod
    public void prepareBrowser() {
        driver = new BrowserFactory().getBrowserFactory();
    }

    @AfterMethod
    public void clearBrowser() {
        driver.quit();
    }

}
