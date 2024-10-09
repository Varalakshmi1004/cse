package PractoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

import BasePkg.Base;

public class HomePage extends Base {
    By place = By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input"); //City Search Box 
    By cityList = By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div");//List of Cities
    By specialization=By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");//Specialization Search Box
    By specializationList = By.xpath("//div[@data-qa-id=\"omni-suggestion-main\"]");//List of Specializations
    String specialist="";
    
    //To Select a city from the City Search Box randomly
    public void placeSelection() throws Exception 
    {
        WebElement cityInput = driver.findElement(place);
        cityInput.clear();
        cityInput.sendKeys(properties.getProperty("city"));
        Thread.sleep(2000);
        List<WebElement> cities = driver.findElements(cityList);
        if (cities.size() > 0) 
        {
            int randomIndex = new Random().nextInt(cities.size());
            cities.get(randomIndex).click();
        }
    }

    //To select the Specialization from the Specialization Search box randomly
    public void specializationSelection() throws Exception
    {
    	driver.findElement(specialization).click();
    	Thread.sleep(2000);
    	List<WebElement> specializationOptions= driver.findElements(specializationList);
    	Thread.sleep(2000);
    	if(specializationOptions.size()>0)
    	{
    		int randomIndex=new Random().nextInt(specializationOptions.size());
    		WebElement spec=specializationOptions.get(randomIndex);
    		specialist=specialist+spec.getText();
    		spec.click();
    	}
    }
}
