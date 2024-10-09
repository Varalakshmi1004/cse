import java.net.URI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;

public class Navigate {
public static void main(String[] args) throws Exception
{
	EdgeDriver driver=new EdgeDriver();
	driver.navigate().to("https://www.google.co.in/");
	driver.manage().window().maximize();
	driver.findElement(By.cssSelector("#APjFqb")).sendKeys("google",Keys.ENTER);
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("#APjFqb")).sendKeys("java",Keys.ENTER);
	driver.navigate().back();
	Thread.sleep(2000);
	driver.navigate().forward();
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(2000);
	URI uri=new URI("https://www.geeksforgeeks.org/");
	driver.navigate().to(uri.toString());
	driver.quit();
}
}
