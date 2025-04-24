package HelperMethods;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class sortingMethod {
    WebDriver driver;

    public sortingMethod(WebDriver driver) {
        this.driver = driver;
    }

    public void sortTable() {

        Actions actions = new Actions(driver);

        List<WebElement> list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i = 0; i < list.size()-1; i++) {
            WebElement el = list.get(i);
            WebElement el2 = list.get(i++);

            System.out.println("Numarul elementului e: " + el.getText());
            actions.clickAndHold(el)
                    .moveToElement(el2)
                    .release()
                    .build()
                    .perform();
        }
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
