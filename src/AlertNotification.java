import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertNotification {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String text = "Ronit";
		driver.findElement(By.id("name")).sendKeys(text);  
		System.out.println(driver.findElement(By.id("alertbtn")).isDisplayed());    //Checking whether alert button is getting displayed i.e. in visible mode or not
		driver.findElement(By.id("alertbtn")).click();        
		System.out.println(driver.switchTo().alert().getText());     //Getting the text displayed on notification window 
		driver.switchTo().alert().accept();                 //Switching to alert mode to press ok (This is positive scope i.e. Ok, Yes, Accept, etc)
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());     //Getting the text displayed on notification window
		driver.switchTo().alert().dismiss();              //Switching to alert mode to press cancel (This is Negative scope i.e. Cancel, No, Deny, etc)
		

	}

}
