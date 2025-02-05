package tests;

import java.util.List;
import javax.swing.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class practiceRecursivitate {

    public WebDriver driver;

    @Test
    public void parcurgereLista() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();

        //  Accesam o pagina web
        driver.get("https://demoqa.com/sortable");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

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
