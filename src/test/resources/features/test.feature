Feature: SalesForces
  Test SalesForces methods

  @CreateProject
  Scenario: Create Group
    Given I build "POST" request to create group with name "Test-group" and visibility "PublicAccess"
    When I execute "chatter/groups" request to create a group
    Then the response status code should be successful in order to be "200"

  Scenario: Create a Product
    Given I build "POST" request with ID of project with name "Product-test-cucumber"
    When I execute "sobjects/Product2/" request to be create in a product
    Then The response status code should be successful "ok"

  Scenario: Get a token
    When I execute toke request
    Then The new token should be type "Bearer"