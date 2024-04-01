@app_master_login @ui
Feature: Verify Add Subscription page functionality

  @smoke
  Scenario: Add Subscription page main content is displayed
    Given I click on the menu item "Add Subscription"
    When I wait for Add Subscription page to load
    Then the main content should be displayed
    And I should see Add Subscription page header title "New Subscription"

  Scenario: create a new subscription
    Given I click on the menu item "Add Subscription"
    #And I wait for Add Subscription page to load
    And I select "VasuDeva" as the Account Manager
    And I enter following input fields with values
      | Field Name       | Field Value                             |
      | Name             | Vasu                                    |
      | Greeting         | Good Morning,                           |
      | TO List          | vasudeva@clipbook.io                    |
      | CC List          | eric@clipbook.io, developer@clipbook.io |
      | Header Limit     | 0                                       |
      | Header Name      | Latest News                             |
      | Term Of Interest | Elelction                               |
    And I chose the following values from the select fields
      | Selector Name       | Dropdown Value              |
      | Pressclips Schedule | Monday                      |
      | Timezone            | Alaska Standard Time (AKST) |
      | Send Time           | 8:00 am                     |
    And I perform action on below switches
      | Switch Name | Action |
      | Auto Email  | enable |
    And I perform action on "Auto-email schedule" checkboxes
      | Checkbox | Action |
      | Monday   | select |
    When I click ADD button
    Then I see popup displayed: true
    And I close the popup
