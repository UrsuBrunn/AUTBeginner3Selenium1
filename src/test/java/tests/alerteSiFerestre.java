package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import HelperMethods.alertsMethod;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import SharedData.SharedData;
import pages.HomePage;
import pages.CommonPage;
import pages.alerteFerestrePage;

public class alerteSiFerestre extends SharedData {

    public elementsMethod elementsMethod;
    public alertsMethod alertsMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public alerteFerestrePage alerteFerestrePage;

    @Test
    public void newAlertTest() {
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);
        elementsMethod = new elementsMethod(driver);
        alertsMethod = new alertsMethod(driver);
        alerteFerestrePage = new alerteFerestrePage(driver);


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
