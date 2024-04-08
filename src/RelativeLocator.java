import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocator {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());       //Using above() Relative Locator
		
		WebElement dateEditBox = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateEditBox)).click();                 //Using below() Relative Locator
		
		WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(),'Love IceCreams')]"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();                //Using toLeftOf() Relative Locator
		
		WebElement radiobtn = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radiobtn)).getText());        //Using toRightOf() Relative Locator

	}

}
