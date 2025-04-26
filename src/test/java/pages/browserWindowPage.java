package pages;

import org.openqa.selenium.WebDriver;
import HelperMethods.JavascriptHelpers;
import HelperMethods.elementsMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import HelperMethods.windowsMethods;
import HelperMethods.framesMethod;

public class browserWindowPage {

    WebDriver driver;
    elementsMethod elementsMethods;
    JavascriptHelpers javascriptHelpers;
    windowsMethods windowsMethods;
    framesMethod framesMethod;

    public browserWindowPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new elementsMethod(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        this.windowsMethods = new windowsMethods(driver);
        this.framesMethod = new framesMethod(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    WebElement newTabElement;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingElement;
    @FindBy(id = "windowButton")
    WebElement newWindowElement;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingElement2;

    public void clickNewTab() {
        elementsMethods.clickElements(newTabElement);
        windowsMethods.switchToSecondTab();
    }

    public void clickWindowedTab() {
        elementsMethods.clickElements(newWindowElement);
        windowsMethods.switchToSecondTab();
    }




}
