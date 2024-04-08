import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Here we are choosing an element in 2 Dropdowns consisting of same elements
		//Normally we write xpath as -> //a[@value='BLR']
		//In Dynamic Dropdown we write xpath as --> (//a[@value='BLR'])[1] --> While selecting from 1st Dropdown
		//In Dynamic Dropdown we write xpath as --> (//a[@value='BLR'])[2] --> While selecting from 2nd Dropdown
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='BLR'])[1]")).click();     //Selecting from 1st Dropdown
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();     //Selecting from 2nd Dropdown
		
		
		//OR we can write the xpath without using Indexes for both Dropdowns by using Parent to Child Traversing
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();     //Selecting from 2nd Dropdown
		
		//Selecting current date in Depart date
		driver.findElement(By.cssSelector("a[class*=ui-state-highlight]")).click();
		
	}

}
