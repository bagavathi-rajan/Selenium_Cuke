Feature: Magento Online Shopping cart
  #Is the correct price getting displayed in the shopping cart for the selected product/s?

  #Can a user select different size, color and quantity of the product?

  ## Testing the Shopping Cart of the e-commerce website
  #Is the correct price getting displayed in the shopping cart for the selected product/s?
  #Is there an option to apply coupon codes?
  #Can a user increase or decrease the quantity of  a product from the shopping cart?
  #Can a user remove the product from the shopping cart?


  ##Testing the Checkout Flow and Order Confirmation
  #Does user able to enter shipping and billing information or is it auto filled, if the user already saved it?
  #Are all the supported payments methods working?


  #Can a guest able to  register on the website easily?
  @Registration_Test
  Scenario: Registering on a website
    Given a Chrome browser is available for testing
    When the Online shopping portal is launched
    Then Click on Create an Account
    And provide all the required information and register
    Then verify the successful registration message
    And logout from the account and close browser

  #Can a registered user able to view all the products listed on the website?
  @Login_Test
  Scenario: Login to the registered account and view products
    Given a Chrome browser is available for testing
    When the user registers and logins with correct credentials
    Then logout from the account and close browser


  #Choose a selected item and add it in cart and checkout
  @Successful_Checkout
  Scenario: To verify if user can choose an item and check it out
    Given a Chrome browser is available for testing
    When the user registers and logins with correct credentials
    Then user choose the selected item and added to shopping cart
    And user checks out the items
    Then order is successful
    Then logout from the account and close browser


  #Is website having multiple filters to search products like., price range, category, brands etc.?
  @Sort_Test
  Scenario: Verify if sort functionality is working correctly
    Given a Chrome browser is available for testing
    When the user registers and logins with correct credentials
    And user choose the product type
    Then sort the products with price order
    And all the items should be displayed in price low to high order
    Then logout from the account and close browser

  #Is website having multiple filters to search products like., price range, category, brands etc.?
  @Filter_Test
  Scenario: Verify if filters are working correctly
    Given a Chrome browser is available for testing
    When the user registers and logins with correct credentials
    And user choose the product type
    Then filter based on category
    And all the items should be displayed as per filter
    Then logout from the account and close browser

    #Are relevant Products are displaying after applying single or multiple search filters?
  @Search_Text_Test
  Scenario: To verify if user can search a product using search box
    Given a Chrome browser is available for testing
    When the user registers and logins with correct credentials
    Then user searches for a product using search box
    And all the product related to search are displayed
    Then logout from the account and close browser

    #Can a user select different size, color and quantity of the product?
  @Update_Cart_Test
  Scenario: To verify if user can update the product from shopping cart
    Given a Chrome browser is available for testing
    When the user registers and logins with correct credentials
    Then user choose the selected item and added to shopping cart
    And user to choose the added items from shopping cart and update it
    And user checks out the item and order is successful
    Then logout from the account and close browser

   ##Negative Scenarios
   #Verify invalid email address error.
  @Invalid_mail_Test
  Scenario: To verify if email address is valid or not
    Given a Chrome browser is available for testing
    When the user registers with invalid email address
    Then there should be an error for invalid email

    #Verify invalid password error.
  @Invalid_password_Test
  Scenario: To verify if password entered is valid or not
    Given a Chrome browser is available for testing
    When the user registers with invalid password
    Then there should be an error for invalid password

    #Basic Actions
  @Right_Click_Test
  Scenario: Verify if right click is enabled and able to perform operations
    Given a Chrome browser is available for testing
    When user right clicks on a link
    Then right click operations are performed

  @Click_And_Hold_Test
  Scenario: Verify if click and hold works fine
    Given a Chrome browser is available for testing
    When user clicks and hold an element
    Then user should be able to see the actions

  @Scroll_Page_Test
  Scenario: Verify if Scroll bar/page works fine
    Given a Chrome browser is available for testing
    When user launches browser and scrolls the page
    Then user should be able to see the bottom of the page

  @Refresh_Page_Test
  Scenario: Verify if user can refresh the page
    Given a Chrome browser is available for testing
    When user launches browser and refreshes the page
    Then user should be able to see the page refreshed