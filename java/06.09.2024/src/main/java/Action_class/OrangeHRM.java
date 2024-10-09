package Action_class;
 
import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class OrangeHRM {
 
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//user_name
		driver.findElement(By.name("username")).sendKeys("Admin");
		//password
		driver.findElement(By.name("password")).sendKeys("admin123");
		//login
		driver.findElement(By.xpath("//*[.=' Login ']/button")).click();
		
		//admin
		driver.findElement(By.xpath("//*[.='Admin']/a")).click();
		
		//user_management
		driver.findElement(By.xpath("//*[starts-with(.,'User Management')]/ul/li/span")).click();
		Thread.sleep(2000);
		//users
		driver.findElement(By.xpath("//*[.='Users']/li/a")).click();
		
		//add+
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		
		//user_role
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
		
		Thread.sleep(2000);
		
		List<WebElement> lst = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]"));
		
		lst.get(3).click();
		
		Thread.sleep(2000);
		
		//status
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
		Thread.sleep(2000);
		
		List<WebElement> lst1 = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]"));
		lst1.get(1).click();
		
		Thread.sleep(2000);
		
		//Employee_names
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("A");
		Thread.sleep(4000);
		
		List<WebElement> names = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]"));
		System.out.println(names.size());
		names.get(0).click();
		
		
		//user_name
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys("varalakshmi");
		
		//password
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("vara@2023");
		
		//confirm password
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("vara@2023");
		
		//save
		driver.findElement(By.xpath("//*[.=' Save ']")).click();
		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//*[.='pavan-l']/preceding-sibling::div")).click();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button")).click();
//		Thread.sleep(1000);
//		
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
	}
}
