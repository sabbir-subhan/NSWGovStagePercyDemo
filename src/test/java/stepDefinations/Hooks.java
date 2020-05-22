package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.DriverFactory;

public class Hooks{
	
	DriverFactory Df=new DriverFactory();
	
	@Before
	public void beforeEachSceanario() {
		Df.createDriver();
	}
	@After
	public void afterEachSceanario() {
		Df.closeBrowser();
	}
	
	
	

}
