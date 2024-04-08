
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopCheckoutwithWaits {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));     //Declaring class name called WebDriverWait which will help to achieve Explicit wait
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     //Implicit wait (Deprecated)
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));     //Implicit wait [will wait for action to be done (can be <5sec) and then move forward]   
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] items = {"Cucumber", "Brocolli", "Beetroot"};
		
		getItems(driver,items);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Thread.sleep(3000);
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));       //Explicit wait (waiting till the locator element is visible)
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));        //Explicit wait
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		

	}
	
	   public static void getItems(WebDriver driver, String[] items)
	     {
		
           List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		   List itemsList = Arrays.asList(items);                //Converting String of Arrays (items) into Array list (itemList)
		   int j=0;
		
		   for (int i=0; i<products.size(); i++)
		     {
			  String[] name = products.get(i).getText().split("-");    //Getting text from web element (products), splitting it one by one and storing it in Array string 'name'
			  String formattedName = name[0].trim();             //trimmimg the blank spaces of 0th element
			  
			     if (itemsList.contains(formattedName))    //Checking whether 'formattedName' extracted is present in Array list (itemsList)
			        {
				       j++;
				       driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();         //Adding Items to cart
			
			           if (j==items.length)      //Iterating till the size of the array
			    	   break;
				
			         }
			  
		     }
	     }

}
