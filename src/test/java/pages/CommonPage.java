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
import logger.LoggerUtility;

public class CommonPage {
    protected WebDriver driver;
    protected elementsMethod elementsMethods;
    protected JavascriptHelpers javascriptHelpers;
    protected alertsMethod alertsMethod;
    protected windowsMethods windowsMethods;
    protected framesMethod framesMethod;

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
        LoggerUtility.infoLog("The page is scrolled down the page ");
        elementsMethods.selectElementFromListByText(elements,submenu);
        LoggerUtility.infoLog("Selected option from the SubMenu is: " + submenu);

    }



}
