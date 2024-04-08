import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeMultipleLinkOpenWithTitle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	/*	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Getting total no. of links present on the full page
		System.out.println(driver.findElements(By.tagName("a")).size());      
		
		//Limiting Webdriver scope
		//Getting total no. of links present on the footer section (Bottom)
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));             //Creating an object of only the footer section (bottom section)
		System.out.println(footerdriver.findElements(By.tagName("a")).size());   
		
		//Getting total no. of links present on the footer section (bottom) 1st column
		WebElement columndriver = footerdriver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));        //Creating an object of only the footer section (bottom section) 1st column
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//Clicking on each link in the 1st Column and checking if the pages are opening
		for (int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++)
		{
			String ClickonLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);            
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickonLinkTab);      //sending keys to click on each link
			
		}
		
		//Getting the title of each link
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		
		while(it.hasNext())                //Checking whether next index is present or not (another window is present or not)
		{
			driver.switchTo().window(it.next());        //it.move()--> Goes to the next index
			System.out.println(driver.getTitle());
		}*/
		
		
	//**************Example 2
		driver.get("http://www.ebay.com/");
	//Count of the Link in the Entire Page
	System.out.println("Links in the Page");
	System.out.println(driver.findElements(By.tagName("a")).size());
	//Count of links in the footer section of the page
	WebElement footer=driver.findElement(By.xpath(".//*[@id='glbfooter']"));
	System.out.println("Links in the footer section");
	System.out.println(footer.findElements(By.tagName("a")).size());
	WebElement col=driver.findElement(By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[2]/ul[1]"));
	System.out.println("Links in the 2nd coloumn of the section");
	System.out.println(col.findElements(By.tagName("a")).size());
	String Beforeclicking = null;
	String Afterclicking;
	
	for(int i=0;i<col.findElements(By.tagName("a")).size();i++)
	{
	
		
		if(col.findElements(By.tagName("a")).get(i).getText().contains("Site map"))
		    {
			Beforeclicking = driver.getTitle();
		
			col.findElements(By.tagName("a")).get(i).click();
			break;
			}
	}
	
	Afterclicking =driver.getTitle();
	if(Beforeclicking!=Afterclicking)
	{
		if(driver.getPageSource().contains("sitemap"))
	
			System.out.println("PASS");
	
	    else
	        System.out.println("FAIL");
		
	}




	}

}
