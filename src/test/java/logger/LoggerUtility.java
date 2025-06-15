package logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LoggerUtility {

    //pathul unde voi salva fisierele de loguri

    private static final String suiteLogsPath = "target/logs/suite/";

    //pathul unde voi genera fisierul mare cu toate logurile

    private static final String regressionLogsPath = "target/logs/";



    private static final Logger logger = LogManager.getLogger(LoggerUtility.class.getName());

    //vreau sa fac o metoda care se asigura ca porneste un test
    public static synchronized void startTestcase(String testName) {
        ThreadContext.put("threadName", testName);
        logger.info("========= Execution started: " + testName + "=========");
    }
    // ca a terminat un test
    public static synchronized void endTestcase(String testName) {
        logger.info("========= Execution ended: " + testName + "=========");
    }
    // ca adauga un entry ca log
    public static synchronized void infoLog(String message) {
        logger.info(Thread.currentThread().getName() + ": " + getCallInfo() + message);
    }
    // ca logheaza o eroare
    public static synchronized void errorLog(String message) {
        logger.error(Thread.currentThread().getName() + ": " + getCallInfo() + message);
    }
    //  metoda care sa scoata ainformatii despre executia curenta
    private static synchronized String getCallInfo() {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return className + ":" + methodName + " ==> ";
    }
    // metoda care ia toate logurile si le pune intr-uu singur fisier
    public static void mergeLogFilesIntoOne() {
        // create instance of directory
        File dir = new File(suiteLogsPath);
        // Get list of all the files in form of String Array
        String[] fileNames = dir.list();

        try {
            PrintWriter pw = new PrintWriter(regressionLogsPath + " RegressionLogs.log ");

            for (String fileName : fileNames) {
                System.out.println("Reading from " + fileName);
                File f = new File(dir, fileName);
                BufferedReader br = new BufferedReader(new FileReader(f));
                pw.println("Contents of file " + fileName);
                String line = br.readLine();
                while (line != null) {
                    pw.println(line);
                    line = br.readLine();
                }
                pw.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
