package Action_class;
 
import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
 
public class OrangeHRM2 {
 
	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver  = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Click on Admin
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
		
		// Click on Add User
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
		
		
		// User-role
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
		Thread.sleep(3000);
		
		List <WebElement> user_role = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div"));
		System.out.println(user_role.size());
		Thread.sleep(3000);
		
		if(user_role.size() == 0 ) {
			System.out.println("size is Zero");
			return;
		}
		else {
			for(WebElement w : user_role) {
				System.out.println(w.getText());
				String t = w.getText();
				if(t.equals("ESS")) {
					w.click();
				}
			}
		}
 
		
		//Employee Name
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("a");
				Thread.sleep(8000);
				
				List <WebElement> lst = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div"));
				
				
				System.out.println("size = "+lst.size());
				
				if(lst.size() == 0) {
					System.out.println("Size is Zero");
					return;
				}
				
				for(WebElement w:lst) {
					String ele = w.getText();
					System.out.println(ele);
					
					if(ele.contains("a")) {
						w.click();
						break;
					}
				
				}
				
				// Status
				driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
				Thread.sleep(3000);
				
				
				List <WebElement> status = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div"));
				System.out.println(status.size());
				if(status.size() == 0) {
					System.out.println("Size is Zero");
					return;
				}
				else {
					for(WebElement w : status) {
						System.out.println(w.getText());
						String s = w.getText();
						if(s.contains("D")) {
							w.click();
							break;
						}
					
					}
				}
 
				
				
				
				
		
		//User Name
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys("Varalakshmi");
		
		// Password
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys("vara@2023");
 
		//confirm Password
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys("vara@2023");
 
		
		// Save
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
		Thread.sleep(2000);
		
		
		//driver.findElement(By.xpath("//div[. = 'Rake A']/preceding-sibling::div")).click();
		//Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button")).click();
		
		//Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
		
		
		
	}
 
}
