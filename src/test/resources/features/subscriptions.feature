@app_master_login @ui
Feature: Verify Subscriptions page functionality

  @smoke
  Scenario: Subscriptions page main content is displayed
    When I click on the menu item "Subscriptions"
    Then the main content should be displayed
    And I should see the header title "Active Subscription List"

  Scenario: Verify no duplicate listing are present
    Given I click on the menu item "Subscriptions"
    And I click on "Press Report" of "Cipla" subscription
    When I wait until the loading indicator disappears
    Then I should see duplicate paragraphs within each listing:false
    