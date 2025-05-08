package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class webTablePage extends CommonPage {

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

    public webTablePage(WebDriver driver) {
        super(driver);
    }

    public void addInputsToTable(String firstName, String lastName, String userEmail, String age, String salary, String department) {

        elementsMethods.clickElements(addNewTableItemElement);
//        jsHelper.forceClick(userFormElement);


        elementsMethods.sendKeys(firstNameElement,firstName);
        elementsMethods.sendKeys(lastNameElement,lastName);
        elementsMethods.sendKeys(userEmailElement,userEmail);
        elementsMethods.sendKeys(ageElement,age);
        elementsMethods.sendKeys(salaryElement,salary);
        elementsMethods.sendKeys(departmentElement,department);
    }

    public void clickSubmitAction() {

        javascriptHelpers.forceClick(clickSubmitButtonElement);
    }


}
