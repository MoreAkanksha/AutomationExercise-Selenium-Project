package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

    public static void clickElement(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try
        {
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
}