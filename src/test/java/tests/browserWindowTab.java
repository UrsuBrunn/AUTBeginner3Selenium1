package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.framesMethod;
import HelperMethods.windowsMethods;
import HelperMethods.JavascriptHelpers;
import SharedData.Hooks;
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
        commonPage.goToDesiredSubMenu("Browser Windows");

        browserWindowPage.clickNewTab();

        windows.switchToMainTab();

        browserWindowPage.clickWindowedTab();

        WebElement sampleHeadingElement2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din noul window este: " + sampleHeadingElement2.getText());

        windows.switchToMainTab();
    }
}
