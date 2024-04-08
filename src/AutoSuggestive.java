import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");                 //Sending partial text in dropdowns
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));     //Storing list of Web Elements in an object array
		
        for(WebElement option :options)                        //Enhanced for loop for getting one option each time from the list and storing it in 'option' object
        {
        	if (option.getText().equalsIgnoreCase("India"))    //getting text from the 'option' object and comparing it
        	{
        		option.click();
        		break;                      //breaking the loop after clicking desired option
        	}
        	
        	
        }
        
	}

}
