package Action_class;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
	 
public class Drag_and_drop {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		String droppedText = targetElement.getText();
		if (droppedText.equals("Dropped!")) {
            System.out.println("Drag and drop successful!");
        } else {
            System.out.println("Drag and drop failed!");
        }
		driver.close();
		}
}	
