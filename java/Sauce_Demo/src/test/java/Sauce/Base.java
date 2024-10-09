package Sauce;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
	EdgeDriver driver;
	public void driverSetUp()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}

}