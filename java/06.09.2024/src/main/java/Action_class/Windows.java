package Action_class;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {
public static void main(String args[]) throws InterruptedException
{
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demo.automationtesting.in/Register.html");
	driver.findElement(By.className("dropdown-toggle")).click();
	driver.findElement(By.linkText("Windows")).click(); //using link
	Thread.sleep(2000);
	String currentWindow=driver.getWindowHandle();
	driver.findElement(By.cssSelector("#Tabbed > a > button")).click();
	Set<String> lst= driver.getWindowHandles();
	for(String str:lst)
	{
		System.out.println(str);
	}
	Thread.sleep(3000);
	driver.switchTo().window(currentWindow);
	Thread.sleep(3000);
	driver.findElement(By.linkText("Open New Seperate Windows")).click();
	driver.findElement(By.cssSelector("#Seperate > button")).click();
	Set<String> lst2= driver.getWindowHandles();
	for(String str:lst2)
	{
		System.out.println(str);
	}
	Thread.sleep(5000);
	driver.switchTo().window(currentWindow);
}
}
