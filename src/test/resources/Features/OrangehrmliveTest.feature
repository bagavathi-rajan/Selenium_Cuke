Feature: Orange HRM Live Tests

  Scenario: Login and filter with Employee timesheets
    Given Chrome browser is available
    When login with correct credentials
    Then access the timesheet menu and click employee record dropdown
    And choose name from employee list and click on view
    And click on logout