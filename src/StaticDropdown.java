import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Dropdown with Select tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));  //Telling where the dropdown is located
		Select dropdown = new Select(staticDropdown);         //Creating a object of Select class to use the methods of the Select class
        
		//Selecting the dropdown option based on index number
		  dropdown.selectByIndex(3);
          System.out.println(dropdown.getFirstSelectedOption().getText());     //Extracting the text  from the WebElement and displaying it on Console
		
       //Selecting the dropdown option based on Visible text
          dropdown.selectByVisibleText("AED");
          System.out.println(dropdown.getFirstSelectedOption().getText());
       
       //Selecting the dropdown option based on Attribute value
          dropdown.selectByValue("INR");
          System.out.println(dropdown.getFirstSelectedOption().getText());
          
	}

}
