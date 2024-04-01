@app_master_login @ui
Feature: Verify Settings page functionality

  @smoke
  Scenario: Settings page main content is displayed
    When I click on the menu item "Settings"
    Then the main content should be displayed