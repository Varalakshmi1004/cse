package EdgeDriver;

import java.util.List;
import java.lang.Thread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sauce {
	
	EdgeDriver driver;
	@FindBy(name="user-name") WebElement name;
	@FindBy(css="#password") WebElement password;
	@FindBy(css="#login-button") WebElement login;
	@FindBy(css="#add-to-cart-sauce-labs-backpack") WebElement product1;
	@FindBy(css="#add-to-cart-sauce-labs-bolt-t-shirt") WebElement product2;
	@FindBy(css="#add-to-cart-sauce-labs-onesie") WebElement product3;
	@FindBy(css="#shopping_cart_container > a") WebElement cartIcon;
	@FindBy(css="inventory_item_name") List<WebElement> cartProducts;
	@FindBy(css="#shopping_cart_container > a > span") WebElement cartSize;
	@FindBy(css="#react-burger-menu-btn") WebElement menu;
	@FindBy(css="#logout_sidebar_link") WebElement logout;
	
	public void setUp()
	{
		driver=new EdgeDriver();
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();
	}
	
	public void openUrl()
	{
		driver.get("https://www.saucedemo.com/");
	}
	
	public void login() throws InterruptedException
	{
		name.sendKeys("standard_user");
		Thread.sleep(2000);
		password.sendKeys("secret_sauce");
		Thread.sleep(2000);
		login.click();
		Thread.sleep(2000);
	}
	public void add_cart() throws InterruptedException
	{
		product1.click();
		Thread.sleep(2000);
		product2.click();
		Thread.sleep(2000);
		product3.click();
		Thread.sleep(2000);
		cartIcon.click();
		Thread.sleep(3000);
		System.out.println(cartSize.getText());
		if(cartProducts.size()==Integer.parseInt(cartSize.getText()))
		{
			System.out.println("Comparison status: same");
			for(WebElement w:cartProducts)
			{
				System.out.println(w.getText());
			}
		}
	}
	public void logout() throws InterruptedException
	{
		menu.click();
		Thread.sleep(2000);
		logout.click();
		Thread.sleep(2000);
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		Sauce s=new Sauce();
		s.setUp();
		s.openUrl();
		s.login();
		s.add_cart();
		s.logout();
	}
}
