package Selenium;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.String;

public class Practo {
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.practo.com/?sem=true&msclkid=fa007e33d66314007eeb18ed5a8a5d69&utm_source=bing&utm_medium=cpc&utm_campaign=KSA_Generic%20Campaign_Bing&utm_term=practo%20com&utm_content=Broad%20Match%20Desktop");
		driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input")).clear();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/span[2]/span/i")).click();
		//to clear by icon x
		driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input")).sendKeys("hyd");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div[1]/span[1]/div")).click();
		WebElement specialization=driver.findElement(By.xpath("(//div[@class=\"c-omni-suggestion-item__content__title\"])[2]"));
		specialization.click();
		Thread.sleep(8000);
	
		WebElement doctor=driver.findElement(By.cssSelector("#container > div > div.c-listing-wrapper > div > div.pure-u-17-24.c-listing__left > div > div:nth-child(3) > div:nth-child(1) > div > div.u-d-flex.flex-jc-flex-end.flex-direction-column.flex-ai-center > div > div > div.u-d-flex.u-justify-center.flex-direction-column > div > button"));
		List<WebElement> lst=driver.findElements(By.tagName("h2"));
		String selectedDoctor=driver.findElement(By.xpath("//h2[text()=\"Dr. K. Suma\"]")).getText();
		//WebElement selectedDoctor=lst.get(1);
		System.out.println(selectedDoctor);
		doctor.click();
	    LocalDate today ;
	    LocalDate tomorrow;
	    //WebElement time;
	    WebElement tomorrowTab = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]"));
	    tomorrowTab.click();
	 
	        // Locate and click on an available time slot for tomorrow
	    WebElement tomorrowTimeSlot = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/span"));
	    String selectedTime=tomorrowTimeSlot.getText();
	    tomorrowTimeSlot.click();
	    today = LocalDate.now();
	    tomorrow = today.plusDays(1);
	    String tom=tomorrow.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
  
        System.out.println(tom);
    
        
		
		System.out.println("\nDoctor Details:");
		
		WebElement details=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[3]/div/div[2]"));
		String doctorDetails=details.getText();
		System.out.println(doctorDetails);
		
		
		//date and time
		WebElement t=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/span[2]"));
		System.out.println(t.getText());
		WebElement date2=driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[1]/span[2]"));
		String time=t.getText();
		
		LocalTime localTime = LocalTime.parse(time);
		DateTimeFormatter inputFormatter;
		
		if(localTime.getHour()<10)
		{
	    inputFormatter = DateTimeFormatter.ofPattern("h:mm a");
        
        // Parse the time string into a LocalTime object
        LocalTime time2 = LocalTime.parse(time, inputFormatter);
        
        // Define the desired output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        
        // Format the LocalTime object into the desired string format
        String localTime = time2.format(outputFormatter);
		}
		
        
        
        //time
        inputFormatter=DateTimeFormatter.ofPattern("MMM dd, yyyy");
        LocalDate date=LocalDate.parse(date2.getText(),inputFormatter);
        outputFormatter=DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate=date.format(outputFormatter);
        
        
        // Print the result
        System.out.println(formattedTime); 
        System.out.println(formattedDate);
		
		if(doctorDetails.contains(selectedDoctor)&&formattedTime.equals(selectedTime)&&formattedDate.equals(tom))
		{
			System.out.println("\nDoctor details are same as the doctor we selected");
		}
		driver.quit();
	}
}
