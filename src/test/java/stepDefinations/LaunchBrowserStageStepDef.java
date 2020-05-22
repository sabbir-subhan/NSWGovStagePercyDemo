package stepDefinations;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.cucumber.java.en.Given;
import io.percy.selenium.Percy;
import utility.DriverFactory;
import utility.HighlightElement;

public class LaunchBrowserStageStepDef extends DriverFactory {

	@Given("I want to launch browser with nsw.gov.au Stage website")
	public void i_want_to_launch_browser() throws InterruptedException {
		//percy constructor
		Percy percy = new Percy(driver);

		// Openinng the extension and fill up the values
		driver.get("chrome-extension://enhldmjbphoeibbpdhmjkchohnidgnah/options.html");
		WebElement URLTexBox = driver.findElement(By.id("url"));
		URLTexBox.sendKeys("dcs-staging.cd.pnx.com.au");
		WebElement usernameTexBox = driver.findElement(By.id("username"));
		usernameTexBox.sendKeys("dcs");
		WebElement passwordTexBox = driver.findElement(By.id("password"));
		passwordTexBox.sendKeys("dcs!@#");
		WebElement addButton = driver.findElement(By.className("credential-form-submit"));
		addButton.click();
		Thread.sleep(2000);
		// now go to staging site, no http basic auth popup should come
		driver.get("https://dcs-staging.cd.pnx.com.au/");
		//Hight light search bar
		
		HighlightElement highlightElement=new HighlightElement();
		WebElement hearSearchBar=driver.findElement(By.className("nsw-header__right"));
		highlightElement.highlightElement(driver, hearSearchBar);
		WebElement PicBox=driver.findElement(By.xpath("//div[@class='page__section dcs-person']"));
		highlightElement.highlightElement(driver, PicBox);
		
		// TO DO -write a logic to handle ssl error
		/*
		 * <div class="error-code" jscontent="errorCode"
		 * jstcache="18">ERR_SSL_PROTOCOL_ERROR</div>
		 */
		/*Thread.sleep(2000);
		driver.navigate().refresh();
		// Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl() + "::" + driver.getTitle());
		Thread.sleep(2000);*/
		//take percy snap shot
		percy.snapshot("Home page-STAGE");
		driver.get("https://dcs-staging.cd.pnx.com.au/covid-19");
		percy.snapshot("Covid-19 Landing page-STAGE");

	}

}
