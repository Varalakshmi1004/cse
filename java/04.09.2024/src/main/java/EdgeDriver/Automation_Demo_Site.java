package EdgeDriver;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automation_Demo_Site {
	
	EdgeDriver driver;
	By fName=By.cssSelector("#basicBootstrapForm > div:nth-child(1) > div:nth-child(2) > input");
	By lName=By.cssSelector("#basicBootstrapForm > div:nth-child(1) > div:nth-child(3) > input");
	By add=By.cssSelector("#basicBootstrapForm > div:nth-child(2) > div > textarea");
	By emailId=By.cssSelector("#eid > input");
	By phoneNo=By.cssSelector("#basicBootstrapForm > div:nth-child(4) > div > input");
	By byfemale=By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(2) > input");
	By cricket=By.cssSelector("#checkbox1");
	By language=By.cssSelector("#msdd");
	By byenglish=By.cssSelector("#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul > li:nth-child(8) > a");
	By byskills=By.cssSelector("#Skills");
	By bycountry=By.cssSelector("#basicBootstrapForm > div:nth-child(10) > div > span > span.selection > span");
	By countrySearch=By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input");
	By byyear=By.cssSelector("#yearbox");
	By bymonth=By.cssSelector("#basicBootstrapForm > div:nth-child(11) > div:nth-child(3) > select");
	By byday=By.cssSelector("#daybox");
	By profile=By.xpath("//*[@id=\"imagesrc\"]");
	By firstPassword=By.cssSelector("#firstpassword");
	By confirmPassword=By.cssSelector("#secondpassword");
	By submit=By.cssSelector("#submitbtn");
	public void setUp()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void openUrl()
	{
		driver.get("https://demo.automationtesting.in/Register.html");
	}
	public void testing() throws Exception
	{
		WebElement firstName=driver.findElement(fName);//firstname
		firstName.sendKeys("Varalakshmi",Keys.ENTER);
		
		WebElement lastName=driver.findElement(lName);//lastname
		lastName.sendKeys("Budidi",Keys.ENTER);
		
		WebElement address=driver.findElement(add);//address
		address.sendKeys("6-24-14,Gowri devi gudi veedhi,Tuni-533401");
		
		WebElement email=driver.findElement(emailId);//emailId
		email.sendKeys("varalakshmibudidi@gmail.com",Keys.ENTER);
		
		WebElement phone=driver.findElement(phoneNo);//phone number
		phone.sendKeys("9398230309",Keys.ENTER);
		
		WebElement female=driver.findElement(byfemale);//selecting female radio button
		female.click();
		
		driver.findElement(cricket).click();//selecting cricket checkbox
		
		driver.findElement(language).click();//clicking on language textbox
		WebElement english=driver.findElement(byenglish);//selecting english language
		english.click();
		
		WebElement Skills = driver.findElement(byskills); //skills
        Select dropdown = new Select(Skills);
        dropdown.selectByVisibleText("C++");
        
        WebElement country=driver.findElement(bycountry);//country
        country.click();
        WebElement search=driver.findElement(countrySearch);//to search for country
        search.sendKeys("India",Keys.ENTER);
        
        WebElement year=driver.findElement(byyear);//year
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("2004");
        
        WebElement month=driver.findElement(bymonth);//month
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("April");
        
        WebElement day=driver.findElement(byday);//day
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("10");
        
       // WebElement img=driver.findElement(profile);//profile pic uploading
        //img.sendKeys("C:\\Users\\VaralakshmiB\\Documents\\IMG_20240805_135159.jpg");
        //driver.findElement(profile).click();//profile pic uploading
        Robot r=new Robot();
        Thread.sleep(2000);
        StringSelection stringSelection=new StringSelection("C:\\Users\\VaralakshmiB\\Documents\\IMG_20240805_135159.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard()
        .setContents(stringSelection,null);
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_ENTER);
        
        WebElement password=driver.findElement(firstPassword);//set password
        password.sendKeys("varalaxmi@2023");
        WebElement passwordConfirm=driver.findElement(confirmPassword);//confirm password
        passwordConfirm.sendKeys("varalaxmi@2023",Keys.ENTER);
       
        driver.findElement(submit).click();
	}
	public static void main(String[] args) throws Exception
	{
		Automation_Demo_Site ads=new Automation_Demo_Site();
		ads.setUp();
		ads.openUrl();
		ads.testing();
	}
}
