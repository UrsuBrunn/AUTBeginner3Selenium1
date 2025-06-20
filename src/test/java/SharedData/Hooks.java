package SharedData;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import extentUtility.ExtentUtility;
import logger.LoggerUtility;
import static java.sql.DriverManager.getDriver;


public class Hooks extends SharedData{

    public String testName;

    @BeforeSuite
    public void intiateTestReport(){
        ExtentUtility.inititeReport();
    }

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestcase(testName);
        ExtentUtility.createTest(testName);
        prepareBrowser();
    }
    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            String errorMessage = result.getThrowable().getMessage();
            LoggerUtility.errorLog(errorMessage);
            ExtentUtility.attachLog(testName, errorMessage, getDriver());
        }
        clearBrowser();
        //pentru moment toate sunt bune
        LoggerUtility.endTestcase(testName);
        ExtentUtility.finishTest(testName);
    }

    @AfterSuite
    public void finalizeLogFiles(){
        LoggerUtility.mergeLogFilesIntoOne();
        ExtentUtility.generateReport();
    }
}
