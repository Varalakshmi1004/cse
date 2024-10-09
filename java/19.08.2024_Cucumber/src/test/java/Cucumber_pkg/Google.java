package Cucumber_pkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Google
{
    EdgeDriver driver=new EdgeDriver(); 
	@Given("as a user i am on google homepage")
	public void as_a_user_i_am_on_google_homepage() 
	{
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	    
	}

	@When("enter any value in the searchbox and click enter")
	public void enter_any_value_in_the_searchbox_and_click_enter() 
	{
	    driver.findElement(By.name("q")).sendKeys("java",Keys.ENTER);
	}

	@Then("the results should be displayed")
	public void the_results_should_be_displayed() throws Exception 
	{
		//System.out.println(driver.getTitle());
		Thread.sleep(3000);
	   if(driver.getTitle().contains("java"))
		   System.out.println("Expected results are displayed");
	   else
		   System.out.println("Results are not as expected");
	}
}

