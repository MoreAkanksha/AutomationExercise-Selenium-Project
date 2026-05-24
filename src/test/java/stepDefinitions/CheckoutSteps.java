package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.ConfigReader;

public class CheckoutSteps extends BaseClass {

    CartPage cartPage;

    CheckoutPage checkoutPage;

    ProductPage productPage;

    LoginPage loginPage;

    ConfigReader configReader = new ConfigReader();

    @Given("User is logged in and has product in cart")
    public void user_is_logged_in_and_has_product_in_cart() {

        loginPage = new LoginPage(driver);

        loginPage.clickSignupLogin();

        loginPage.enterEmail(configReader.getUsername());

        loginPage.enterPassword(configReader.getPassword());

        loginPage.clickLoginButton();

        productPage = new ProductPage(driver);

        productPage.clickProducts();

        productPage.addToCart();

        productPage.clickViewCart();
    }

    @Given("User proceeds checkout")
    public void user_proceeds_checkout() {

        cartPage = new CartPage(driver);

        cartPage.clickCart();

        cartPage.clickCheckout();

        checkoutPage = new CheckoutPage(driver);
    }

    @When("User proceeds to checkout from cart")
    public void user_proceeds_to_checkout_from_cart() {

        cartPage = new CartPage(driver);

        cartPage.clickCheckout();

        checkoutPage = new CheckoutPage(driver);
    }

    @Then("Checkout address details should display")
    public void checkout_address_details_should_display() {
        Assert.assertTrue(checkoutPage.isAddressDetailsDisplayed());
    }

    @Then("Order review should display")
    public void order_review_should_display() {
        Assert.assertTrue(checkoutPage.isOrderReviewDisplayed());
    }

    @When("User enters order message")
    public void user_enters_order_message() {
        checkoutPage.enterMessage("Please deliver this order safely.");
    }

    @And("User clicks place order")
    public void user_clicks_place_order() {
        checkoutPage.clickPlaceOrder();
    }

    @And("User enters payment details")
    public void user_enters_payment_details() {

        checkoutPage.enterPaymentDetails(
                "Akanksha More",
                "4111111111111111",
                "123",
                "12",
                "2030"
        );
    }

    @And("User clicks pay and confirm order")
    public void user_clicks_pay_and_confirm_order() {
        checkoutPage.clickPayAndConfirmOrder();
    }

    @Then("Order should place successfully")
    public void order_should_place_successfully() {
        Assert.assertTrue(checkoutPage.isOrderPlacedMessageDisplayed());
    }
}