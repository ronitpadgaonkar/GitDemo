import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		        //While Loop for Selecting Adults
		     int i=1;
		     while(i<5)
		        {
			      driver.findElement(By.id("hrefIncAdt")).click();
			      i++;
		         }
		     
		        //For Loop for Selecting Childs
		      int f;
		      for (f=0; f<3; f++)
		      {
		    	  driver.findElement(By.id("hrefIncChd")).click();
		      }
		      
		        //Selecting a single Infant
		      driver.findElement(By.id("hrefIncInf")).click();   
		
		driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.close();
}
}
