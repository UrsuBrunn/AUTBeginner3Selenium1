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

public class alerteSiFerestre {

    public WebDriver driver;
    public elementsMethod elementsMethod;
    public alertsMethod alertsMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;

    @Test
    public void newAlertTest() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);

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

        elementsMethod = new elementsMethod(driver);
        alertsMethod = new alertsMethod(driver);

        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        elementsMethod.clickElements(alertOkElement);

        alertsMethod.interactWithAlertOk();

        WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethod.clickElements(alertDelayElement);

        alertsMethod.interactWithDelayAlert();

        WebElement alertMessageElement = driver.findElement(By.id("confirmButton"));
        elementsMethod.clickElements(alertMessageElement);

        alertsMethod.interactWithAlertDismiss();

        //Homework - check expected text for Cancel action
        WebElement confirmResultElement = driver.findElement(By.id("confirmResult"));
        Assert.assertTrue(confirmResultElement.getText().contains("You selected Cancel"));

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        elementsMethod.clickElements(alertPromptElement);

        alertsMethod.interactWithInputAlerts("Paul Gligan");

        //Homework, verifica numele scris corect pe Ok action
        WebElement promptResultElement = driver.findElement(By.id("promptResult"));
        Assert.assertTrue(promptResultElement.getText().contains("You entered " + "Paul Gligan"));
    }
}
