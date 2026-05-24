package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver initializeDriver(String browser)
	{
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--remote-allow-origins=*");

			driver= new ChromeDriver(options);
			
//			driver=new ChromeDriver();						
		} else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		return driver;
	}
}
