package EdgeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;

public class practice {
	public static void main(String args[])
	{
		EdgeDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("java",Keys.ENTER);
		List<WebElement> lst;
		lst=driver.findElements(By.tagName("h3"));
		for(WebElement w : lst)
		{
			System.out.println(w.getText());
		}
		driver.quit();
	}
}
