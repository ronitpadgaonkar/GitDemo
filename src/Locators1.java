import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {

		        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));        //will wait for action to be done (can be <5sec) and then move forward
				
				driver.get("https://rahulshettyacademy.com/locatorspractice/");
				driver.findElement(By.id("inputUsername")).sendKeys("rahul");
				driver.findElement(By.name("inputPassword")).sendKeys("rahul123");
				driver.findElement(By.className("signInBtn")).click();
				System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
				driver.findElement(By.partialLinkText("Forgot your")).click();
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
				driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@123.com");
				driver.findElement(By.xpath("//input[@type='text'][1]")).clear();                                //clearing the text
				driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("John@gmail.com");
				driver.findElement(By.xpath("//form/input[3]")).sendKeys("9562187462");
				driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
				System.out.println(driver.findElement(By.cssSelector("form p")).getText());
				driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
				driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
				driver.findElement(By.id("chkboxOne")).click();
				driver.findElement(By.name("chkboxTwo")).click();
				driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
				
				
				
	}

}
