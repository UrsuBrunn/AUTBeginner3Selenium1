package tests;

import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import ObjectData.PracticeFormObject;
import PropertyUtility.PropertyUtility;
import SharedData.Hooks;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import pages.HomePage;
import pages.CommonPage;
import pages.practiceFormPage;

public class practiceFormTest extends Hooks {

    public elementsMethod elementsMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public practiceFormPage practiceFormPage;


    @Test
    public void newFormTest() {


        PropertyUtility propertyUtility = new PropertyUtility("practiceFormTest");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getData());


        //  Facem browserul in modul maximize
        elementsMethod = new elementsMethod(driver);
        homePage = new HomePage(driver);
        jsHelper = new JavascriptHelpers(driver);
        commonPage = new CommonPage(driver);
        practiceFormPage = new practiceFormPage(driver);

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver

        homePage.goToDesiredMenu("Forms");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user enters on Forms menu: ");
        commonPage.goToDesiredSubMenu("Practice Form");
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user enters on Practice Form submenu: ");

        // Stating the Javascript Executor driver
        jsHelper.scrollDown(400);

        practiceFormPage.completefirstRegion(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user fills in Region: ");
        practiceFormPage.selectGender(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user selects a Gender: ");

        practiceFormPage.enterSubjectsList(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user fills in Subjects: ");

        //Select multiple hobbbies
        practiceFormPage.selectHobbies(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user fills in Hobbies: ");

        practiceFormPage.selectState(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user fills in State: ");

        practiceFormPage.selectCity(practiceFormObject);
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user fills in City: ");

        practiceFormPage.uploadPicture();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user selects a picture to Upload : ");

        practiceFormPage.clickSubmitAction();
        ExtentUtility.attachLog(ReportStep.PASS_STEP, " The user SUbmit to Action button ");

    }
}
