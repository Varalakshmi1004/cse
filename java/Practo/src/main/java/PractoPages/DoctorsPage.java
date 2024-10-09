package PractoPages;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePkg.Base;

public class DoctorsPage extends Base{
	
	By specialist=By.xpath("//span[text()=\"Gynecologist/Obstetrician\"]");
	By selectedDoctor=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[2]/a/div/h2");
	By bookingVisit=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[2]/div/div/div[2]/div/button");
	By slotDate=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]");
	By slotTime=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div[1]/span");
	By filters=By.xpath("//span[text()=\"All Filters\"]");
	By fee=By.xpath("//span[@data-qa-id=\"consultation_fee\"]");
	By sFilter=By.xpath("//span[text()=\"₹0-₹500\"]");
	Random random=new Random();
	static int randInd;
	public boolean specialization()
	{
		List<WebElement> specializationList=driver.findElements(specialist);
		boolean spec=true;
		for( WebElement w: specializationList)
		{
			if(!w.getText().equals("Gynecologist/Obstetrician"))
			{
				spec=false;
				break;
			}
		}
		return spec;
	}
	public String doctorSelection() throws Exception
	{
		driver.findElement(bookingVisit).click();
		String doctorSelected=driver.findElement(selectedDoctor).getText();
		System.out.println(doctorSelected);
		Thread.sleep(2000);
		return doctorSelected;
	}
	public String slotDateSelection() throws Exception
	{
		WebElement sDate=driver.findElement(slotDate);
		sDate.click();
		LocalDate today=LocalDate.now();
		LocalDate tomorrow=today.plusDays(1);
		String tomorrowDate=tomorrow.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));

		System.out.println(tomorrowDate);
		Thread.sleep(2000);
		return tomorrowDate;
	}
	public String slotTimeSelection() throws Exception
	{
		Thread.sleep(2000);
		WebElement sTime=driver.findElement(slotTime);
		String time=sTime.getText();
		String hour=time.substring(0, 2);
		int hr=Integer.parseInt(hour);
		DateTimeFormatter outputFormatter,inputFormatter;
		sTime.click();
		if(hr<10)
		{
			inputFormatter= DateTimeFormatter.ofPattern("hh:mm a");
			LocalTime localTime=LocalTime.parse(time,inputFormatter);
	        outputFormatter = DateTimeFormatter.ofPattern("h:mm a");
	        String localTime2 = localTime.format(outputFormatter);
	        System.out.println(localTime2);
	        return localTime2;
		}
		else
		{
			System.out.println(time);
		}
		return time;
	}
	public boolean allFilters() throws Exception
	{
		driver.findElement(filters).click();
		Thread.sleep(5000);
		String selectedFilter=driver.findElement(sFilter).getText();
		String feeFilter=selectedFilter.substring(4);
		int price=Integer.parseInt(feeFilter);
		System.out.println(price);
		System.out.println(selectedFilter);
		driver.findElement(sFilter).click();
		Thread.sleep(5000);
		List<WebElement> fees=driver.findElements(fee);
		for(WebElement w: fees)
		{
			String priceFilter=w.getText();
			if(priceFilter.contains("Con"))
			{
				System.out.println("Free");
			}
			else 
			{
			String wPrice=priceFilter.substring(1);
			int wFee=Integer.parseInt(wPrice);
			System.out.println(wFee);
				if(wFee>price)
				{
					return false;
				}
			}
		}
		return true;
	}
	
}
