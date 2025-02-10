package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class webTableTests {

    public WebDriver driver;

    @Test
    public void autMethod() {
//  Deschidem un browser de chrome
        driver = new ChromeDriver();
//  Facem browserul in modul maximize
        driver.manage().window().maximize();
//  Accesam o pagina web
        driver.get("https://demoqa.com/");

//  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
// Stating the Javascript Executor driver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

//  declaram un element
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementsField.click();

        WebElement webTableElement = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTableElement.click();

        List<WebElement> TableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Integer actualTableSize = TableElements.size();


        WebElement addNewTableItemElement = driver.findElement(By.id("addNewRecordButton"));
        addNewTableItemElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "FirsNameInput1";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "LastNameInput1";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "userEmailInput1@example.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "33";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "10000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "Deprtement1";
        departmentElement.sendKeys(departmentValue);

        WebElement clickSubmitButtonElement = driver.findElement(By.id("submit"));
        clickSubmitButtonElement.click();

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
