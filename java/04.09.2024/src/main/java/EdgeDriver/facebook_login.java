package EdgeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class facebook_login {
	public static void main(String[] args)
	{
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/login.php/#:~:text=Log%20into%20Facebook%20to%20start%20sharing%20and%20connecting%20with%20your");
		WebElement email=driver.findElement(By.name("email"));
		email.sendKeys("varalakshmibudidi@gmail.com");
		email.sendKeys(Keys.ENTER);
		
		WebElement password=driver.findElement(By.name("pass"));
		password.sendKeys("varalaxmi@2023");
		password.sendKeys(Keys.ENTER);
		
		WebElement login=driver.findElement(By.name("login"));
		login.click();
	}
}
