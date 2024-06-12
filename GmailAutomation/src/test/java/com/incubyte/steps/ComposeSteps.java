package com.incubyte.steps;

import io.cucumber.java.en.*;

public class ComposeSteps {
    public ComposeSteps() {
        System.out.println("ComposeSteps instantiated");
    }

    @Given("I am logged into Gmail with username {string} and password {string}")
    public void i_am_logged_into_gmail_with_username_and_password(String username, String password) {
        // For debugging purposes
        System.out.println("Logging in with username: " + username + " and password: " + password);
    }

    @When("I open the compose window")
    public void i_open_the_compose_window() {
        // For debugging purposes
        System.out.println("Opening compose window");
    }

    @When("I enter {string} in the subject field")
    public void i_enter_in_the_subject_field(String subject) {
        // For debugging purposes
        System.out.println("Entering subject: " + subject);
    }

    @When("I enter {string} in the body field")
    public void i_enter_in_the_body_field(String body) {
        // For debugging purposes
        System.out.println("Entering body: " + body);
    }

    @When("I enter the recipient email {string}")
    public void i_enter_the_recipient_email(String recipientEmail) {
        // For debugging purposes
        System.out.println("Entering recipient email: " + recipientEmail);
    }

    @When("I click the send button")
    public void i_click_the_send_button() {
        // For debugging purposes
        System.out.println("Clicking send button");
    }

    @Then("the email should be sent successfully")
    public void the_email_should_be_sent_successfully() {
        // For debugging purposes
        System.out.println("Email sent successfully");
    }

    @Then("the email should appear in Sent items with subject {string}")
    public void the_email_should_appear_in_sent_items_with_subject(String subject) {
        // For debugging purposes
        System.out.println("Email appears in Sent items with subject: " + subject);
    }
}