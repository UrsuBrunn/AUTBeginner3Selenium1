package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class framesMethod {


    WebDriver driver;

    public framesMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void switchTo(WebElement element) {
        driver.switchTo().frame(element);
    }
}
