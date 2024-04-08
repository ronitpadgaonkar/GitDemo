import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String year ="2027";
		String monthNumber = "4";
		String date = "26";
		String[] expectedList = {monthNumber,date,year};
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();               //Selecting the year
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();     //Selecting the month  [*Integer.parseInt(monthNumber)*-> converting string to integers] 
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();               //Selecting the day
		
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));           //List of WebElements containing month, day and year
		
		for(int i=0; i<actualList.size(); i++)
		{
			System.out.println(actualList.get(i).getAttribute("value"));          //Printing month, day & year one by one from the list of WebElement 
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);          //Comparing actual vs expected date 
			
		}
		
		
		

	}

}
