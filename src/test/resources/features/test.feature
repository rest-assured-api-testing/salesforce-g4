Feature: SalesForces
  Test SalesForces methods

  @CreateGroup
  Scenario: Create Group
    Given I build "POST" request to create group with name "Test-group" and visibility "PublicAccess"
    When I execute "chatter/groups" request to create a group
    Then the response status code should be successful in order to be "200"

  @CreateProduct
  Scenario: Create a Product
    Given I build "POST" request with ID of project with name "Product-test-cucumber"
    When I execute "sobjects/Product2/" request to be create in a product
    Then The response status code should be successful "ok"

  @CreateAccount
  Scenario: Create a Account
    Given I create a product with method "POST"  with name "Account-test-cucumber"
    When I execute "sobjects/Account" request to be create in a Account
    Then The response status code should be successful "ok" with account created

  @CreateContact
  Scenario: Create Contact
    Given  I create a contact with method "POST" with name "Contact-test-cucumber"
    When I execute "sobjects/Contact" request to be create in a Contact
    Then The response status code should be successful "ok" with contact created

  @CreateOpportunity
  Scenario: Create a Opportunity
    Given  I create a opportunity with method "POST"  with name "Opportunity-test-cucumber"
    When I execute "sobjects/Opportunity" request to be create in a Opportunity
    Then The response status code should be successful "ok" with opportunity created

  @GetToken
  Scenario: Get a token
    When I execute token request to get token bearer
    Then The new token should be type "Bearer"
