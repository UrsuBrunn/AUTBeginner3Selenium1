package tests;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import pages.HomePage;
import pages.CommonPage;

public class webTableTests {

    public WebDriver driver;
    public elementsMethod elementsMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;

    @Test
    public void autMethod() {
//  Deschidem un browser de chrome
        driver = new ChromeDriver();
//  Facem browserul in modul maximize
        driver.manage().window().maximize();
        elementsMethod = new elementsMethod(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);

//  Accesam o pagina web
        driver.get("https://demoqa.com/");

//  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
// Stating the Javascript Executor driver
        jsHelper.scrollDown(400);

//  declaram lista elemente si alegem Elements

        homePage.goToDesiredMenu("Elements");
        commonPage.goToDesiredSubMenu("Web Tables");

        List<WebElement> TableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = TableElements.size();

        WebElement addNewTableItemElement = driver.findElement(By.id("addNewRecordButton"));
        elementsMethod.clickElements(addNewTableItemElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "FirsNameInput1";
        elementsMethod.sendKeys(firstNameElement,firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "LastNameInput1";
        elementsMethod.sendKeys(lastNameElement,lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "userEmailInput1@example.com";
        elementsMethod.sendKeys(userEmailElement,userEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "33";
        elementsMethod.sendKeys(ageElement,ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "10000";
        elementsMethod.sendKeys(salaryElement,salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "Deprtement1";
        elementsMethod.sendKeys(departmentElement,departmentValue);

        WebElement clickSubmitButtonElement = driver.findElement(By.id("submit"));
        elementsMethod.clickElements(clickSubmitButtonElement);

        List<WebElement> ExpectedTableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize + 1;
        Assert.assertEquals(expectedTableSize, ExpectedTableElements.size());

        String actualTableValue = ExpectedTableElements.get(3).getText();
        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(userEmailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departmentValue));


    }

}
