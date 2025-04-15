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

public class browserWindowTab {

    public WebDriver driver;

    @Test
    public void newBrowserTest() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();

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
        alertFrameWindowElement.click();

        WebElement browserElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserElement.click();

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        newTabElement.click();

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));

        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul tab este: " + sampleHeadingElement.getText());

        driver.close();
        driver.switchTo().window(tabList.get(0));

        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
        newWindowElement.click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        WebElement sampleHeadingElement2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + sampleHeadingElement2.getText());
        driver.close();
        driver.switchTo().window(windowList.get(0));

        //Womework al treilea button de window - Solution still not working
//        WebElement messageWindowElement = driver.findElement(By.id("messageWindowButton"));
//        messageWindowElement.click();
//
//        List<String> windowMsgList = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windowMsgList.get(1));
//
//        WebElement newWindowMsgElement = driver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']"));
//        System.out.println("Textul din noul window este: " + newWindowMsgElement.getText());
    }
}
