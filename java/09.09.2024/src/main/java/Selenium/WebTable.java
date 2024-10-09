package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebTable {
	public static void main(String[] args)
	{
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.chittorgarh.com/ipo/ipo_dashboard.asp");
		WebElement table=driver.findElement(By.xpath("(//table[@class='table table-sm table-striped'])[1]"));
		List<WebElement> rows=table.findElements(By.xpath("tbody/tr"));
		String str;
		for(int i=0;i<rows.size()-1;i++)
		{
			str=table.findElement(By.xpath("tbody/tr["+(i+2)+"]/td[1]")).getText();
			System.out.println(str);
		
		}
	}
}
