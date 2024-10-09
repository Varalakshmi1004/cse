package PractoPages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import BasePkg.Base;

public class HomePage extends Base{
	By place=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input");
	By hyderguda=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div[3]/span/div[1]");
	By specialization=By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
	By cityList=By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[2]/div[2]/div");
	public void placeSelection() throws Exception
	{
		WebElement city=driver.findElement(place);
		city.clear();
		
		city.sendKeys(properties.getProperty("city"));
		Thread.sleep(5000);
		driver.findElement(hyderguda).click();
		
		
	}
	public void specializationSelection() throws Exception
	{
		driver.findElement(specialization).click();
		Thread.sleep(2000);
		WebElement gp=driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div/div[3]/span[1]/div"));
		System.out.println(gp.getText());
		gp.click();
	}
}
