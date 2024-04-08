import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));    //will wait for action to be done (can be <5sec) and then move forward
		
		String name = "rahul";
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000); 
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");     //compare two text i.e. actual output vs desired
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());              
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");      //compare two text i.e. actual output vs desired
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
		

	}

	 public static String getPassword(WebDriver driver) throws InterruptedException
	 {
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 driver.findElement(By.linkText("Forgot your password?")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		 String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		 //Please use temporary password 'rahulshettyacademy' to Login.
		 String[] passwordArray = passwordText.split("'");
		   //0th text = Please use temporary password 
		   //1st text = rahulshettyacademy' to Login.
		 
		 String[] passwordArray2 = passwordArray[1].split("'");
		   //0th text = rahulshettyacademy
		   //1st text = ' to Login.
		 //String password=passwordArray2[0];
		   
		                        //OR
		   //String password = passwordArray[1].split("'")[0];
		 
		 return passwordArray2[0];
		 
		 
		 
	 }
}
