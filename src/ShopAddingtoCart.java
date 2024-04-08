import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopAddingtoCart {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		
		//********For Adding single item in the cart
		
  /*	for (int i=0; i<products.size(); i++)
		{
	    	String name = products.get(i).getText();       //Extracting text from the web element 'products' one by one and storing in string 'name' 
				
	    	if(name.contains("Cucumber"))                  //checking if 'name' contains cucumber
	    	{
	    		driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();       // Adding item to cart
	    		break;
	    	}
				
		}        */
		
		
		
		//*********For Adding multiple items in the cart
		
		String[] items = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
		List itemsList = Arrays.asList(items);                //Converting String of Arrays (items) into Array list (itemList)
		int j=0;
		
		  for (int i=0; i<products.size(); i++)
		  {
			  //name = "Brocolli - 1 kg"
			  //name[0] = "Brocolli "
			  //name[1] = " 1 kg"
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
