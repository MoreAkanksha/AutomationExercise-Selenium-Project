package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonActions;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "address_delivery")
    WebElement deliveryAddress;

    @FindBy(id = "address_invoice")
    WebElement billingAddress;

    @FindBy(xpath = "//tbody/tr")
    WebElement orderReviewProduct;

    @FindBy(name = "message")
    WebElement message;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    WebElement placeOrderBtn;

    @FindBy(name = "name_on_card")
    WebElement nameOnCard;

    @FindBy(name = "card_number")
    WebElement cardNumber;

    @FindBy(name = "cvc")
    WebElement cvc;

    @FindBy(name = "expiry_month")
    WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    WebElement expiryYear;

    @FindBy(id = "submit")
    WebElement payAndConfirmOrderBtn;

    @FindBy(xpath = "//b[contains(text(),'Order Placed!')]")
    WebElement orderPlacedMessage;

    public boolean isAddressDetailsDisplayed() {
        return deliveryAddress.isDisplayed() && billingAddress.isDisplayed();
    }

    public boolean isOrderReviewDisplayed() {
        return orderReviewProduct.isDisplayed();
    }

    public void enterMessage(String msg) {
        message.sendKeys(msg);
    }

    public void clickPlaceOrder() {
        placeOrderBtn.click();
    }

    public void enterPaymentDetails(String name, String cardNo, String cvv, String month, String year) {

        nameOnCard.sendKeys(name);

        cardNumber.sendKeys(cardNo);

        cvc.sendKeys(cvv);

        expiryMonth.sendKeys(month);

        expiryYear.sendKeys(year);
    }

//    public void clickPayAndConfirmOrder() {
//        payAndConfirmOrderBtn.click();
//    }

    public void clickPayAndConfirmOrder() {

        CommonActions.clickElement(driver, payAndConfirmOrderBtn);
    }
    public boolean isOrderPlacedMessageDisplayed() {
        return orderPlacedMessage.isDisplayed();
    }
}