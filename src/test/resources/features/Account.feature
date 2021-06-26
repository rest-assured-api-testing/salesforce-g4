Feature: Endpoint Account

  @GetAccount
  Scenario: GET to account
    Given I build "GET" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId"
    And I execute the request account
    Then the response status code should be "OK" to account

  @PostAccount
  Scenario: POST to account
    Given I build "POST" request to account
    When I use endpoint "sobjects/Account/" request to account with name "account-test"
    Then the response status code should be "CREATED" to account

  @DeleteAccount
  Scenario: DELETE to account
    Given I build "DELETE" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId"
    And I execute the request
    Then the response status code should be "NO_CONTENT" to account

  @PatchAccount
  Scenario: PATCH to account
    Given I build "PATCH" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId"
    And I update account "name" to "change name"
    Then the response status code should be "NO_CONTENT" to account