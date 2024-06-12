Feature: Compose Email
  Scenario: Send an email with subject "Incubyte" and body "Automation QA test for Incubyte"
    Given I am logged into Gmail with username "emaildemoincubyte@gmail.com" and password "demoPassword123"
    When I open the compose window
    And I enter "Incubyte" in the subject field
    And I enter "Automation QA test for Incubyte" in the body field
    And I enter the recipient email "gursheeshnarang2001@gmail.com"
    And I click the send button
    Then the email should be sent successfully
    And the email should appear in Sent items with subject "Incubyte"