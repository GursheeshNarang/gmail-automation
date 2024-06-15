package com.incubyte.steps;

import com.incubyte.pages.ComposePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ComposeSteps {
    ComposePage composePage = new ComposePage();

    @Given("I am logged into Gmail with username and password")
    public void i_am_logged_into_gmail_with_username_and_password() {
        composePage.login();
    }

    @When("I enter {string} in the subject field")
    public void i_enter_in_the_subject_field(String subject) {
        composePage.enterSubject(subject);
    }

    @When("I enter {string} in the body field")
    public void i_enter_in_the_body_field(String body) {
        composePage.enterBody(body);
    }

    @When("I enter the recipient email")
    public void i_enter_the_recipient_email() {
        composePage.enterRecipient();
    }

    @When("I click the send button")
    public void i_click_the_send_button() {
        composePage.clickSend();
    }

    @Then("the email should be sent successfully")
    public void the_email_should_be_sent_successfully() {
        composePage.verifyEmailSent();
    }

    @Then("the email should appear in Sent items with subject {string}")
    public void the_email_should_appear_in_sent_items_with_subject(String subject) {
        composePage.verifyEmailInSentItems(subject);
    }
}
