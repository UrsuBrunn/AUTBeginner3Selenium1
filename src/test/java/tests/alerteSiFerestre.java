package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import HelperMethods.alertsMethod;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import pages.HomePage;
import pages.CommonPage;
import pages.alerteFerestrePage;

public class alerteSiFerestre {

    public WebDriver driver;
    public elementsMethod elementsMethod;
    public alertsMethod alertsMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public alerteFerestrePage alerteFerestrePage;

    @Test
    public void newAlertTest() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);
        elementsMethod = new elementsMethod(driver);
        alertsMethod = new alertsMethod(driver);
        alerteFerestrePage = new alerteFerestrePage(driver);

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();

        //  Accesam o pagina web
        driver.get("https://demoqa.com/");

        // Definim un wait implicit pt un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver

        jsHelper.scrollDown(400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Alerts");

        alerteFerestrePage.showAlertOk();
        alerteFerestrePage.showAlertDelayed();
        alerteFerestrePage.alertMessageDismiss();
        alerteFerestrePage.alertPrompt();
    }
}
