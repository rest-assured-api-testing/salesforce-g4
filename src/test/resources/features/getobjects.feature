Feature: Objects
  Test get methods

  @GetAll
  Scenario Outline: Get all Objects
    Given I form a "GET" request
    When I execute request to <Object>
    Then the status response should be <Result>

    Examples:
      | Object      | Result |
      | Account     | 200    |
      | Accoun      | 404    |
      | Contact     | 200    |
      | Contac      | 404    |
      | Opportunity | 200    |
      | Opportunit  | 404    |
      | Product2    | 200    |
      | Product     | 404    |
      | Individual  | 200    |
      | Individul   | 404    |
      | Campaign    | 200    |
      | Campaig     | 404    |
