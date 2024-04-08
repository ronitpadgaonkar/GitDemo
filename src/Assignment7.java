import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
		System.out.println("Number of rows are " + rowCount.size());
		
		List<WebElement> columnCount = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]/td"));
		System.out.println("Number of columns are " + columnCount.size());
		
		for (int i=0; i<columnCount.size(); i++)
		{
			System.out.println(columnCount.get(i).getText());
		}

	}

}
