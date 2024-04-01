@app_master_login @ui
Feature: Verify Outlet Names page functionality

  @smoke
  Scenario: Outlet Names page main content is displayed
    When I click on the menu item "Outlet Names"
    Then the main content should be displayed