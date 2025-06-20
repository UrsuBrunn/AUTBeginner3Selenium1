package tests;

import org.testng.annotations.Test;
import HelperMethods.alertsMethod;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import pages.HomePage;
import pages.CommonPage;
import pages.alerteFerestrePage;

public class alerteSiFerestre extends Hooks {

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
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user enters on Alerts, Frames & Windows menu: ");
        commonPage.goToDesiredSubMenu("Alerts");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user selects Alerts sub-menu: ");

        alerteFerestrePage.showAlertOk();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user interacts with OK button for 1'st alert ");
        alerteFerestrePage.showAlertDelayed();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user interacts with delyed display of 2'nd alert ");
        alerteFerestrePage.alertMessageDismiss();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user interects by dismissing the alert");
        alerteFerestrePage.alertPrompt();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user interects by clicking on the alert Prompt: ");
    }
}
