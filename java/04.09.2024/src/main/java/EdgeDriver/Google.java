package EdgeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
public class Google {
	public static void main(String[] args)
	{
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		//WebElement x=driver.findElement(By.name("q"));
		//x.sendKeys("java");
		//x.sendKeys(Keys.ENTER);
		//or
		driver.findElement(By.name("q")).sendKeys("java");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.close();
	}
}
