import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();       // Running window in maximize mode
		driver.get("https://www.amazon.in/");
		
		Actions a = new Actions(driver);          //creating an object 'a' of Actions Class
		
		//Composite Actions
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		//Moving to specific element
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();     //Contextclick()--> Mouse Right Click
		
		
		

	}

}
