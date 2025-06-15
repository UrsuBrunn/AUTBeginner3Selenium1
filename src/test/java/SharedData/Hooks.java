package SharedData;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import logger.LoggerUtility;

public class Hooks extends SharedData{

    public String testName;

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestcase(testName);

        prepareBrowser();
    }
    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        clearBrowser();
        //pentru moment toate sunt bune
        LoggerUtility.endTestcase(testName);
    }

    @AfterSuite
    public void finalizeLogFiles(){
        LoggerUtility.mergeLogFilesIntoOne();
    }
}
