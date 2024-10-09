package Action_class;
import java.time.Duration;
import java.lang.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class Frame {
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.className("dropdown-toggle")).click();
		driver.findElement(By.linkText("Frames")).click();
		Thread.sleep(2000);
		//driver.switchTo().frame("singleFrame") - using id
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"singleframe\"]")));
		driver.findElement(By.tagName("input")).sendKeys("vara");
	}
}
