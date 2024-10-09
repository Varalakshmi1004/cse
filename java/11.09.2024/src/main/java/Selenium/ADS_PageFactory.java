package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ADS_PageFactory {

		
		EdgeDriver driver;
		@FindBy(css="#basicBootstrapForm > div:nth-child(1) > div:nth-child(2) > input") WebElement fName;
		@FindBy(css="#basicBootstrapForm > div:nth-child(1) > div:nth-child(3) > input") WebElement lName;
		@FindBy(css="#basicBootstrapForm > div:nth-child(2) > div > textarea") WebElement add;
		@FindBy(css="#eid > input") WebElement emailId;
		@FindBy(css="#basicBootstrapForm > div:nth-child(4) > div > input") WebElement phoneNo;
		@FindBy(css="#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(2) > input") WebElement byFemale;
		@FindBy(css="#checkbox1") WebElement cricket;
		@FindBy(css="#msdd") WebElement language;
		@FindBy(css="#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul > li:nth-child(8) > a") WebElement byenglish;
		@FindBy(css="#Skills") WebElement byskills;
		@FindBy(css="#basicBootstrapForm > div:nth-child(10) > div > span > span.selection > span") WebElement bycountry;
		@FindBy(css="body > span > span > span.select2-search.select2-search--dropdown > input") WebElement countrySearch;
		@FindBy(css="#yearbox") WebElement byyear;
		@FindBy(css="#basicBootstrapForm > div:nth-child(11) > div:nth-child(3) > select") WebElement bymonth;
		@FindBy(css="#daybox") WebElement byday;
		@FindBy(css="#imagesrc") WebElement profile;
		@FindBy(css="#firstpassword") WebElement firstPassword;
	    @FindBy(css="#secondpassword") WebElement confirmPassword;
		@FindBy(css="#submitbtn") WebElement submit;
		
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
		
		public void testing()
		{
			PageFactory.initElements(driver,this);
			fName.sendKeys("Varalakshmi",Keys.ENTER);
		
			lName.sendKeys("Budidi",Keys.ENTER);
			
			
			add.sendKeys("6-24-14,Gowri devi gudi veedhi,Tuni-533401");
			
			//emailId
			emailId.sendKeys("varalakshmibudidi@gmail.com",Keys.ENTER);
			
			
			phoneNo.sendKeys("9398230309",Keys.ENTER);
			
			//selecting female radio button
			byFemale.click();
			
			cricket.click();//selecting cricket checkbox
			
			language.click();//clicking on language textbox
			//selecting english language
			byenglish.click();
			
			 //skills
	        Select dropdown = new Select(byskills);
	        dropdown.selectByVisibleText("C++");
	        
	        //country
	        bycountry.click();
	        //to search for country
	        countrySearch.sendKeys("India",Keys.ENTER);
	        
	        //year
	        Select selectYear = new Select(byyear);
	        selectYear.selectByVisibleText("2004");
	        
	        //month
	        Select selectMonth = new Select(bymonth);
	        selectMonth.selectByVisibleText("April");
	        
	       //day
	        Select selectDay = new Select(byday);
	        selectDay.selectByVisibleText("10");
	        
	        
	        profile.sendKeys("C:\\Users\\VaralakshmiB\\Documents\\IMG_20240805_135159.jpg");
	        
	        //set password
	        firstPassword.sendKeys("varalaxmi@2023");
	        //confirm password
	        confirmPassword.sendKeys("varalaxmi@2023",Keys.ENTER);
	       
	        submit.click();
		}
		
		public static void main(String[] args)
		{
			ADS_PageFactory ads=new ADS_PageFactory();
			ads.setUp(); //to set up the web driver
			
			ads.openUrl();//to open the required url
			
			ads.testing();//to test the website
		}
}
