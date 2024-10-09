package SauceDemo_C;

import SauceDemoPages.Homepage;
//import SauceDemoPages.Cartpage;
import SauceDemoPages.Productspage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagLabs {
	Homepage home=new Homepage();
	Productspage prod=new Productspage();
	//Cartpage cart=new Cartpage();
	
	@Given("as a user i am on login page")
	public void as_a_user_i_am_on_login_page()
	{
		home.driverSetUp();
		home.openUrl();
	}
	
	@When("i enter valid username {string} and valid password {string} and click login")
	public void i_enter_valid_username_and_valid_password_and_click_login(String username,String password) 
	{
	    home.login(username,password);
	}
	@Then("i should be able to login successfully")
	public void i_should_be_able_to_login_successfully() throws Exception
	{
		Thread.sleep(3000);
		   if(prod.checkValidLogin()>0)
			   System.out.println("Valid Login Success(CucumberTest)");
		home.close_Browser();
	}
	@When("i enter either {string} or {string} invalid and click login")
	public void i_enter_either_username_or_password_invalid_and_click_login(String username,String password)
	{
		home.login(username,password);
	}
	@Then("i should see the error message")
	public void i_should_see_the_error_message()
	{
		if(!home.errorMsg().isEmpty())
		{
			System.out.println("Invalid Login Success(Cucumber Test)");
		}
		home.close_Browser();
	}
	/*
	@Given("as a user i am on cartpage")
	public void as_a_user_i_am_on_cartpage()
	{
		cart.driverSetUp();
		cart.openUrl();
	}
	@When("i enter valid username {string} and valid password {string} and click login.I add some products to cart and open cart page")
	public void checkCartPage(String username,String password)
	{
		home.login(username, password);
		prod.addProduct();
		prod.goToCart();
		cart.removeProduct();
	}
	@Then("cart page count should same")
	public void cart_page_count_should_same()
	{
		cart.checkCart();
		if(cart.actualCartProducts==cart.expectedCartProducts)
		{
			System.out.println("Count of products in Cart is same as expected");
		}
	}
	*/
	
}
