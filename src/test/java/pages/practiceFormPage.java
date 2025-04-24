package pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import HelperMethods.JavascriptHelpers;
import HelperMethods.elementsMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class practiceFormPage {

    WebDriver driver;
    elementsMethod elementsMethods;
    JavascriptHelpers javascriptHelpers;


    public practiceFormPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new elementsMethod(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "firstName")
    WebElement firstNameElement;

    @FindBy(id = "lastName")
    WebElement lastNameElement;

    @FindBy(id = "userEmail")
    WebElement userEmailElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement genderMaleElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement genderFemaleElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement genderOtherElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement mobileNumberElement;

    @FindBy(id = "uploadPicture")
    WebElement uploadPictureElement;


    //For single subject entered we used xpath so that we could use Actions
//    @FindBy(xpath = "//div[@id='subjectsContainer']")
    //For multiple subject entered we used ID so that we cand send values directly without Actions
    @FindBy(id = "subjectsInput")
    WebElement subjectsInputElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportsBoxElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingBoxElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicBoxElement;

    @FindBy(id = "react-select-3-input")
    WebElement stateInputElement;

    @FindBy(id = "react-select-4-input")
    WebElement cityInputElement;

    @FindBy(id = "submit")
    WebElement submitActionElement;

    public void completefirstRegion(String firstName, String lastName, String userEmail, String mobileNumber) {

        elementsMethods.sendKeys(firstNameElement, firstName);
        elementsMethods.sendKeys(lastNameElement, lastName);
        elementsMethods.sendKeys(userEmailElement, userEmail);
        elementsMethods.sendKeys(mobileNumberElement, mobileNumber);
    }

    public void selectGender(String gender) {
        switch (gender) {
            case "male":
                genderMaleElement.click();
                break;
            case "female":
                genderFemaleElement.click();
                break;
            case "other":
                genderOtherElement.click();
                break;
        }
    }

    public void enterSubject(String subject) {
        elementsMethods.clickElements(subjectsInputElement);
        elementsMethods.fillWithActions(subjectsInputElement, subject);
    }

    // Different solution to handle multiple elements
//    public void enterSubjectsList(List<String> subjects) {
//        elementsMethods.clickElements(subjectsInputElement);
//        for (String subject : subjects) {
//            elementsMethods.fillWithActions(subjectsInputElement, subject);
//        }
//    }

    //Lesson 11 solution for handle multiple elements fill in
    public void enterSubjectsList(List<String> subjects) {
        elementsMethods.clickElements(subjectsInputElement);
        elementsMethods.fillMultipleValues(subjectsInputElement, subjects);
    }

    //Select only one hobby
    public void selectHobby(String hobby) {
        switch (hobby) {
            case "Sports":
                sportsBoxElement.click();
                break;
            case "Reading":
                readingBoxElement.click();
                break;
            case "Music":
                musicBoxElement.click();
                break;
        }
    }

    // Select multiple hobbies
    public void selectHobbies(List<String> hobbies) {
        for (String hobby : hobbies) {
            switch (hobby) {
                case "Sports":
                    sportsBoxElement.click();
                    break;
                case "Reading":
                    readingBoxElement.click();
                    break;
                case "Music":
                    musicBoxElement.click();
                    break;
            }
        }

    }

    public void selectState(String stateName) {
        javascriptHelpers.forceClick(stateInputElement);
        elementsMethods.sendKeys(stateInputElement, stateName);
        stateInputElement.sendKeys(Keys.ENTER);
    }

    public void selectCity(String cityName) {
        javascriptHelpers.forceClick(cityInputElement);
        elementsMethods.sendKeys(cityInputElement, cityName);
        cityInputElement.sendKeys(Keys.ENTER);
    }

    public void uploadPicture() {
        elementsMethods.uploadPicture(uploadPictureElement);
    }

    public void clickSubmitAction() {
        javascriptHelpers.forceClick(submitActionElement);
    }
}
