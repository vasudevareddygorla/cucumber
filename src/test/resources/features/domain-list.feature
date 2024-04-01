@app_master_login @ui
Feature: Verify Domain List page functionality

  @smoke
  Scenario: Domain List page main content is displayed
    When I click on the menu item "Domain List"
    Then the main content should be displayed