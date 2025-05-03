package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import HelperMethods.JavascriptHelpers;
import HelperMethods.alertsMethod;
import HelperMethods.elementsMethod;
import HelperMethods.framesMethod;
import HelperMethods.windowsMethods;

public class CommonPage {
    WebDriver driver;
    elementsMethod elementsMethods;
    JavascriptHelpers javascriptHelpers;
    alertsMethod alertsMethod;
    windowsMethods windowsMethods;
    framesMethod framesMethod;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new elementsMethod(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        this.alertsMethod = new alertsMethod(driver);
        this.windowsMethods = new windowsMethods(driver);
        this.framesMethod = new framesMethod(driver);
        PageFactory.initElements(driver, this);

    }
    // Identificam WebElementele specifice pentru sub-pagini
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elements;

    // Facem metode specifice pentru pagina
    public void goToDesiredSubMenu(String submenu) {
        javascriptHelpers.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements,submenu);

    }



}
