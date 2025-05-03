package tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
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

        practiceFormPage.completefirstRegion("Region1FirstName", "Region1LastName","Region1email@email.com","0740123456");
        practiceFormPage.selectGender("female");

        List<String> subjectValues = new ArrayList<>();
        subjectValues.add("Maths");
        subjectValues.add("Social Studies");

        practiceFormPage.enterSubjectsList(subjectValues);
        // Different option with List directly in method use
//        practiceFormPage.enterSubjectsList(List.of("Maths", "Social Studies"));

        //Select one hobby
        practiceFormPage.selectHobby("Sports");

        //Select multiple hobbbies
        practiceFormPage.selectHobbies(List.of("Music","Reading"));

        practiceFormPage.selectState("NCR");

        practiceFormPage.selectCity("Delhi");

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
