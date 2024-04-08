import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortScanUsingJavaStreams {

	public static void main(String[] args) {
		
		//******Sorting, Pagination and Scanning multiple pages of the WebTable using do-while loop and Java Streams
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all the WebElements into list
		List<WebElement> list =driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture text of all the WebElements into new[original] list
		List<String> originalList = list.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Sort on the originalList to get sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Compare originalList vs sortedList
		Assert.assertTrue(originalList.equals(sortedList));          //Comparing two lists
		 
		
		
		//Scan the column with getText-> Rice-> Print the price of the Rice
		List<String> price;
		do 
		 {
			List<WebElement> list2 =driver.findElements(By.xpath("//tr/td[1]"));              //Getting the list of the elements on every page
		    price = list2.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		    price.forEach(a->System.out.println("Rice is " +a));        
		
		    if(price.size()<1)
		       {
			     driver.findElement(By.cssSelector("a[aria-label='Next']")).click();       //If Rice is not found on current page click on next page
		       }
		
		 }while(price.size()<1);
		
 
 }

	public static String getPriceVeggie(WebElement s) 
	   {
         String veggiePrice= s.findElement(By.xpath("following-sibling::td[1]")).getText();      //Getting price of the element
		
		 return veggiePrice;             //Returning the price of the element to the main method
	   }

}
