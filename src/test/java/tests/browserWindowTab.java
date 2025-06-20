package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.framesMethod;
import HelperMethods.windowsMethods;
import HelperMethods.JavascriptHelpers;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import pages.HomePage;
import pages.CommonPage;
import pages.browserWindowPage;


public class browserWindowTab extends Hooks {

    public elementsMethod elements;
    public framesMethod frames;
    public windowsMethods windows;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public browserWindowPage browserWindowPage;

    @Test
    public void newBrowserTest() {

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();
        elements = new elementsMethod(driver);
        frames = new framesMethod(driver);
        windows = new windowsMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        browserWindowPage = new browserWindowPage(driver);

        jsHelper = new JavascriptHelpers(driver);

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver
       //  declaram un element

        jsHelper.scrollDown(400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user enters on Alerts, Frames & Windows menu: ");
        commonPage.goToDesiredSubMenu("Browser Windows");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user selects Browser Windows sub-menu: ");

        browserWindowPage.clickNewTab();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user selects the new tab window: ");

        windows.switchToMainTab();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user changes focus back to Main tab ");

        browserWindowPage.clickWindowedTab();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user moves focus to windowed tab: ");

        WebElement sampleHeadingElement2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + sampleHeadingElement2.getText());

        windows.switchToMainTab();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user changes focus back to Main tab ");
    }
}
