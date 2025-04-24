package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.framesMethod;
import HelperMethods.windowsMethods;
import HelperMethods.JavascriptHelpers;
import pages.HomePage;
import pages.CommonPage;


public class browserWindowTab {

    public WebDriver driver;
    public elementsMethod elements;
    public framesMethod frames;
    public windowsMethods windows;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;

    @Test
    public void newBrowserTest() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();
        elements = new elementsMethod(driver);
        frames = new framesMethod(driver);
        windows = new windowsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);

        //  Accesam o pagina web
        driver.get("https://demoqa.com/");

        // Definim un wait implicit pt un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver
       //  declaram un element

        jsHelper.scrollDown(400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Browser Windows");

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        elements.clickElements(newTabElement);

        windows.switchToSecondTab();

        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul tab este: " + sampleHeadingElement.getText());

        windows.switchToMainTab();

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        elements.clickElements(newWindowElement);

        windows.switchToSecondTab();

        WebElement sampleHeadingElement2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + sampleHeadingElement2.getText());

        windows.switchToMainTab();
    }
}
