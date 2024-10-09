package SauceDemoPages;
import Base_pkg.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
 
public class Cartpage extends Base {
 
    By cartSize=By.cssSelector("#shopping_cart_container > a > span");

    By cartProducts=By.className("inventory_item_name");
    public int actualCartProducts,expectedCartProducts;
    public void checkCart() {
        System.out.println("Cart size: " + driver.findElement(cartSize).getText());
        System.out.println("Number of items in cart: " + driver.findElements(cartProducts).size());
        actualCartProducts=driver.findElements(cartProducts).size();
        expectedCartProducts=Integer.parseInt(driver.findElement(cartSize).getText());
        System.out.println("The items in the cart: ");
        for (WebElement w : driver.findElements(cartProducts)) 
        {
            System.out.println(w.getText());
        }
    }
    public void removeProduct() {
    	List<WebElement> cart=driver.findElements(By.cssSelector("[id*=\"remove-sauce-labs\"]"));
    	cart.get(0).click();
        System.out.println("Removed 1 product");
    }
}
