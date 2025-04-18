package tests;

import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practiceFormTest {

    public WebDriver driver;

    @Test
    public void newFormTest() {
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
        WebElement formsField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formsField.click();

        WebElement formsOptionElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        formsOptionElement.click();

           // Stating the Javascript Executor driver
        js.executeScript("window.scrollBy(0,400)");

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "FormFirstNameInput1";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "FormLastNameInput1";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "FormUserEmailInput1@example.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement genderMaleRadioButtonElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFemaleRadioButtonElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOtherRadioButtonElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String gender = "Other";

        if (genderMaleRadioButtonElement.getText().equals(gender)) {
            genderMaleRadioButtonElement.click();
        }
        else if (genderFemaleRadioButtonElement.getText().equals(gender)) {
            genderFemaleRadioButtonElement.click();
        }
        else if (genderOtherRadioButtonElement.getText().equals(gender)) {
            genderOtherRadioButtonElement.click();
        }
        else {
//          Throw an exception - Credits to Claudia Timis
            throw new IllegalArgumentException("Invalid gender: " + gender);
             }
//        driver.quit();

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String phoneNumber = "0740123456";
        phoneNumberElement.sendKeys(phoneNumber);

        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/dwcOly5.png");
        uploadPictureElement.sendKeys(file.getAbsolutePath());

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        String subjectsText = "Social Studies";
        subjectsElement.sendKeys(subjectsText);
        subjectsElement.sendKeys(Keys.ENTER);

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

        Assert.assertTrue(SubmittedFormElements.get(1).getText().contains(firstNameValue));
        Assert.assertTrue(SubmittedFormElements.get(1).getText().contains(lastNameValue));
        Assert.assertTrue(SubmittedFormElements.get(3).getText().contains(userEmailValue));
        Assert.assertTrue(SubmittedFormElements.get(5).getText().contains(gender));
        Assert.assertTrue(SubmittedFormElements.get(7).getText().contains(phoneNumber));
        Assert.assertTrue(SubmittedFormElements.get(9).getText().contains(birthDate));
        Assert.assertTrue(SubmittedFormElements.get(11).getText().contains(subjectsText));
        System.out.println(SubmittedFormElements.get(15).getText());
//        The match on picture expected name dos not work as expected
        Assert.assertTrue(SubmittedFormElements.get(15).getText().contains(pictureExpectedName));
        Assert.assertTrue(SubmittedFormElements.get(19).getText().contains(stateExpected));
        Assert.assertTrue(SubmittedFormElements.get(19).getText().contains(cityExpected));


    }
}
