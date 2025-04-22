package HelperMethods;

import java.io.File;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class elementsMethod {

    WebDriver driver;

    public elementsMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElements(WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String value) {
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
            }
            //else {
            ////          Throw an exception - Credits to Claudia Timis
            //throw new IllegalArgumentException("Invalid gender: " + value);
            //}
            ////        driver.quit();

        }
    }



}
