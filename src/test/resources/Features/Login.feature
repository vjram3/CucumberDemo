Feature: Login

  Scenario: To validate login functionality
    Given User launches the chrome browser
    When User opens the url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters the ID as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page title should be "HOME"
    

 