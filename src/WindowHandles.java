	import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	/*	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.partialLinkText("InterviewQues/ResumeAssistance/Material")).click();
		Set<String> window = driver.getWindowHandles();                           //Getting window IDs [parentId, childId]
		Iterator<String> it = window.iterator();                            //Extracting IDs from window handles
		String parentId = it.next();                           //Pointing to 1st ID and storing it in parentID object 
		String childId =it.next();                         //Pointing to 2nd ID and storing it in childID object 
		driver.switchTo().window(childId);                           //Switch Control to child window
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		//String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4];
		driver.switchTo().window(parentId);                                                     //Switch Control to parent window
		driver.findElement(By.id("username")).sendKeys(emailId);
	*/

		
		
		//****Scenario-2
		//Navigate to 'https://rahulshettyacademy.com/angularpractice/' and Open new Window/Tab
		//Open URL 'https://rahulshettyacademy.com/' and grab the first course name 
		//Switch to previous URL and fill the Name field with first course name
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windowHandles =driver.getWindowHandles();
		Iterator<String> it =windowHandles.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName =driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("form div input[name='name']")).sendKeys(courseName);
		
	}

}
