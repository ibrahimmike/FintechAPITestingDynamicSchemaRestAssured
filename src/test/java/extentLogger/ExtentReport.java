package extentLogger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Date;

public class ExtentReport {


    private static ExtentTest test;
    private static ExtentReports extentReports;

    private static Date date;

    public static void extentInit() {


        extentReports = new ExtentReports();
        //  ExtentSparkReporter spark = new ExtentSparkReporter("src/main/java/cityfalcon/reports");

        ExtentSparkReporter spark = new ExtentSparkReporter(getReportsPath());

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("SauceLabsTest");
        spark.config().setReportName("First Report");
        extentReports.attachReporter(spark);

    }

    public static void createTest(String testName){
        test = extentReports.createTest(testName);
        ExtentManager.setTest(test);
    }

    public static void closeTest(){
        ExtentManager.removeTest();
        extentReports.flush();
//        try{
//          //  Desktop.getDesktop().browse(new File(Constants.getExtentReportPath()).toURI());
//        }catch(IOException e){
//            throw new RuntimeException("The file to the extent report cannot be created nor opened");
//        }
    }
    private static String getReportsPath(){

            date = new Date();
            return "extent-reports/" + date.toString()+".html";

    }





}
