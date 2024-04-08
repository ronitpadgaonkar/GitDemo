import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions a = new Actions(driver);
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		
		for (WebElement option:options)
		{
			
			if(option.getText().equalsIgnoreCase("India"))
			{
				String ky = Keys.chord(Keys.UP, Keys.DOWN);
				a.moveToElement(option).sendKeys(ky).build().perform();
				System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
				
			}
		}
		
		
		
		/*
		     driver.findElement(By.id("autocomplete")).sendKeys("ind");

              Thread.sleep(2000);

             driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

             driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

             System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
             
		 */
		
		

	}

}
