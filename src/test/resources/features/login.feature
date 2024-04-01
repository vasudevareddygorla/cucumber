@ui
Feature: Verify the Clipbook Login page functionality

  Scenario: Verify the user is on login page
    When I am on the login page
    Then I can see the login page title "ADMIN LOGIN" : true

  @app_master_login @smoke
  Scenario: Login to the application as APP_MASTER
    Then I should see the header title "Report List"

  @clip_master_login @smoke
  Scenario: Login to the application as CLIP_MASTER
    Then I should see the header title "Report List"

  Scenario: Without entering email and password the submit button should be disabled
    When I am on the login page
    Then I can see submit button is enabled: false

  Scenario: Verify the user is navigated to forgot password page
    Given I am on the login page
    When I click on the forgot password click here button
    Then I can see the login page title "FORGET PASSWORD ?" : true