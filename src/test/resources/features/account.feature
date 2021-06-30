Feature: Endpoint Account

  @GetAccount
  Scenario: GET to account
    Given I build "GET" request
    When I use endpoint "sobjects/Account/{accountId}" request with "accountId"
    And I execute the request
    Then The response status code should be "OK"

  @GetAccount
  Scenario: GET to account with schema
    Given I build "GET" request
    When I use endpoint "sobjects/Account/{accountId}" request with "accountId"
    And I execute the request
    Then The schema should be equals to "schemas/account.json"

  @GetAccount
  Scenario Outline: GET to account fail
    Given I build "GET" request
    When I use endpoint "sobjects/Account/{accountId}" request with "accountId" and <badId>
    And I execute the request
    Then the response status code fail should be <status>
    Examples:
      | badId |status|
      | 12341415 | 404 |
      | null     | 404 |

  @PostAccount
  Scenario: POST to account
    Given I build "POST" request
    When I use endpoint "sobjects/Account/" request to account with name "account-test"
    Then The response status code should be "CREATED"

  @PostAccount
  Scenario Outline: POST to account fail
    Given I build "POST" request
    When I use endpoint "sobjects/Account/" request with <apiName> and <value> to fail
    Then the response status code fail should be <status>
    Examples:
      | apiName      | value    | status|
      | Nameeee      | Account1 | 400 |
      | Description  | Account2 | 400 |
      | null         | Account3 | 400 |

  @DeleteAccount
  Scenario: DELETE to account
    Given I build "DELETE" request
    When I use endpoint "sobjects/Account/{accountId}" request with "accountId"
    And I execute the request
    Then The response status code should be "NO_CONTENT"

  @DeleteAccount
  Scenario Outline: DELETE to account fail
    Given I build "DELETE" request
    When I use endpoint "sobjects/Account/{accountId}" request with "accountId" and <badId>
    And I execute the request
    Then the response status code fail should be <status>
    Examples:
      | badId |status|
      | 12341415 | 404 |
      | null     | 404|

  @PatchAccount
  Scenario: PATCH to account
    Given I build "PATCH" request
    When I use endpoint "sobjects/Account/{accountId}" request with "accountId"
    And I update account "name" to "change name"
    Then The response status code should be "NO_CONTENT"

  @PatchAccount
  Scenario Outline: PATCH to account fail id
    Given I build "PATCH" request
    When I use endpoint "sobjects/Account/{accountId}" request with "accountId" and <badId>
    And I update account "name" to "change name"
    Then the response status code fail should be <status>
    Examples:
      | badId |status|
      | 12341415 | 404 |
      | null     | 404|

  @PatchAccount
  Scenario Outline: PATCH to account fail body
    Given I build "PATCH" request
    When I use endpoint "sobjects/Account/{accountId}" request with "accountId"
    And I update the <apiName> to <value>
    Then the response status code fail should be <status>
    Examples:
      | apiName      | value    | status|
      | Nameeee      | Account1 | 400 |
      | IsDeleted    | Account2 | 400 |
      | null         | Account3 | 400 |
      | Nmme         | null     | 400 |