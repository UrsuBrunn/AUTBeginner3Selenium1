package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.framesMethod;
import HelperMethods.windowsMethods;


public class browserWindowTab {

    public WebDriver driver;
    public elementsMethod elements;
    public framesMethod frames;
    public windowsMethods windows;

    @Test
    public void newBrowserTest() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();
        elements = new elementsMethod(driver);
        frames = new framesMethod(driver);
        windows = new windowsMethods(driver);

        //  Accesam o pagina web
        driver.get("https://demoqa.com/");

        // Definim un wait implicit pt un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //  declaram un element
        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elements.clickElements(alertFrameWindowElement);

        WebElement browserElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        elements.clickElements(browserElement);

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
