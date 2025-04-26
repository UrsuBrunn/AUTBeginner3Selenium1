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
import pages.webTablePage;

public class webTableTests {

    public WebDriver driver;
    public elementsMethod elementsMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public webTablePage webTablePage;

    @Test
    public void autMethod() {
//  Deschidem un browser de chrome
        driver = new ChromeDriver();
//  Facem browserul in modul maximize
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);
        webTablePage = new webTablePage(driver);
        elementsMethod = new elementsMethod(driver);

//  Accesam o pagina web
        driver.get("https://demoqa.com/");

//  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
// Stating the Javascript Executor driver
        jsHelper.scrollDown(400);

//  declaram lista elemente si alegem Elements

        homePage.goToDesiredMenu("Elements");
        commonPage.goToDesiredSubMenu("Web Tables");
        jsHelper.scrollDown(400);

        webTablePage.addInputsToTable("FirsNameInput1","LastNameInput1","userEmailInput1@example.com","33","10000","Deprtement1");
        webTablePage.clickSubmitAction();


//        Integer expectedTableSize = actualTableSize + 1;
//        Assert.assertEquals(expectedTableSize, TableElements.size());
//
//        String actualTableValue = TableElements.get(3).getText();
//        Assert.assertTrue(actualTableValue.contains(firstNameValue));
//        Assert.assertTrue(actualTableValue.contains(lastNameValue));
//        Assert.assertTrue(actualTableValue.contains(userEmailValue));
//        Assert.assertTrue(actualTableValue.contains(ageValue));
//        Assert.assertTrue(actualTableValue.contains(salaryValue));
//        Assert.assertTrue(actualTableValue.contains(departmentValue));


    }

}
