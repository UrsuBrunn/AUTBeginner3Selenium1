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

public class practiceFormTest {

    public WebDriver driver;
    public elementsMethod elementsMethod;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;


    @Test
    public void newFormTest() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();
        elementsMethod = new elementsMethod(driver);
        homePage = new HomePage(driver);
        jsHelper = new JavascriptHelpers(driver);
        commonPage = new CommonPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //  Accesam o pagina web
        driver.get("https://demoqa.com/");

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver

        //List<WebElement> elements = driver.findElements(By.xpath("//h5"));
        homePage.goToDesiredMenu("Forms");
        commonPage.goToDesiredSubMenu("Practice Form");

        // Stating the Javascript Executor driver
        jsHelper.scrollDown(400);


        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        elementsMethod.sendKeys(firstNameElement, "FormFirstNameInput1");

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        elementsMethod.sendKeys(lastNameElement, "FormLastNameInput1");

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        elementsMethod.sendKeys(userEmailElement,"FormUserEmailInput1@example.com");

        WebElement genderMaleRadioButtonElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFemaleRadioButtonElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOtherRadioButtonElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        List<WebElement> genderElement = new ArrayList<WebElement>();
        genderElement.add(genderMaleRadioButtonElement);
        genderElement.add(genderFemaleRadioButtonElement);
        genderElement.add(genderOtherRadioButtonElement);

        elementsMethod.selectElementFromListByText(genderElement, "Female");

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementsMethod.sendKeys(phoneNumberElement, "0740123456");

        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
        elementsMethod.uploadPicture(uploadPictureElement);

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        elementsMethod.sendKeysEnter(subjectsElement, "Social Studies");

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click()",stateElement);
        elementsMethod.sendKeysEnter(stateElement, "NCR");


        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click()",cityElement);
        elementsMethod.sendKeysEnter(cityElement, "Delhi");

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click()",submitElement);

        List<WebElement> SubmittedFormElements = driver.findElements(By.xpath("//div[contains(@class, 'modal-body')]/div[@class='table-responsive']/table/tbody/tr/td"));
        Integer actualSubmittedFormSize = SubmittedFormElements.size();

        Assert.assertEquals(actualSubmittedFormSize, 20);

        Assert.assertTrue(SubmittedFormElements.get(1).getText().contains("FormFirstNameInput1"));
        Assert.assertTrue(SubmittedFormElements.get(1).getText().contains("FormLastNameInput1"));
        Assert.assertTrue(SubmittedFormElements.get(3).getText().contains("FormUserEmailInput1@example.com"));
        Assert.assertTrue(SubmittedFormElements.get(5).getText().contains("Female"));
        Assert.assertTrue(SubmittedFormElements.get(7).getText().contains("0740123456"));
        Assert.assertTrue(SubmittedFormElements.get(9).getText().contains("April,2025"));
        Assert.assertTrue(SubmittedFormElements.get(11).getText().contains("Social Studies"));
        System.out.println(SubmittedFormElements.get(15).getText());
        Assert.assertTrue(SubmittedFormElements.get(15).getText().contains("dwcOly5.png"));
        Assert.assertTrue(SubmittedFormElements.get(19).getText().contains("NCR"));
        Assert.assertTrue(SubmittedFormElements.get(19).getText().contains("Delhi"));


    }
}
