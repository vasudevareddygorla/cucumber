@app_master_login @ui
Feature: Verify Dashboard page functionality

  @smoke
  Scenario: Dashboard page main content is displayed
    When I click on the menu item "Dashboard"
    Then I wait until the loading indicator disappears
    And the main content should be displayed
    And I should see the header title "Dashboard"