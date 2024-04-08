import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement drop = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(drop);
		
		driver.findElement(By.name("name")).sendKeys("Ronit");
		driver.findElement(By.name("email")).sendKeys("ronit123@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("ronit12345");
		driver.findElement(By.id("exampleCheck1")).click();
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		Assert.assertTrue(driver.findElement(By.id("inlineRadio1")).isSelected());
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("04-04-1990");
		driver.findElement(By.cssSelector("input[class*='btn-success']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText());
		
		
		
		

	}

}
