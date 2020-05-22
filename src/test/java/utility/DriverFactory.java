package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DriverFactory {
	public static WebDriver driver=null;
	
	//create a chrome webdriver session
	
	public void createDriver() {
		System.out.println("Openning Browser:");		
		String exePath = "C:\\chromedriver81\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\ChromeExtention\\MultiPassHttpAuth.crx"));

		// ignore certifacte issue
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		
	// Add 20 secs implicit wait for each web elements
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// Add 30 secs for all page load
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	//close bowser
	public void closeBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}
	

}
