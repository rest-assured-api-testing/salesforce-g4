Feature: Pivotal
  Test Pivotal methods

  Scenario Outline: Get all Objects
    Given I build "GET" request
    When I execute <SObject> request
    Then the response status code should be "OK"

    Examples:
      | SObject      |
      | Account     |
      | Contact     |
      | Opportunity |

  Scenario Get a Account
    Given I need "GET" request
    When I find <SObject>/{objectId} request
    Then the response status coded is "OK"