package tests;

import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.framesMethod;
import HelperMethods.JavascriptHelpers;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import pages.HomePage;
import pages.CommonPage;
import pages.framesPage;

public class framesTest extends Hooks {

    public elementsMethod elementsMethod;
    public framesMethod framesMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public framesPage framesPage;

    @Test
    public void newFramesTest() {

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();
        elementsMethod = new elementsMethod(driver);
        framesMethod = new framesMethod(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);
        framesPage = new framesPage(driver);

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver
        jsHelper.scrollDown(400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user enters on Alerts, Frames & Windows menu: ");
        commonPage.goToDesiredSubMenu("Frames");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user enters on Frames sub-menu: ");
        framesPage.bigFrame();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user interacts with the first iFrame ");
        driver.switchTo().defaultContent();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user switches focus to default content ");
        framesPage.smallFrame();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user interacts with small frame ");


//        WebElement bigFrameElement = driver.findElement(By.id("frame1"));
//        framesMethod.switchTo(bigFrameElement);
//
//
//        WebElement sampleHeadingBigFrameElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din noul window este: " + sampleHeadingBigFrameElement.getText());
//        Assert.assertTrue(sampleHeadingBigFrameElement.getText().contains("This is a sample page"));
//
//        driver.switchTo().defaultContent();
//
//        WebElement smallFrameElement = driver.findElement(By.id("frame2"));
//        framesMethod.switchTo(smallFrameElement);
//
//        jsHelper.scroll(200,400);
//
//        WebElement sampleHeadingSmallFrameElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din noul window este: " + sampleHeadingSmallFrameElement.getText());
//        Assert.assertTrue(sampleHeadingSmallFrameElement.getText().contains("This is a sample page"));
    }
}
