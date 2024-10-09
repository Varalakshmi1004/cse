package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Student_Registration {

	ChromeDriver driver;
	@FindBy(xpath="//*[@id=\"firstName\"]") WebElement fName;
	@FindBy(xpath="//*[@id=\"lastName\"]") WebElement lName;
	@FindBy(xpath="//*[@id=\"userEmail\"]") WebElement email;
	@FindBy(xpath="//*[@id=\"genterWrapper\"]/div[2]/div[2]") WebElement female;
	@FindBy(xpath="//*[@id=\"userNumber\"]") WebElement phone;
	@FindBy(xpath="//*[@id=\"subjectsContainer\"]/div/div[1]") WebElement sub;
	@FindBy(xpath="//*[@id=\"subjectsInput\"]") WebElement subject;  
	@FindBy(xpath="//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]") WebElement music;
	@FindBy(xpath="//*[@id=\"uploadPicture\"]") WebElement img;
	@FindBy(xpath="//*[@id=\"currentAddress\"]") WebElement address;
	@FindBy(xpath="//*[@id=\"state\"]") WebElement state;
	@FindBy(xpath="//*[@id=\"react-select-3-input\"]") WebElement stateip;
	@FindBy(xpath="//*[@id=\"city\"]") WebElement city;
	@FindBy(xpath="//*[@id=\"react-select-4-input\"]") WebElement cityip;
	@FindBy(xpath="//*[@id=\"submit\"]") WebElement submit;
	@FindBy(xpath="//*[@id=\"dateOfBirthInput\"]") WebElement dateOfBirth ;
	
	public void setUp()
	{
		driver=new ChromeDriver();
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void openUrl()
	{
		driver.get("https://demoqa.com/automation-practice-form");
	}
	
	public void testing() throws InterruptedException 
	{
		fName.sendKeys("fddsssdds");
	
		lName.sendKeys("fbhhfefe");
		
		email.sendKeys("fbhdhfhdbf@gmail.com");
		
		female.click();
		
		phone.sendKeys("9390900090");
		Thread.sleep(2000);
		
		dateOfBirth.click();
		
		WebElement month= driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select"));
		Select dropdownMonth=new Select(month);
		dropdownMonth.selectByVisibleText("April");
		WebElement year=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select"));
		Select dropdownyear=new Select(year);
		dropdownyear.selectByVisibleText("2004");
		WebElement date=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[7]"));
		date.click();
		Thread.sleep(2000);
		
	    sub.click();
		Thread.sleep(2000);
		subject.sendKeys("maths");
		Thread.sleep(2000);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    subject.sendKeys("co");
	    Thread.sleep(2000);
	    subject.sendKeys(Keys.ARROW_DOWN);
	    subject.sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	   
		music.click();//selecting music checkbox
		
        img.sendKeys("C:\\Users\\VaralakshmiB\\Documents\\IMG_20240805_135159.jpg");
        
        address.sendKeys("ghfhghjtyjhgbghjhfdtstgfdfghtgh");
        Thread.sleep(2000);
        
        state.click();
        Thread.sleep(2000);
        stateip.sendKeys("ha");
        Thread.sleep(2000);
        stateip.sendKeys(Keys.ARROW_DOWN);
        stateip.sendKeys(Keys.ENTER);
        
        Thread.sleep(2000);
        city.click();
        Thread.sleep(2000);
        cityip.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
        submit.click();
	}
	
	public static void main(String[] args) throws Exception
	{
		Student_Registration sr=new Student_Registration();
		sr.setUp(); //to set up the web driver
		
		sr.openUrl();//to open the required url
		
		sr.testing();//to test the website
	}
}
