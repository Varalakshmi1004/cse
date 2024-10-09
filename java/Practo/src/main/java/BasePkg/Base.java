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
    public static Properties properties=new Properties();
	public static FileInputStream input;
	public static void reportSetUp()
	{
		htmlReport=new ExtentSparkReporter(new File("C:\\Users\\VaralakshmiB\\Desktop\\Report\\practo.html"));
    	report=new ExtentReports();
    	htmlReport.config().setReportName("Practo");
    	htmlReport.config().setDocumentTitle("Testing on Practo Website");
    	htmlReport.config().setTheme(Theme.DARK);
    	report.setSystemInfo("Environment","TestEnv");
    	report.setSystemInfo("TesterName","Vara");
    	report.attachReporter(htmlReport);
	}
	public static void driverSetUp()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	public static void openUrl() throws Exception
	{
		input= new FileInputStream("src/main/java/BasePkg/PractoConfig.properties");
		properties.load(input);
		driver.get(properties.getProperty("PractoUrl"));
	}
	public static void closeBrowser()
	{
		driver.quit();
	}
	public static void saveReport()
	{
		report.flush();
	}
	
}
