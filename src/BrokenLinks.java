import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		//*****For Multiple Links******
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();                 //Soft Assertion
		
	    for (WebElement link: links)
	    {
	    	String url = link.getAttribute("href");
	    	HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();     //opens the connection and send URL to Internet n/w and get the response 
			conn.setRequestMethod("HEAD");                  //Making call to the URL[setting request method] using HEAD request method
			conn.connect();
			int respCode = conn.getResponseCode();        // Getting response code
			System.out.println(respCode);
			
			a.assertTrue(respCode<400, "The link with Text '" +link.getText()+ "' is broken with Code " +respCode );
			
		/*	if(respCode>400)     //***For Hard Assertion--> End the execution even if it finds one failure and wont continue the execution
			{
				System.out.println("The link with Text " +link.getText()+ " is broken with Code " +respCode );
				Assert.assertTrue(false);
			}
	    */
			
	    }
	     a.assertAll();         //If statements fails then it will store all the failure and display it at the end of the execution
	  
		
	    
	    
		/*
		 //******For Single Link****
		 
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
		*/
		
	}

}
