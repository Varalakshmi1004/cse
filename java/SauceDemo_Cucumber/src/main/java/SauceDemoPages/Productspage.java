package SauceDemoPages;
import Base_pkg.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Productspage extends Base {
	By product1=By.cssSelector("#add-to-cart-sauce-labs-backpack");
    By product2=By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt");
    By product3=By.cssSelector("#add-to-cart-sauce-labs-onesie");
    By menu=By.cssSelector("#react-burger-menu-btn");
    By logout=By.cssSelector("#logout_sidebar_link");
    By cartIcon=By.cssSelector("#shopping_cart_container > a");
    By product=By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public void addProduct() {
        driver.findElement(product1).click();
        driver.findElement(product2).click();
        driver.findElement(product3).click();
        System.out.println("3 products added");
    }

    public void logout()
    {
        driver.findElement(menu).click();
        driver.findElement(logout).click();
        System.out.println("Logged out");
    }
    public int checkValidLogin()
    {
    	List<WebElement> products=driver.findElements(product);
    	return products.size();
    }
    public void goToCart() {
    	driver.findElement(cartIcon).click();
    }
}


