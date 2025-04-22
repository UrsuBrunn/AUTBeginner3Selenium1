package HelperMethods;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class windowsMethods {
    WebDriver driver;

    public windowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSecondTab() {
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
    }

    public void switchToMainTab() {
        driver.close();
        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(0));
    }
}
