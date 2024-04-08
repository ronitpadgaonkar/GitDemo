import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDimensionsCookies {

	public static void main(String[] args) throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();       //Running window in maximum size
		driver.manage().deleteAllCookies();        //Deleting all the cookies
	  //driver.manage().deleteCookieNamed("sessionKey");        //Deleting a particular cookie by its name
		
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//***Taking Screenshot of the WebPage
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);       //Taking Screenshot of the webpage
		FileUtils.copyFile(src, new File("D:\\Course Files\\screenshot.png"));         //Saving the screenshot to local system
		
		//***Taking partial Screenshot
		File file =driver.findElement(By.id("flightSearchContainer")).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D:\\Course Files\\PartialScreenshot.png"));
		
		
		//***Dimensions of the Box [Height and Width]
		WebElement box = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		System.out.println(box.getRect().getDimension().getHeight());          //Getting Height
		System.out.println(box.getRect().getDimension().getWidth());           //Getting Width
		

	}

}
