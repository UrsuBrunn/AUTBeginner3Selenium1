package tests;

import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import ObjectData.PracticeFormObject;
import PropertyUtility.PropertyUtility;
import SharedData.Hooks;
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
        commonPage.goToDesiredSubMenu("Practice Form");

        // Stating the Javascript Executor driver
        jsHelper.scrollDown(400);

        practiceFormPage.completefirstRegion(practiceFormObject);
        practiceFormPage.selectGender(practiceFormObject);

        practiceFormPage.enterSubjectsList(practiceFormObject);

        //Select multiple hobbbies
        practiceFormPage.selectHobbies(practiceFormObject);

        practiceFormPage.selectState(practiceFormObject);

        practiceFormPage.selectCity(practiceFormObject);

        practiceFormPage.uploadPicture();

        practiceFormPage.clickSubmitAction();

    }
}
