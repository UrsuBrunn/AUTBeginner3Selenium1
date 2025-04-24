package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.framesMethod;
import HelperMethods.JavascriptHelpers;
import pages.HomePage;
import pages.CommonPage;

public class framesTest {

    public WebDriver driver;
    public elementsMethod elementsMethod;
    public framesMethod framesMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;

    @Test
    public void newFramesTest() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();
        elementsMethod = new elementsMethod(driver);
        framesMethod = new framesMethod(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);

        //  Accesam o pagina web
        driver.get("https://demoqa.com/");

        // Definim un wait implicit pt un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver
        jsHelper.scrollDown(400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Frames");

        WebElement bigFrameElement = driver.findElement(By.id("frame1"));
        framesMethod.switchTo(bigFrameElement);


        WebElement sampleHeadingBigFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + sampleHeadingBigFrameElement.getText());
        Assert.assertTrue(sampleHeadingBigFrameElement.getText().contains("This is a sample page"));

        driver.switchTo().defaultContent();

        WebElement smallFrameElement = driver.findElement(By.id("frame2"));
        framesMethod.switchTo(smallFrameElement);

        jsHelper.scroll(200,400);

        WebElement sampleHeadingSmallFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + sampleHeadingSmallFrameElement.getText());
        Assert.assertTrue(sampleHeadingSmallFrameElement.getText().contains("This is a sample page"));
    }
}
