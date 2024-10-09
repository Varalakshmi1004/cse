package Action_class;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static void main(String args[]) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.className("dropdown-toggle")).click();
		driver.findElement(By.linkText("Alerts")).click(); //using link
		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Alert with OK & Cancel")).click();
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		Thread.sleep(2000);
		System.out.println(alert.getText());
		alert.dismiss();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Alert with Textbox")).click();
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		alert.sendKeys("vara");
		Thread.sleep(2000);
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(2000);
		driver.quit();
	}

}
