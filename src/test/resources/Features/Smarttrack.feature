Feature: Smart Track login

  Scenario: Login to Smart track page and sign out
    Given a Chrome browser is available
    When login with correct credentials
    And logout and close the browser


  Scenario: Login to Smart track and fill timesheet for a day
    Given a Chrome browser is available
    When login with correct credentials
    Then click on Create Timesheet and fill entry for a day
    And save the timesheet
    And logout and close the browser

