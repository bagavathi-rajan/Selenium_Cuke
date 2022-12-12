Feature: Login to webpage

Scenario: Successful login
    Given Open the Chrome and launch the application
    When Enter the Username and Password
    Then Click on Sign in
    And Click on logout

Scenario: Navigate to the client node ID page and filter with client node id
    Given Open the Chrome and launch the application
    When Enter the Username and Password
    Then Click on Sign in
    And Navigate to client node ID page
    And Filter with client node ID
    And Click on logout

Scenario: Choose Channels page and filter with Local port field
    Given Chrome browser is available
    When credentials are entered and signed in
    Then Navigate to Channels page
    And Filter with Local Port and click on search
    And Click on logout

Scenario: Add new record in IICGroup page and delete
    Given Chrome browser is available
    When credentials are entered and signed in
    Then Navigate to IICGroup page
    And add new record in IICGroup and save
    And verify if newly added record is visible in main page
    Then delete the newly added entry using action menu