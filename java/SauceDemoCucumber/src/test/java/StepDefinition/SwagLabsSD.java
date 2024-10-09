package StepDefinition;
 
import SauceDemoPages.Homepage;

import com.aventstack.extentreports.Status;

import SauceDemoPages.Cartpage;
import SauceDemoPages.Productspage;
import Base_pkg.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class SwagLabsSD extends Base{
	Homepage home=new Homepage();
	Productspage prod=new Productspage();
	Cartpage cart=new Cartpage();
	@Given("as a user i am on login page")
	public void as_a_user_i_am_on_login_page()
	{
		home.openUrl();
	}
	
	@When("i enter either {string} or {string} invalid and click login")
	public void i_enter_either_username_or_password_invalid_and_click_login(String username,String password)
	{
		home.login(username,password);
	}
	@Then("i should see the error message")
	public void i_should_see_the_error_message()
	{
		test=report.createTest("validate invalid login");
		if(home.errorMsg().isEmpty())
		{
			test.log(Status.FAIL, "Valid InLogin Test Failed");
		}
		else
		{
			test.log(Status.PASS, "Valid InLogin Test pass");
		}
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
		test=report.createTest("validate valid login");
		   if(prod.checkValidLogin()==true)
		   {
			   
			   test.log(Status.PASS, "Valid Login Test pass");
		   }
		   else
		   {
			   test.log(Status.FAIL,"Valid Login Test failed");
		   }
	}

	@Given("as a user i am on product page")
	public void as_a_user_i_am_on_product_page()
	{
		
	}
	@When("i added 3 products into the cart and navigate to cart Page")
	public void checkCartPage() throws Exception
	{
		prod.addProduct();
		prod.goToCart();
		cart.removeProduct();
	}
	@Then("cart page count should same")
	public void cart_page_count_should_same()
	{
		cart.checkCart();
		test=report.createTest("validate Cart Page Functionality");
		if(cart.actualCartProducts==cart.expectedCartProducts)
		{
			test.log(Status.PASS, "Cart Page Functionality is working Fine");
		}
		else
		{
			test.log(Status.FAIL, "Cart page Functionality Failed");
		}
		prod.logout();
		prod.saveReport();
		prod.close_Browser();
	}
}
