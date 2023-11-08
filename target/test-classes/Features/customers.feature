Feature: Customers

  Scenario: Add new Customer
    Given User launches the chrome browser
    When User opens the url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters the ID as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view the dashboard
    When User clicks on a customers menu
    And Click on customers items
    And Click on Add new button
    Then User can view Add new Customer Page
    When User enter info
    And Click on save
    Then user can view confirmation message "The new customer has been added successfully"
    And Close the page
  
  