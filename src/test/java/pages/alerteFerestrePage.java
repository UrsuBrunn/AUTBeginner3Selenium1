package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import HelperMethods.JavascriptHelpers;
import HelperMethods.alertsMethod;
import HelperMethods.elementsMethod;

public class alerteFerestrePage extends CommonPage{

    @FindBy(id = "alertButton")
    WebElement alertOkElement;

    @FindBy(id = "timerAlertButton")
    WebElement alertDelayElement;

    @FindBy(id = "confirmButton")
    WebElement alertMessageElement;

    @FindBy(id = "confirmResult")
    WebElement confirmResultElement;

    @FindBy(id = "promtButton")
    WebElement alertPromptElement;

    @FindBy(id = "promptResult")
    WebElement promptResultElement;

    public alerteFerestrePage(WebDriver driver) {
        super(driver);
    }

    public void showAlertOk() {
//        javascriptHelpers.forceClick(alertOkElement);
        elementsMethods.clickElements(alertOkElement);
        alertsMethod.interactWithAlertOk();
    }

    public void showAlertDelayed() {
        elementsMethods.clickElements(alertDelayElement);
        alertsMethod.interactWithDelayAlert();
    }

    public void alertMessageDismiss() {
        elementsMethods.clickElements(alertMessageElement);
        alertsMethod.interactWithAlertDismiss();
        Assert.assertTrue(confirmResultElement.getText().contains("You selected Cancel"));
    }

    public void alertPrompt() {
        elementsMethods.clickElements(alertPromptElement);
        alertsMethod.interactWithInputAlerts("Paul Gligan");
        Assert.assertTrue(promptResultElement.getText().contains("You entered " + "Paul Gligan"));
    }

}
