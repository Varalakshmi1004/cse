package Base_pkg;
 
import java.io.File;
import java.time.Duration;
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
 
    public static void reportSetUp()
    {
    	htmlReport=new ExtentSparkReporter(new File("C:\\Users\\VaralakshmiB\\Desktop\\Report\\SwagLabs.html"));
    	report=new ExtentReports();
    	htmlReport.config().setReportName("SwagLabs");
    	htmlReport.config().setDocumentTitle("Testing on SwagLabs");
    	htmlReport.config().setTheme(Theme.DARK);
    	report.setSystemInfo("Environment","TestEnv");
    	report.setSystemInfo("TesterName","Vara");
    	report.attachReporter(htmlReport);
    }
    public static void driverSetUp() {
            driver = new EdgeDriver();
            //PageFactory.initElements(driver, this);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
 
    public void openUrl() {
        driver.get("https://www.saucedemo.com/");
    }
 
    public void close_Browser() {
            driver.quit();
        }
    public void saveReport()
    {
    	report.flush();
    }
}
