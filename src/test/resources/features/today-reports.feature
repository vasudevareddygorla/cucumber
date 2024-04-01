@app_master_login @ui
Feature: Verify Today Reports page functionality

  @smoke
  Scenario: Today Reports page main content is displayed is displayed
    Then the main content should be displayed
    And I should see the header title "Report List"