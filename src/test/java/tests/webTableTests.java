package tests;

import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import pages.HomePage;
import pages.CommonPage;
import pages.webTablePage;

public class webTableTests extends Hooks {

    public elementsMethod elementsMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public webTablePage webTablePage;

    @Test
    public void autMethod() {
//  Facem browserul in modul maximize
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);
        webTablePage = new webTablePage(driver);
        elementsMethod = new elementsMethod(driver);
        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
// Stating the Javascript Executor driver
        jsHelper.scrollDown(400);

//  declaram lista elemente si alegem Elements

        homePage.goToDesiredMenu("Elements");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user selects the Elements menu : ");
        commonPage.goToDesiredSubMenu("Web Tables");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user selects the Web tables submenu : ");
        jsHelper.scrollDown(400);

        webTablePage.addInputsToTable("FirsNameInput1","LastNameInput1","userEmailInput1@example.com","33","10000","Deprtement1");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user fills in data for displayed fields in the table : ");
        webTablePage.clickSubmitAction();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user selects SubmitToAction button: ");

    }

}
