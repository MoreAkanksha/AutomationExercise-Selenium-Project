package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginSteps extends BaseClass {

    LoginPage loginPage;

    ConfigReader configReader = new ConfigReader();

    @Given("User launches browser")
    public void user_launches_browser() {

        loginPage = new LoginPage(driver);

        loginPage.clickSignupLogin();
    }

    @When("User enters valid email and password")
    public void user_enters_valid_email_and_password() {

        loginPage.enterEmail(configReader.getUsername());

        loginPage.enterPassword(configReader.getPassword());
    }

    @When("User enters invalid email and password")
    public void user_enters_invalid_email_and_password() {

        loginPage.enterEmail("invalid@test.com");

        loginPage.enterPassword("invalid@123");
    }

    @And("User clicks login button")
    public void user_clicks_login_button() {

        loginPage.clickLoginButton();
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {

        Assert.assertTrue(loginPage.verifyLoginSuccess());
    }

    @Then("Error message should display")
    public void error_message_should_display() {

        Assert.assertTrue(loginPage.verifyErrorMessage());
    }

    @When("User clicks logout button")
    public void user_clicks_logout_button() {

        loginPage.clickLogoutButton();
    }

    @Then("User should logout successfully")
    public void user_should_logout_successfully() {

        Assert.assertTrue(loginPage.verifyLogoutSuccess());
    }

    @Then("Verify login error message text")
    public void verify_login_error_message_text() {

        String expectedMessage = "Your email or password is incorrect!";

        String actualMessage = loginPage.getErrorMessageText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}