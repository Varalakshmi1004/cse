package BasePkg;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
    public static EdgeDriver driver;
    public static ExtentSparkReporter htmlReport;
    public static ExtentReports report;
    public static ExtentTest test;
    public static Properties properties = new Properties();
    public static FileInputStream input;

    
    //To set up the report
    public static void reportSetUp() {
        htmlReport = new ExtentSparkReporter(new File("C:\\Users\\VaralakshmiB\\Desktop\\Report\\practo.html"));
        report = new ExtentReports();
        htmlReport.config().setReportName("Practo");//Report Name
        htmlReport.config().setDocumentTitle("Testing on Practo Website");// Document title
        htmlReport.config().setTheme(Theme.DARK);
        report.setSystemInfo("Environment", "TestEnv");
        report.setSystemInfo("TesterName", "Vara");
        report.attachReporter(htmlReport);
    }
    
    
    //To set a Edge Driver
    public static void driverSetUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();//Maximizing the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    
    //To open the URL
    public static void openUrl() throws Exception {
        input = new FileInputStream("src/main/java/BasePkg/PractoConfig.properties"); //Properties File
        properties.load(input);
        driver.get(properties.getProperty("PractoUrl"));//Getting url from the properties File
    }

    //To close the Browser
    public static void closeBrowser() {
        driver.quit();
    }

    //To save the report
    public static void saveReport() {
        report.flush();
    }
}

