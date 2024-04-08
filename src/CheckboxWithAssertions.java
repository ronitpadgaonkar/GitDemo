import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxWithAssertions {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//****Clicking on Senior Citizen Checkbox
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());   //Checking and displaying whether the checkbox is selected or not
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());   //Condition should be false i.e. checkbox should not be selected to pass the test otherwise it will fail the test  
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());   //Checking and displaying whether the checkbox is selected or not
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());    //Condition should be true i.e. checkbox should be selected to pass the test otherwise it will fail the test
		
		//Counting the number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());      //Displaying total number of checkboxes
		
		
		
		
		//*****Selecting current date in Depart date
	     driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		 driver.findElement(By.cssSelector("a[class*=ui-state-highlight]")).click();
		
		//Checking whether the Return Date Element is Enabled or not
		
		//System.out.println(driver.findElement(By.id("Div1")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));     //Getting the attribute value and displaying it
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))        //Getting the attribute value and Checking whether the list of attribute values contains "1"
		{
			System.out.println("Its enabled");
			Assert.assertTrue(true);
		}
		else
		{
			
			Assert.assertTrue(false);
			
		}

		
	}

}
