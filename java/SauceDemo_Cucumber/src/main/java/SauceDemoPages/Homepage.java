package SauceDemoPages;
import Base_pkg.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;


public class Homepage extends Base {
    By password=By.cssSelector("#password");
    By login=By.cssSelector("#login-button");
    By error=By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    By name=By.name("user-name");

    public void login(String userName,String pass) 
    {
    	if(userName.equals("standard_user")&&pass.equals("secret_sauce"))
        {
        	test=report.createTest("validate Login");
        	test.log(Status.PASS,"the username and password is valid");
        }
        else
        {
        	test=report.createTest("Validate Login");
        	test.log(Status.FAIL,"the username and password is invalid");
        }
        driver.findElement(name).sendKeys(userName);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).click();
    }
    
    public String errorMsg()
    {
    	WebElement errorText=driver.findElement(error);
    	String errorMessage=errorText.getText();
    	return errorMessage;
    }
}


