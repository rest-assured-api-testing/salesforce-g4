Feature: Objects
  Test get methods

  @GetAllObjects
  Scenario Outline: Get all Objects
    Given I build "GET" request
    When I execute <SObject> request
    Then the response status code should be "OK"

    Examples:
      | SObject     |
      | Account     |
      | Contact     |
      | Opportunity |
      | Product2    |


