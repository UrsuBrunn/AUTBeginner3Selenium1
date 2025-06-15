package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;
import logger.LoggerUtility;

public class HomePage extends CommonPage {

    // Identificam WebElementele specifice pentru pagina aceasta
    @FindBy(xpath = "//h5")
    List<WebElement> elements;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //@findby(id = "//p[text()='Consent']")
    //WebElement consentElement;
    //

    // Facem metode specifice pentru pagina
    public void goToDesiredMenu(String menu) {
    //elementMethods.click(consent);
        javascriptHelpers.scrollDown(400);
        LoggerUtility.infoLog("The page is scrolled down the page ");
        elementsMethods.selectElementFromListByText(elements,menu);
        LoggerUtility.infoLog("Selected option from the Menu is: " + menu);

    }

}
