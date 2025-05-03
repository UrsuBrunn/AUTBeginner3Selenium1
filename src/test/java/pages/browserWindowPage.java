package pages;

import org.openqa.selenium.WebDriver;
import HelperMethods.JavascriptHelpers;
import HelperMethods.elementsMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import HelperMethods.windowsMethods;
import HelperMethods.framesMethod;

public class browserWindowPage extends CommonPage {

    @FindBy(id = "tabButton")
    WebElement newTabElement;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingElement;
    @FindBy(id = "windowButton")
    WebElement newWindowElement;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingElement2;

    public browserWindowPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewTab() {
        elementsMethods.clickElements(newTabElement);
        windowsMethods.switchToSecondTab();
    }

    public void clickWindowedTab() {
        elementsMethods.clickElements(newWindowElement);
        windowsMethods.switchToSecondTab();
    }




}
