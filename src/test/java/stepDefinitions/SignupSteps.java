package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.SignupPage;
import utilities.ConfigReader;

public class SignupSteps extends BaseClass {

    SignupPage signupPage;

    ConfigReader configReader = new ConfigReader();

    String uniqueEmail;

    @Given("user is on register page")
    public void user_is_on_register_page() {

        signupPage = new SignupPage(driver);

        signupPage.openRegisterPage();
    }

    @When("user enters valid registration details")
    public void user_enters_valid_registration_details() {

        uniqueEmail = "testuser" + System.currentTimeMillis() + "@test.com";

        signupPage.enterSignupName("Akanksha");

        signupPage.enterSignupEmail(uniqueEmail);
//        signupPage.enterSignupEmail("akanksha04@gmail.com");

        signupPage.clickSignupButton();

        Assert.assertTrue(signupPage.isAccountInformationDisplayed());

        signupPage.selectTitle("Mrs");

        signupPage.enterPassword("Test@123");

        signupPage.selectDateOfBirth("10", "May", "2002");

        signupPage.selectNewsletterIfRequired(true);

        signupPage.selectSpecialOfferIfRequired(true);

        signupPage.enterFirstName("Akanksha");

        signupPage.enterLastName("More");

        signupPage.enterCompany("Automation Company");

        signupPage.enterAddress("Pune, Maharashtra");

        signupPage.selectCountry("India");

        signupPage.enterState("Maharashtra");

        signupPage.enterCity("Pune");

        signupPage.enterZipcode("411001");

        signupPage.enterMobileNumber("9876543210");
    }

    @And("user clicks create account button")
    public void user_clicks_create_account_button() {

        signupPage.clickCreateAccountButton();
    }

    @Then("verify successful account creation")
    public void verify_successful_account_creation() {

        Assert.assertTrue(signupPage.isAccountCreatedMessageDisplayed());

        signupPage.clickContinueButton();
    }

    @When("user enters existing email")
    public void user_enters_existing_email() {

        signupPage.enterSignupName("Akanksha More");

        signupPage.enterSignupEmail(configReader.getExistingEmail());

        signupPage.clickSignupButton();
    }

    @Then("user gets email already existing message")
    public void user_gets_email_already_existing_message() {

        Assert.assertTrue(signupPage.isExistingEmailMessageDisplayed());
    }

    @When("user clicks signup without entering details")
    public void user_clicks_signup_without_entering_details() {

        signupPage.clickSignupButton();
    }

    @Then("verify validation message")
    public void verify_validation_message() {

        String validationMessage = signupPage.getNameValidationMessage();

        Assert.assertTrue(validationMessage.length() > 0);
    }

    @Then("verify account created message")
    public void verify_account_created_message() {

        Assert.assertTrue(signupPage.isAccountCreatedMessageDisplayed());

        signupPage.clickContinueButton();
    }

    @Then("verify new user signup text is visible")
    public void verify_new_user_signup_text_is_visible() {

        Assert.assertTrue(signupPage.isNewUserSignupTextVisible());
    }
}