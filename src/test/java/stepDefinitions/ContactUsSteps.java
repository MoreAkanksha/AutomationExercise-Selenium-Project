package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.ContactUsPage;

public class ContactUsSteps extends BaseClass {

    ContactUsPage contactUsPage;

    @Given("User opens contact form")
    public void user_opens_contact_form() {

        contactUsPage = new ContactUsPage(driver);

        contactUsPage.openContactForm();
    }

    @When("User enters contact details")
    public void user_enters_contact_details() {

        contactUsPage.enterName("Akanksha");

        contactUsPage.enterEmail("akanksha@test.com");

        contactUsPage.enterSubject("Automation Testing");

        contactUsPage.enterMessage("This is contact us form testing.");
    }

    @And("User uploads file")
    public void user_uploads_file() {

        String filePath = System.getProperty("user.dir") + "/README.md";

        contactUsPage.uploadFile(filePath);
    }

    @And("User submits contact form")
    public void user_submits_contact_form() {

        contactUsPage.clickSubmit();

        driver.switchTo().alert().accept();
    }

    @Then("Form should submit successfully")
    public void form_should_submit_successfully() {
        Assert.assertTrue(contactUsPage.isFormSubmitted());
    }

    @Then("Contact success message should display")
    public void contact_success_message_should_display() {
        Assert.assertTrue(contactUsPage.isFormSubmitted());
    }
}