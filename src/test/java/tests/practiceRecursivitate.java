package tests;

import org.testng.annotations.Test;
import HelperMethods.JavascriptHelpers;
import SharedData.Hooks;
import pages.HomePage;
import pages.CommonPage;
import HelperMethods.sortingMethod;

public class practiceRecursivitate extends Hooks {

    public HomePage homePage;
    public JavascriptHelpers jsHelper;
    public CommonPage commonPage;
    public sortingMethod sortingMethod;

    @Test
    public void parcurgereLista() {
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        jsHelper = new JavascriptHelpers(driver);
        sortingMethod = new sortingMethod(driver);

        jsHelper.scrollDown(400);

        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");

        sortingMethod.sortTable();

        }
    }
