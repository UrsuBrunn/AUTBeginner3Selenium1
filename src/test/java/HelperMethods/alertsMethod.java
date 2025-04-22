package HelperMethods;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertsMethod {

    WebDriver driver;

    public alertsMethod(WebDriver driver) {
        this.driver = driver;
    }
    public void interactWithAlertOk() {
        Alert alertOK = driver.switchTo().alert();
        //Ne mutam cu focusul pe alerta
        alertOK.accept();
    }

    public void explicitAlert() {
        // definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void interactWithDelayAlert() {
        explicitAlert();
        Alert alertDelay = driver.switchTo().alert();
        alertDelay.accept();
    }

    public void interactWithAlertDismiss() {
        Alert alertOK = driver.switchTo().alert();
        //Ne mutam cu focusul pe alerta
        alertOK.dismiss();
    }

    public void interactWithInputAlerts(String personalName) {
        Alert alertPrompt = driver.switchTo().alert();
        //Ne mutam cu focusul pe alerta

        //String personalName = "Paul Gligan";
        alertPrompt.sendKeys(personalName);

        alertPrompt.accept();

    }
}
