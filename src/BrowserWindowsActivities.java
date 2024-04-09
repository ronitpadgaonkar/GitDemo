import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowsActivities {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();    //To run window in maximize mode (full screen)
		driver.get("https://google.com");          // Open URL (Here it will wait for full page to load)   
		driver.navigate().to("https://rahulshettyacademy.com");    // To navigate to different web page (Here it wont wait for full page to load)
		driver.navigate().back();                 //To navigate back to previous page
		driver.navigate().forward();               //To navigate forward
                driver.close();
		
	}

}
