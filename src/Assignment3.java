import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select drop = new Select(dropdown);
		
		String[] items = {"iphone", "Samsung", "Nokia", "Blackberry"};
		
		String user = driver.findElement(By.xpath("//p[contains(@class,'text-white')]/b[1] ")).getText();
		String pass = driver.findElement(By.xpath("//p[contains(@class,'text-white')]/b[2] ")).getText();
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		drop.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class*='btn-primary']")));
		
		getItems(driver, items);
		
		driver.findElement(By.cssSelector("a[class*='btn-primary']")).click();
		
		
		

	}
	
	public static void getItems(WebDriver driver, String[] items)
	{
		 List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']/a"));
		 List itemsList = Arrays.asList(items);
		 
		 int j=0;
		 for (int i=0; i<products.size(); i++)
		 {
			String[] name= products.get(i).getText().split(" ");
			String formattedName = name[0];
			
			if (itemsList.contains(formattedName))
			{
				j++;
			    driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
			    
			    if (j==itemsList.size())
			    	break;
			}
			 
		 }
		 
		
		
	}

}
