package tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import HelperMethods.elementsMethod;

public class practiceFormTest {

    public WebDriver driver;
    public elementsMethod elementsMethod;


    @Test
    public void newFormTest() {
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

        //  declaram lista elemente si alegem forms
        WebElement formsField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        WebElement elementsField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        WebElement alertsFramesWindowsField = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        WebElement widgetsField = driver.findElement(By.xpath("//h5[text()='Widgets']"));
        WebElement interactionsField = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        WebElement bookStoreField = driver.findElement(By.xpath("//h5[text()='Book Store Application']"));

        List<WebElement> mainMenuElement = new ArrayList<WebElement>();
        mainMenuElement.add(formsField);
        mainMenuElement.add(elementsField);
        mainMenuElement.add(alertsFramesWindowsField);
        mainMenuElement.add(widgetsField);
        mainMenuElement.add(interactionsField);
        mainMenuElement.add(bookStoreField);

        //elementsMethod.clickElementsFromListByText(mainMenuElement,"Forms"); -> Intreaba-l pe Nicolae de ce nu merge asta
        elementsMethod.clickElements(formsField);

        WebElement formsOptionElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementsMethod.clickElements(formsOptionElement);

           // Stating the Javascript Executor driver
        js.executeScript("window.scrollBy(0,400)");

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
        elementsMethod.sendKeys(subjectsElement, "Social Studies");
        //elementsMethod.sendKeys(Keys.ENTER);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click()",stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click()",cityElement);
        cityElement.sendKeys("Delhi");
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click()",submitElement);

        List<WebElement> SubmittedFormElements = driver.findElements(By.xpath("//div[contains(@class, 'modal-body')]/div[@class='table-responsive']/table/tbody/tr/td"));
        Integer actualSubmittedFormSize = SubmittedFormElements.size();

        Assert.assertEquals(actualSubmittedFormSize, 20);
        String birthDate = "27 February,2025";
        String pictureExpectedName = "dwcOly5.png";
        String stateExpected = "NCR";
        String cityExpected = "Delhi";

//        Assert.assertTrue(SubmittedFormElements.get(1).getText().contains(firstNameValue));
//        Assert.assertTrue(SubmittedFormElements.get(1).getText().contains(lastNameValue));
//        Assert.assertTrue(SubmittedFormElements.get(3).getText().contains(userEmailValue));
//        Assert.assertTrue(SubmittedFormElements.get(5).getText().contains(gender));
//        Assert.assertTrue(SubmittedFormElements.get(7).getText().contains(phoneNumber));
//        Assert.assertTrue(SubmittedFormElements.get(9).getText().contains(birthDate));
//        Assert.assertTrue(SubmittedFormElements.get(11).getText().contains(subjectsText));
//        System.out.println(SubmittedFormElements.get(15).getText());
////        The match on picture expected name dos not work as expected
//        Assert.assertTrue(SubmittedFormElements.get(15).getText().contains(pictureExpectedName));
//        Assert.assertTrue(SubmittedFormElements.get(19).getText().contains(stateExpected));
//        Assert.assertTrue(SubmittedFormElements.get(19).getText().contains(cityExpected));


    }
}
