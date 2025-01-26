package tests;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        if (gender.equals("Male")) {
            genderMaleRadioButtonElement.click();
        }
        else if (gender.equals("Female")) {
            genderFemaleRadioButtonElement.click();
        }
        else if (gender.equals("Other")) {
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

    }
}
