package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;
import utilities.DriverFactory;

public class BaseClass {

	public static WebDriver driver;
	
	public void initialization(String browser)
	{
		ConfigReader configReader =new ConfigReader();
		driver= DriverFactory.initializeDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(configReader.getUrl());
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
}
