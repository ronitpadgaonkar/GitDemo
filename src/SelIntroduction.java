import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {

     //Invoking Browser
	 //Chrome - ChromeDrive ->Methods
	//WebDriver
	//ChromeDriver has WebDriver methods + own class methods
	  
		//chromedriver.exe -> invoke Chrome browser
		//Selenium Manager
		
		
		//Chrome Launch
		//ChromeDriver
		//webdriver.chrome.driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		//driver.quit();
		
		
		
		//Firefox Lauch
		//GeckoDriver
		//webdriver.gecko.driver
		//System.setProperty("webdriver.gecko.driver", "c:\\path"); //manual
		//WebDriver driver = new FirefoxDriver();
		//driver.get("https://rahulshettyacademy.com");
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
		//driver.close();
		
		
	
	  
	
	

	}

}
