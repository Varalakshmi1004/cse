package PractoPages;

import org.openqa.selenium.By;
import BasePkg.Base;

public class DoctorDetailsPage extends Base{
	By date=By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[1]/span[2]");
	By time=By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/span[2]");
	By doctor=By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[3]/div/div[2]/div[1]");
	
	public String doctorName()
	{
		String name=driver.findElement(doctor).getText();
		return name;
	}
	
	public String slotTime()
	{
		String selectedTime=driver.findElement(time).getText();
		return selectedTime;
	}
	public String slotDate()
	{
		String selectedDate=driver.findElement(date).getText();
		return selectedDate;
	}
}
