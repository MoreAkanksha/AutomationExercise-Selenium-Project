package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement cartBtn;

    @FindBy(xpath = "//li[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartTitle;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement checkoutBtn;

    @FindBy(xpath = "//a[contains(@class,'cart_quantity_delete')]")
    WebElement deleteBtn;

//  @FindBy(id = "empty_cart")
    @FindBy(xpath = "//p[contains(text(),'Cart is empty')]")
    WebElement emptyCartMessage;
    
    @FindBy(xpath = "//tr[@id='product-1']")
    WebElement cartProduct;

    @FindBy(xpath = "//button[@class='disabled']")
    WebElement cartQuantity;

    @FindBy(xpath = "//td[@class='cart_price']/p")
    WebElement cartPrice;

    @FindBy(xpath = "//td[@class='cart_total']/p")
    WebElement cartTotal;

    public void clickCart() {
        cartBtn.click();
    }

    public boolean isCartPageDisplayed() {
        return shoppingCartTitle.isDisplayed();
    }

    public void clickCheckout() {
        checkoutBtn.click();
    }

    public void removeProduct() {
        deleteBtn.click();
    }

//    public boolean isCartUpdated() {
//        return emptyCartMessage.isDisplayed();
//    }
//    
//    public boolean isCartUpdated() {
//
//        try {
//            return !cartProduct.isDisplayed();
//        } catch (Exception e) {
//            return true;
//        }
//    }
    
//    public boolean isCartUpdated() {
//
//        return driver.findElements(By.xpath("//tr[contains(@id,'product')]")).size() == 0;
//    }
    public boolean isCartUpdated() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.xpath("//tr[contains(@id,'product')]")));

            return driver.findElements(
                    By.xpath("//tr[contains(@id,'product')]")).size() == 0;

        } catch (Exception e) {

            return false;
        }
    }

    public int getProductQuantity() {
        return Integer.parseInt(cartQuantity.getText().trim());
    }

    public int getProductPrice() {
        return Integer.parseInt(cartPrice.getText().replaceAll("[^0-9]", ""));
    }

    public int getProductTotal() {
        return Integer.parseInt(cartTotal.getText().replaceAll("[^0-9]", ""));
    }

    public boolean isTotalAmountCorrect() {
        return getProductTotal() == getProductPrice() * getProductQuantity();
    }
}