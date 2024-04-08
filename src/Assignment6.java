
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption3")).click();
		String text = driver.findElement(By.cssSelector("label[for='honda']")).getText();
		
		List<WebElement> drop = driver.findElements(By.cssSelector("select option"));
		
		for (int i=0; i<drop.size(); i++)
		{
			String name = drop.get(i).getText();
			if (name.contains(text))
			{
				driver.findElements(By.cssSelector("select option")).get(i).click();
			}
		}
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		String text2 = driver.switchTo().alert().getText();
		
		if (text2.contains(text))
		{
			System.out.println("Pass");
			driver.switchTo().alert().accept();
		}
		else
		{
			System.out.println("Fail");
		}
		
	}

}
