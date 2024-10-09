package EdgeDriver;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
 
public class Admission_enquiry {
	public static void main(String[] args) throws InterruptedException
	{
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://www.arena-multimedia.com/in/en/admissions-corner/admission-enquiry");
		driver.findElement(By.cssSelector("#common_form > p > span.input-box.input-wdh-7.name > input")).sendKeys("vai");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#common_form > p > span.input-box.input-wdh-8 > input")).sendKeys("939812349");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#common_form > p > span.input-box.input-wdh-9 > input")).sendKeys("varalakmibudidi@gmail.com");
		Thread.sleep(3000);
		WebElement course=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/form/p/span[4]/select"));
		Select dropdown=new Select(course);
		dropdown.selectByVisibleText("Animation");
		Thread.sleep(3000);
		WebElement state=driver.findElement(By.cssSelector("#common_form > p > span.input-box.input-wdh-11 > select"));
		Select dropdownstate=new Select(state);
		dropdownstate.selectByValue("431");
		Thread.sleep(3000);
		WebElement city=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/form/p/span[6]/select"));
		Select dropdowncity=new Select(city);
		dropdowncity.selectByVisibleText("SECUNDERABAD - AS RAO NAGAR");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#common_form > div > button")).click();
		Thread.sleep(3000);
	}
}
