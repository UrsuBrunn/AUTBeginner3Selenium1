package tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import ObjectData.PracticeFormObject;
import PropertyUtility.PropertyUtility;
import SharedData.SharedData;
import pages.HomePage;
import pages.CommonPage;
import pages.practiceFormPage;

public class practiceFormTest extends SharedData {

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

//        List<String> subjectValues = new ArrayList<>();
//        subjectValues.add("Maths");
//        subjectValues.add("Social Studies");

        practiceFormPage.enterSubjectsList(practiceFormObject);
        // Different option with List directly in method use
//        practiceFormPage.enterSubjectsList(List.of("Maths", "Social Studies"));

        //Select one hobby
        //Select multiple hobbbies
        practiceFormPage.selectHobbies(practiceFormObject);

        practiceFormPage.selectState(practiceFormObject);

        practiceFormPage.selectCity(practiceFormObject);

        practiceFormPage.uploadPicture();

        practiceFormPage.clickSubmitAction();

//
//        List<WebElement> SubmittedFormElements = driver.findElements(By.xpath("//div[contains(@class, 'modal-body')]/div[@class='table-responsive']/table/tbody/tr/td"));
//        Integer actualSubmittedFormSize = SubmittedFormElements.size();
//
//        Assert.assertEquals(actualSubmittedFormSize, 20);
//
//        Assert.assertTrue(SubmittedFormElements.get(1).getText().contains("FormFirstNameInput1"));
//        Assert.assertTrue(SubmittedFormElements.get(1).getText().contains("FormLastNameInput1"));
//        Assert.assertTrue(SubmittedFormElements.get(3).getText().contains("FormUserEmailInput1@example.com"));
//        Assert.assertTrue(SubmittedFormElements.get(5).getText().contains("Female"));
//        Assert.assertTrue(SubmittedFormElements.get(7).getText().contains("0740123456"));
//        Assert.assertTrue(SubmittedFormElements.get(9).getText().contains("April,2025"));
//        Assert.assertTrue(SubmittedFormElements.get(11).getText().contains("Social Studies"));
//        System.out.println(SubmittedFormElements.get(15).getText());
//        Assert.assertTrue(SubmittedFormElements.get(15).getText().contains("dwcOly5.png"));
//        Assert.assertTrue(SubmittedFormElements.get(19).getText().contains("NCR"));
//        Assert.assertTrue(SubmittedFormElements.get(19).getText().contains("Delhi"));


    }
}
