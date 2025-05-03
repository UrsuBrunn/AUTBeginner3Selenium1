package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import HelperMethods.JavascriptHelpers;
import HelperMethods.elementsMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import HelperMethods.framesMethod;
import org.testng.Assert;

public class framesPage extends CommonPage{

    @FindBy(id = "frame1")
    WebElement bigFrameElement;

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    WebElement sampleHeadingFrameElement;

    @FindBy(id = "frame2")
    WebElement smallFrameElement;

    public framesPage(WebDriver driver) {
        super(driver);
    }

    public void bigFrame() {
//        frames.switchTo(bigFrameElement);
        driver.switchTo().frame(bigFrameElement);
        WebElement sampleHeadingBigFrameElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println("Textul din noul window este: " + sampleHeadingBigFrameElement.getText());
        Assert.assertTrue(sampleHeadingBigFrameElement.getText().contains("This is a sample page"));
    }

    public void smallFrame() {
        framesMethod.switchTo(smallFrameElement);
        WebElement sampleHeadingBigFrameElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        System.out.println("Textul din noul window este: " + sampleHeadingBigFrameElement.getText());
        Assert.assertTrue(sampleHeadingBigFrameElement.getText().contains("This is a sample page"));
    }

}
