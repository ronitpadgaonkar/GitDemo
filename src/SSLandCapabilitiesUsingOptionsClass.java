import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLandCapabilitiesUsingOptionsClass {

	public static void main(String[] args) {


		ChromeOptions options = new ChromeOptions();
		
		//Accept Error (SSL) certification and proceed to actual Website
		options.setAcceptInsecureCerts(true);      

		//Add the WebDriver proxy capability.
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("IpAddress:PortNumber");    //("myhttpproxy:3337")
		options.setCapability("proxy", proxy);

        //Add a ChromeDriver-specific capability (Add Extensions)
		options.addExtensions(new File("/path/to/extension.crx"));

		//Block pop-up Window
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		//Set Download Directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ronit\\Downloads\\Course-AutomationTesting\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
	}

}
