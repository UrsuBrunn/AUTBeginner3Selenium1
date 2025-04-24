package HelperMethods;

import java.io.File;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementsMethod {

    WebDriver driver;
    Actions actions;

    public elementsMethod(WebDriver driver) {

        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void clickElements(WebElement element) {

        element.click();
    }

    public void sendKeys(WebElement element, String value) {
        waitElementVisibility(element);
        element.sendKeys(value);
    }

    public void sendKeysEnter(WebElement element, String value) {
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void uploadPicture(WebElement element) {
        File file = new File("src/test/resources/dwcOly5.png");
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementsList,String value) {
        for(int i = 0; i<elementsList.size(); i++){
            if(elementsList.get(i).getText().equals(value)){
                clickElements(elementsList.get(i));
                break;
            }
            //else {
            //          Throw an exception - Credits to Claudia Timis
            //throw new IllegalArgumentException("Invalid gender: " + value);
            //}
            //       driver.quit();
        }
    }

    public void fillWithActions(WebElement element, String value) {
        actions.sendKeys(value).build().perform();
        waitElementVisibility(element);
        actions.sendKeys(Keys.ENTER).build().perform();
        //merge si cu .build.perform()
    }

    public void waitElementVisibility(WebElement element) {
        //explicit wait for element visibility
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillMultipleValues(WebElement element, List<String> list) {
        for(String value: list){
//            fillWithActions(element, values);
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
       }
    }
}
