Feature: Endpoint Account

  @GetAccount
  Scenario: GET to product
    Given I build "GET" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to object with "accountId"
    And I execute the request
    Then the response status code should be "OK" to product

  @PostAccount
  Scenario: POST to product
    Given I build "POST" request to account
    When I use endpoint "sobjects/Account/" request to with name "account-test"
    Then the response status code should be "CREATED" to product

  @DeleteAccount
  Scenario: DELETE to product
    Given I build "DELETE" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to object with "accountId"
    And I execute the request
    Then the response status code should be "NO_CONTENT" to product

  @PatchAccount
  Scenario: PATCH to product
    Given I build "PATCH" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to object with "accountId"
    And I update the "description" to "change description"
    Then the response status code should be "NO_CONTENT" to product