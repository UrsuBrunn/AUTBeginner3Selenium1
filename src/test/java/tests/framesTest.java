package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class framesTest {

    public WebDriver driver;

    @Test
    public void newFramesTest() {
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

        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        frameElement.click();

        WebElement bigFrameElement = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(bigFrameElement);

        WebElement sampleHeadingBigFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + sampleHeadingBigFrameElement.getText());
        Assert.assertTrue(sampleHeadingBigFrameElement.getText().contains("This is a sample page"));

        driver.switchTo().defaultContent();

        WebElement smallFrameElement = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(smallFrameElement);

        js.executeScript("window.scrollBy(200,400)");

        WebElement sampleHeadingSmallFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + sampleHeadingSmallFrameElement.getText());
        Assert.assertTrue(sampleHeadingSmallFrameElement.getText().contains("This is a sample page"));
    }
}
