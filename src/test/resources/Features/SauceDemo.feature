Feature: Online shopping

  #Testing Search feature of the Online Shopping Website
  Scenario: To verify if sort option available on the search page and is that working properly.
    Given a Chrome browser is available for test
    When the website is successfully entered with correct credentials
    Then search for filters in the screen
    And filter with ascending order
    And filter with descending order
    And filter with low to high order
    And filter with high to low order
    And logout from the session

