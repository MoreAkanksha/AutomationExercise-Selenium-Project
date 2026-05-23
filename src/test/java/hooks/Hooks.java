package hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.ScreenshotUtil;

public class Hooks extends BaseClass {

	ConfigReader configReader=new ConfigReader();
	
	@Before
	public void setup()
	{
		initialization(configReader.getBrowser());
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			ScreenshotUtil.captureScreenshot(scenario.getName());
			
		}
		closeBrowser();
	}
}
