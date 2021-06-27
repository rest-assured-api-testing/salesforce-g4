Feature: Endpoint Account

  @GetAccount
  Scenario: GET to account
    Given I build "GET" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId"
    And I execute the request account
    Then the response status code should be "OK" to account

  @GetAccount
  Scenario Outline: GET to account fail
    Given I build "GET" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId" fail <badId>
    And I execute the request account fail
    Then the response status code fail should be <status> to account
    Examples:
      | badId |status|
      | 12341415 | 404 |
      | null     | 404 |

  @PostAccount
  Scenario: POST to account
    Given I build "POST" request to account
    When I use endpoint "sobjects/Account/" request to account with name "account-test"
    Then the response status code should be "CREATED" to account

  @PostAccount
  Scenario Outline: POST to account fail
    Given I build "POST" request to account
    When I use endpoint "sobjects/Account/" request to account with <apiName> and <value>
    Then the response status code fail should be <status> to account
    Examples:
      | apiName      | value    | status|
      | Nameeee      | Account1 | 400 |
      | Description  | Account2 | 400 |
      | null         | Account3 | 400 |

  @DeleteAccount
  Scenario: DELETE to account
    Given I build "DELETE" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId"
    And I execute the request account
    Then the response status code should be "NO_CONTENT" to account

  @DeleteAccount
  Scenario Outline: DELETE to account fail
    Given I build "DELETE" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId" fail <badId>
    And I execute the request account
    Then the response status code fail should be <status> to account
    Examples:
      | badId |status|
      | 12341415 | 404 |
      | null     | 404|

  @PatchAccount
  Scenario: PATCH to account
    Given I build "PATCH" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId"
    And I update account "name" to "change name"
    Then the response status code should be "NO_CONTENT" to account

  @PatchAccount
  Scenario Outline: PATCH to account fail id
    Given I build "PATCH" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId" fail <badId>
    And I update account "name" to "change name"
    Then the response status code fail should be <status> to account
    Examples:
      | badId |status|
      | 12341415 | 404 |
      | null     | 404|

  @PatchAccount
  Scenario Outline: PATCH to account fail body
    Given I build "PATCH" request to account
    When I use endpoint "sobjects/Account/{accountId}" request to account with "accountId"
    And I update account the <apiName> to <value>
    Then the response status code fail should be <status> to account
    Examples:
      | apiName      | value    | status|
      | Nameeee      | Account1 | 400 |
      | IsDeleted    | Account2 | 400 |
      | null         | Account3 | 400 |
      | Nmme         | null     | 400 |