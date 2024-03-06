package base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BasePage
{
    public static ExtentReports extentReports;
    public static String extentReportPrefix;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public ExtentManager() throws IOException {
        super();
    }

    public static ExtentReports getReport()
    {
        if(extentReports == null){
            setupExtentReport("Roi Live Project");
        }
        return extentReports;
    }

    private static ExtentReports setupExtentReport(String testName) 
    {
        extentReports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(
            System.getProperty("user.dir") 
            + "/reports/" 
            + extentReportsPrefix_Name(testName) 
            + ".html");

        System.out.println( System.getProperty("user.dir") 
        + "/report/" 
        + extentReportsPrefix_Name(testName) 
        + ".html");

        extentReports.attachReporter(spark);
        extentReports.setSystemInfo("Tester", "Roi");
        spark.config().setReportName("Live Project - Regression");
        spark.config().setDocumentTitle("Regression Results");
        spark.config().setTheme(Theme.STANDARD);

        return extentReports;
    }

    private static String extentReportsPrefix_Name(String testName) 
    {
        String date = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        extentReportPrefix = testName + " " + date;

        return extentReportPrefix;
    }

    public static void flushReport()
    {
        extentReports.flush();
    }

    public synchronized static ExtentTest getTest()
    {
        return extentTest.get();
    }

    public synchronized static ExtentTest createTest(String name, String desc)
    {
        ExtentTest test = extentReports.createTest(name, desc);
        extentTest.set(test);
        return getTest();
    }

    public synchronized static void log(String message)
    {
        getTest().info(message);
    }

    public synchronized static void pass(String message)
    {
        getTest().pass(message);
    }

    public synchronized static void fail(String message)
    {
        getTest().fail(message);   
    }

    public synchronized static void attachImage()
    {
        getTest().addScreenCaptureFromPath(getScreenshotPath());
    }
}
