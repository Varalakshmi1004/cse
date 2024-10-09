package SauceDemoPages;
import Base_pkg.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
public class Productspage extends Base {
    By menu=By.cssSelector("#react-burger-menu-btn");
    By logout=By.cssSelector("#logout_sidebar_link");
    By cartIcon=By.cssSelector("#shopping_cart_container > a");
    By product=By.xpath("//*[@id=\"header_container\"]/div[2]/span");      
 
    public void addProduct() throws Exception
    {	
    	ArrayList<Integer> list=new ArrayList<>(6);
		for (int i=0;i<=5;i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);
		List<WebElement> products=driver.findElements(By.cssSelector("[id*=\"add-to-cart\"]"));
		for(int i=0;i<3;i++)
		{
			products.get(list.get(i)).click();
			Thread.sleep(2000);
		}
        System.out.println("3 products added");
    }
 
    public void logout()
    {
        driver.findElement(menu).click();
        driver.findElement(logout).click();
        System.out.println("Logged out");
    }
    public boolean checkValidLogin()
    {
    	List<WebElement> products=driver.findElements(product);
    	return products.size()>0;
    }
    public void goToCart() {
    	driver.findElement(cartIcon).click();
    }
}
