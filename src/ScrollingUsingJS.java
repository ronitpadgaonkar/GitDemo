import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingUsingJS {

	public static void main(String[] args) throws InterruptedException {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;             //To enable scrolling we need to use JavascriptExecutor
		js.executeScript("window.scroll(0,500)");              //Scrolling window
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");     //Scrolling table in the window [vertical scroll]		
		//js.executeScript("document.querySelector('.tableFixHead').scrollLeft=5000");     //Horizontal scroll
		
		
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		
		int sum=0;
		for (int i=0; i<values.size(); i++)              //sum of all the WebElement values
		{
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		
		System.out.println(sum);
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());     //Getting the total text(296) displayed on the window
		Assert.assertEquals(sum, total);         //Comparing actual vs expected

	}

}
