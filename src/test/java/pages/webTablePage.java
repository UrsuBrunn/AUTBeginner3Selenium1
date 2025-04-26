package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import HelperMethods.JavascriptHelpers;
import HelperMethods.alertsMethod;
import HelperMethods.elementsMethod;
import org.openqa.selenium.support.PageFactory;


public class webTablePage {

    WebDriver driver;
    JavascriptHelpers jsHelper;
    alertsMethod alertsMethod;
    elementsMethod elementsMethod;


    public webTablePage(WebDriver driver) {
        this.driver = driver;
        this.jsHelper = new JavascriptHelpers(driver);
        this.alertsMethod = new alertsMethod(driver);
        this.elementsMethod = new elementsMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']")
    WebElement TableElements;

    @FindBy(id = "addNewRecordButton")
    WebElement addNewTableItemElement;

    @FindBy(id = "userForm")
    WebElement userFormElement;

    @FindBy(id = "firstName")
    WebElement firstNameElement;

    @FindBy(id = "lastName")
    WebElement lastNameElement;

    @FindBy(id = "userEmail")
    WebElement userEmailElement;

    @FindBy(id = "age")
    WebElement ageElement;

    @FindBy(id = "salary")
    WebElement salaryElement;

    @FindBy(id = "department")
    WebElement departmentElement;

    @FindBy(id = "submit")
    WebElement clickSubmitButtonElement;

    public void addInputsToTable(String firstName, String lastName, String userEmail, String age, String salary, String department) {

        elementsMethod.clickElements(addNewTableItemElement);
//        jsHelper.forceClick(userFormElement);


        elementsMethod.sendKeys(firstNameElement,firstName);
        elementsMethod.sendKeys(lastNameElement,lastName);
        elementsMethod.sendKeys(userEmailElement,userEmail);
        elementsMethod.sendKeys(ageElement,age);
        elementsMethod.sendKeys(salaryElement,salary);
        elementsMethod.sendKeys(departmentElement,department);
    }

    public void clickSubmitAction() {

        jsHelper.forceClick(clickSubmitButtonElement);
    }


}
