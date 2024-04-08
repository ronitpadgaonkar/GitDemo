import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesWithDragAndDrop {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());        //To get no. of frames present on the window (Size of the frame)
		
		
		//*********Switching to Frame section 
		
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));      //Telling location of frame section using WebElement
		driver.switchTo().frame(0);                  //Telling location of frame section using Index Value
		Actions a = new Actions(driver);                  //creating an object 'a' of Actions Class for Drag and Drop
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();                  //For dragging and dropping of elements from one onto another
		
		driver.switchTo().defaultContent();     //Coming out from frame section to main html code
		
		driver.findElement(By.cssSelector("div[class='view-source'] a")).click();
		
		
		

	}

}
