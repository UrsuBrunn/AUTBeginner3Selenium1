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

public class webTableTests {

    public WebDriver driver;
    public elementsMethod elementsMethod;

    @Test
    public void autMethod() {
//  Deschidem un browser de chrome
        driver = new ChromeDriver();
//  Facem browserul in modul maximize
        driver.manage().window().maximize();
        elementsMethod = new elementsMethod(driver);

//  Accesam o pagina web
        driver.get("https://demoqa.com/");

//  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
// Stating the Javascript Executor driver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

//  declaram lista elemente si alegem Elements
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));

        List<WebElement> mainMenuElement = new ArrayList<WebElement>();
        mainMenuElement.add(elementsField);

        elementsMethod.clickElements(elementsField);

        WebElement webTableElement = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        elementsMethod.clickElements(webTableElement);

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
