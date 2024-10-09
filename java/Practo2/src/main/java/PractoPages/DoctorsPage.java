package PractoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import BasePkg.Base;

public class DoctorsPage extends Base {
    By specList = By.xpath("//div[@class=\"u-d-flex\"]/span"); //List of Specialization of doctors
    By bookVisitButtons = By.xpath("//button[text()='Book Clinic Visit']"); //List of Book Visit Buttons
    By slotDateTomorrow = By.xpath("(//div[@class=\"u-t-capitalize\"])[2]"); //Tomorrow tab
    By slotTime = By.xpath("//div[@data-qa-id=\"slot_time\"]/span");//slotTime
    By filters=By.xpath("//span[text()=\"All Filters\"]"); //Filters dropdown
	By fee=By.xpath("//span[@data-qa-id=\"consultation_fee\"]");//List of Fees of doctors
	By sFilter=By.xpath("//span[text()=\"₹0-₹500\"]");//0-500 Filter
	
	HomePage h=new HomePage();
	
	//To check whether the list of specialization contains all the values same as the one user selected
    public boolean specialization() throws Exception 
    {
        List<WebElement> specElements = driver.findElements(specList);
        Thread.sleep(2000);
        WebElement specialization=specElements.get(1);
        System.out.println(specialization.getText());
        for (WebElement spec : specElements) 
        {
            if (!spec.getText().contains(h.specialist)) 
            {
                return false;
            }
        }
        return true;
    }

    
    //To select the doctor name randomly when the doctor has book clinic visit option
    public String doctorSelection() throws Exception 
    {
    	Thread.sleep(3000);
        List<WebElement>buttons = driver.findElements(bookVisitButtons);
        //to check whether there is book clinic visit button available for atleast one doctor
        if (buttons.size()>0)
        {
        	int randomIndex = new Random().nextInt(buttons.size());
            WebElement selectedButton = buttons.get(randomIndex);
            Thread.sleep(5000);
            //To retrieve the ancestor of the book clinic button( ancestor contains the doctor name)
            WebElement parentElement = selectedButton.findElement(By.xpath("./ancestor::div[contains(@class, 'doctor-card')]"));
            Thread.sleep(2000);
            //to retrieve the doctor name(h2 of the ancestor contains doctorName)
            String doctorName = parentElement.findElement(By.xpath(".//h2")).getText();
            System.out.println("\nSelected Doctor Name:"+doctorName);
            Thread.sleep(2000);
            selectedButton.click();
            Thread.sleep(5000);
            return doctorName;
  
        }
        //If there are no buttons available, it throws exception
        else
        {
        	throw new Exception("No doctors are available for booking clinic visit");
        }
    }

    
    //To select the date
    public String slotDateSelection() throws Exception 
    {
        String formattedDate ;
            List<WebElement> noSlotsElement = driver.findElements(slotTime);
        
            //If there are slots available for today
            if (noSlotsElement.size()>0) 
            {
                LocalDate today = LocalDate.now();
                formattedDate = today.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));//Formatting date
                System.out.println("Selected slot Date :"+formattedDate);
                return formattedDate;
            }
            //If not ,switch to tomorrow tab
            else
            {
            	WebElement dateElement = driver.findElement(slotDateTomorrow);
            	Thread.sleep(3000);
            	dateElement.click();
            
            	LocalDate tomorrow = LocalDate.now().plusDays(1);
            	formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));//Formatting Date
            	System.out.println("Selected slot Date :"+formattedDate);
            	return formattedDate;
            }
    }

    
    //To Select The Slot time Randomly
    public String slotTimeSelection() throws Exception 
    {
        List<WebElement> timeElements = driver.findElements(slotTime);
        
        //To check whether the selected Date contains atleast one slot
        if(timeElements.size()>0)
    	{
    		int randomIndex=new Random().nextInt(timeElements.size());
    		WebElement timeElement=timeElements.get(randomIndex);
    		String selectedTime =timeElement.getText();
    		String hour=selectedTime.substring(0, 2); //retrieving hour for further validation
    		int hr=Integer.parseInt(hour);
    		DateTimeFormatter outputFormatter,inputFormatter;
    		timeElement.click();
    		
    		//If hour is less than 10, we need to format the Selected time
    		if(hr<10)
    		{
				inputFormatter= DateTimeFormatter.ofPattern("hh:mm a");
				LocalTime localTime=LocalTime.parse(selectedTime,inputFormatter);
		        outputFormatter = DateTimeFormatter.ofPattern("h:mm a");
		        String localTime2 = localTime.format(outputFormatter);
		        System.out.println("Selected Slot Time :"+localTime2);
		        return localTime2;
    		}
    		//If not directly we can return the Selected Time
    		else
    		{
    			System.out.println(selectedTime);
    		}
        return selectedTime;
        
    	}
        
       return null;
    }
    
    
    //To select the price filter
    public boolean allFilters() throws Exception
	{
		driver.findElement(filters).click();
		Thread.sleep(5000);
		String selectedFilter=driver.findElement(sFilter).getText();
		String feeFilter=selectedFilter.substring(4);//To get the maximum price
		int price=Integer.parseInt(feeFilter);
		driver.findElement(sFilter).click();
		Thread.sleep(5000);
		List<WebElement> fees=driver.findElements(fee);
		
		if(fees.size()>0)
		{
		for(WebElement w: fees)
		{
			String priceFilter=w.getText();
			//if Price is free Consultation
			if(priceFilter.contains("Con"))
			{
				
			}
			else 
			{
			String wPrice=priceFilter.substring(1);
			int wFee=Integer.parseInt(wPrice);
				//If price we retrieved is greater than the filter we selected, return false
				if(wFee>price)
				{
					return false;
				}
			}
		}
		}
		else
		{
			throw new Exception("No doctors are available in the page");
		}
		return true;
	}
}


