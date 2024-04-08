import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class End2EndSearchFlow {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();   //Clicking on 1st dropdown(FROM)
		driver.findElement(By.xpath("(//a[@value='DEL'])[1]")).click();                 //Selecting from 1st Dropdown(FROM)
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();     //Selecting from 2nd Dropdown(TO)
		driver.findElement(By.cssSelector("a[class*=ui-state-highlight]")).click();         ////Selecting current date in Depart date
		
		
		//Checking whether the Return Date Element is Enabled or not
		   if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))        //Getting the attribute value and Checking whether the list of attribute values contains "1"
		     {
			   System.out.println("Its Disabled");
			    Assert.assertTrue(true);
		     }
		   else
		     {
			
			    Assert.assertTrue(false);
			
		      }
		
	   //While Loop for Selecting Adults
		 driver.findElement(By.id("divpaxinfo")).click();
		 Thread.sleep(1000);
		
		   int i=1;
		   while(i<5)
		     {
			   driver.findElement(By.id("hrefIncAdt")).click();
			   i++;
		     }
		  driver.findElement(By.id("btnclosepaxoption")).click();
		  Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");   //Checking whether there are 5 Adult
	      System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		   
		   
	   //Clicking on Search Button
		 driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
