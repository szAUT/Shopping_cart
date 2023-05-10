Feature: User can purchase a product on the e-commerce website


Scenario: User can login
  Given I am on the login page
    When I enter valid credentials
    And I click on the login button
    Then I should be logged in

@Before
  Scenario: User can add a product to the cart
    When the user clicks the "Add to Cart" button
    Then the product is added to the cart
    And the cart contains the added product

  @Before
  Scenario: User can proceed to checkout and validate shipping and payment details
    Given I have one product in my cart
    And I am on the cart page
    When I click on the checkout button
    Then I should be on the checkout page

  @Before @After
  Scenario: User can complete the purchase and validate the confirmation page
    Given I have one product in my cart
    And I am on the checkout page
    And I fill in my shipping details
    When I click on the complete purchase button
    Then I should see a confirmation message