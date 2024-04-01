@app_master_login @ui
Feature: Verify Subscriptions page functionality

  @smoke
  Scenario: Subscriptions page main content is displayed
    When I click on the menu item "Subscriptions"
    Then the main content should be displayed
    And I should see the header title "Active Subscription List"
    