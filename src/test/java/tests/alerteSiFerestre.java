package tests;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class alerteSiFerestre {

    public WebDriver driver;

    @Test
    public void newAlertTest() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();

        //  Accesam o pagina web
        driver.get("https://demoqa.com/");

        // Definim un wait implicit pt un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  Initializam utilizarea de Java script si aplicam un java script pt scroll to bottom
        // Stating the Javascript Executor driver
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //  declaram un element
        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertElement.click();

        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        alertOkElement.click();

        Alert alertOK = driver.switchTo().alert();
        //Ne mutam cu focusul pe alerta

        alertOK.accept();

        WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
        alertDelayElement.click();

        // definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertDelay = driver.switchTo().alert();

        alertDelay.accept();

        WebElement alertMessageElement = driver.findElement(By.id("confirmButton"));
        alertMessageElement.click();

        Alert alertConfirmationMessage = driver.switchTo().alert();
        //Ne mutam cu focusul pe alerta

        alertConfirmationMessage.dismiss();

        //Homework - check expected text for Cancel action
        WebElement confirmResultElement = driver.findElement(By.id("confirmResult"));
        Assert.assertTrue(confirmResultElement.getText().contains("You selected Cancel"));

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        alertPromptElement.click();

        Alert alertPrompt = driver.switchTo().alert();
        //Ne mutam cu focusul pe alerta

        String personalName = "Paul Gligan";
        alertPrompt.sendKeys(personalName);

        alertPrompt.accept();

        //Homework, verifica numele scris corect pe Ok action
        WebElement promptResultElement = driver.findElement(By.id("promptResult"));
        Assert.assertTrue(promptResultElement.getText().contains("You entered " + personalName));
    }
}
