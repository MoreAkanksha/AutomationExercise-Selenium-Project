package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonActions;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(xpath = "//button[contains(@class,'cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement viewCartLink;

//    public void updateQuantity(String quantity) {
//
//        quantityInput.clear();
//
//        quantityInput.sendKeys(quantity);
//    }

    public void updateQuantity(String qty) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//      wait.until(ExpectedConditions.visibilityOf(quantityInput));
        wait.until(ExpectedConditions.elementToBeClickable(quantityInput));

        quantityInput.clear();
        quantityInput.sendKeys(qty);
    }
    
    public void clickAddToCart() {
//        addToCartButton.click();
    	CommonActions.clickElement(driver, addToCartButton);
    }

    public void clickViewCart() {
        viewCartLink.click();
    }
}