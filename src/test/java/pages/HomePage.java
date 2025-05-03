package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import HelperMethods.elementsMethod;
import HelperMethods.JavascriptHelpers;

public class HomePage {

    WebDriver driver;
    elementsMethod elementsMethods;
    JavascriptHelpers javascriptHelpers;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new elementsMethod(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        PageFactory.initElements(driver, this);
    }
    // Identificam WebElementele specifice pentru pagina aceasta
    @FindBy(xpath = "//h5")
    List<WebElement> elements;
    //@findby(id = "//p[text()='Consent']")
    //WebElement consentElement;
    //

    // Facem metode specifice pentru pagina
    public void goToDesiredMenu(String menu) {
    //elementMethods.click(consent);
        javascriptHelpers.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements,menu);

    }

}
