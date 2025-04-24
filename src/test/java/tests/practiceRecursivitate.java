package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import HelperMethods.JavascriptHelpers;
import pages.HomePage;
import pages.CommonPage;
import HelperMethods.sortingMethod;

public class practiceRecursivitate {

    public WebDriver driver;
    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public sortingMethod sortingMethod;

    @Test
    public void parcurgereLista() {
        //  Deschidem un browser de chrome
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);
        sortingMethod = new sortingMethod(driver);

        //  Facem browserul in modul maximize
        driver.manage().window().maximize();

        //  Accesam pagina web de sortable
        driver.get("https://demoqa.com");

        jsHelper.scrollDown(400);

        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");

        sortingMethod.sortTable();

        }
    }
