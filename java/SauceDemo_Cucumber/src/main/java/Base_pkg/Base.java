package Base_pkg;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
    public static EdgeDriver driver;
    public ExtentSparkReporter htmlReport;
    public ExtentReports report;
    public ExtentTest test;

    public void driverSetUp() {
    	htmlReport=new ExtentSparkReporter(new File("C:\\Users\\VaralakshmiB\\Desktop\\Report\\SwagLabs.html"));
    	report=new ExtentReports();
    	htmlReport.config().setReportName("SwagLabs");
    	htmlReport.config().setDocumentTitle("Testing on SwagLabs");
    	htmlReport.config().setTheme(Theme.DARK);
    	report.setSystemInfo("Environment","TestEnv");
    	report.setSystemInfo("TesterName","Vara");
    	report.attachReporter(htmlReport);
            driver = new EdgeDriver();
            PageFactory.initElements(driver, this);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void openUrl() {
        driver.get("https://www.saucedemo.com/");
        if(driver.getTitle().contains("Swag Labs"))
        {
        	test=report.createTest("Validate Title");
        	test.log(Status.PASS, "The title has the expected value");
        }
        else
        {
        	test=report.createTest("Validate Title");
        	test.log(Status.FAIL, "The title not matching expected value");
        }
    }

    public void close_Browser() {
    	report.flush();
            driver.quit();
        }
 }
