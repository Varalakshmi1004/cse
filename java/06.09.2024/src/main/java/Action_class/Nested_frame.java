package Action_class;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

public class Nested_frame {
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.className("dropdown-toggle")).click();
		driver.findElement(By.linkText("Frames")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.cssSelector("#Multiple > iframe")));
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div/div/iframe")));
		driver.findElement(By.tagName("input")).sendKeys("vara");
		driver.switchTo().defaultContent();
	}
}
