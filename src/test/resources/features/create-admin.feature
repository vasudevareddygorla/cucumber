@app_master_login @ui
Feature: Verify create admin page functionality

  @smoke
  Scenario: create admin page main content is displayed
    When I click on the menu item "Create Admin"
    Then the main content should be displayed