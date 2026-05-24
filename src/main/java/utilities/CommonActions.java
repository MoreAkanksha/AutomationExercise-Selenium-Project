package utilities;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

    public static void removeAds(WebDriver driver)
    {
        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                "var elements = document.querySelectorAll("
                + "'iframe[id^=\"aswift\"],"
                + "iframe[name^=\"aswift\"],"
                + "ins.adsbygoogle,"
                + "div[id^=\"google_ads\"],"
                + "iframe[src*=\"googleadservices\"]');"
                + "for(var i=0;i<elements.length;i++)"
                + "{elements[i].remove();}"
            );
        }
        catch(Exception e)
        {
            System.out.println("No Ads Found");
        }
    }

    public static void clickElement(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try
        {
            removeAds(driver);

            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.click();
        }
        catch(Exception e)
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView(true);", element);

            js.executeScript("arguments[0].click();", element);
        }
    }

    public static void sendText(WebDriver driver, WebElement element, String text)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        removeAds(driver);

        wait.until(ExpectedConditions.visibilityOf(element));

        element.clear();

        element.sendKeys(text);
    }
}