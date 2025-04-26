package pages;

import org.openqa.selenium.WebDriver;
import HelperMethods.JavascriptHelpers;
import HelperMethods.elementsMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import HelperMethods.framesMethod;
import org.testng.Assert;

public class framesPage {
    WebDriver driver;
    elementsMethod elements;
    JavascriptHelpers js;
    framesMethod frames;

    public framesPage(WebDriver driver) {
        this.driver = driver;
        this.elements = new elementsMethod(driver);
        this.js = new JavascriptHelpers(driver);
        this.frames = new framesMethod(driver);
    }

    @FindBy(id = "frame1")
    WebElement bigFrameElement;

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    WebElement sampleHeadingFrameElement;

    @FindBy(id = "frame2")
    WebElement smallFrameElement;

    public void bigFrame() {
        frames.switchTo(bigFrameElement);
    }

    public void smallFrame() {
        frames.switchTo(smallFrameElement);
    }

}
