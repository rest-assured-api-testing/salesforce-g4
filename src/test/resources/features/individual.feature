Feature: Endpoint Individual

  @GetIndividual
  Scenario: GET to individual
    Given I build "GET" request to individual
    When I use endpoint "sobjects/Individual/{individualId}" request to individual with "individualId"
    And I execute the request individual
    Then the response status code should be "OK" to individual

  @GetIndividual
  Scenario: GET to individual with schema
    Given I build "GET" request to individual
    When I use endpoint "sobjects/Individual/{individualId}" request to individual with "individualId"
    And I execute the request individual
    Then The schema to individual should be equals to "schemas/individual.json"

  @GetIndividual
  Scenario Outline: GET to individual fail
    Given I build "GET" request to individual
    When I use endpoint "sobjects/Individual/{individualId}" request to individual with "individualId" fail <badId>
    And I execute the request individual fail
    Then the response status code fail should be <status> to individual
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PostIndividual
  Scenario: POST to individual
    Given I build "POST" request to individual
    When I use endpoint "sobjects/Individual/" request to individual with name "individual-test"
    Then the response status code should be "CREATED" to individual

  @PostIndividual
  Scenario Outline: POST to individual fail
    Given I build "POST" request to individual
    When I use endpoint "sobjects/Individual/" request to individual with <apiName> and <value>
    Then the response status code fail should be <status> to individual
    Examples:
      | apiName     | value       | status |
      | Name        | Individual1 | 400    |
      | Description | Individual2 | 400    |
      | Firstname   | Individual3 | 400    |
      | LastName    | null        | 201    |
      | null        | Individual4 | 400    |

  @PostIndividual
  Scenario Outline: POST to individual test
    Given I build to "POST" request to individual object
      | firstName  | <firsName>   |
      | lastName   | <lastName>   |
      | Salutation | <salutation> |
      | BirthDate  | <birthdate>  |
    When I set the "sobjects/Individual" endpoint and send the request with body
    Then the response status code fail should be <status> to individual
    Examples:
      | firsName | lastName | salutation | birthdate  | status |
      |          |          |            |            | 400    |
      | null     | null     |            |            | 201    |
      |          | gomez    |            | 2021-01-21 | 201    |
      | jose     | andrade  | Dr.        | 2021-01-21 | 201    |
      | ana      | choque   | Ms.        | 2021-01-21 | 201    |
      |          | lopez    |            |            | 201    |
      |          | perales  |            |            | 201    |
      | maria    | roman    |            | 0000-00-00 | 400    |
      |          | Aranjuez |            | 1999-04-23 | 201    |
      | pablo    | Ramirez  | Mr.        | 1999-06-09 | 201    |

  @DeleteIndividual
  Scenario: POST to individual
    Given I build "DELETE" request to individual
    When I use endpoint "sobjects/Individual/{individualId}" request to individual with "individualId"
    And I execute the request individual
    Then the response status code should be "NO_CONTENT" to individual

  @DeleteIndividual
  Scenario Outline: DELETE to individual fail
    Given I build "DELETE" request to individual
    When I use endpoint "sobjects/Individual/{individualId}" request to individual with "individualId" fail <badId>
    And I execute the request individual
    Then the response status code fail should be <status> to individual
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PatchIndividual
  Scenario: POST to individual
    Given I build "PATCH" request to individual
    When I use endpoint "sobjects/Individual/{individualId}" request to individual with "individualId"
    And I update individual "lastName" to "change lastname"
    Then the response status code should be "NO_CONTENT" to individual

  @PatchIndividual
  Scenario Outline: PATCH to individual fail id
    Given I build "PATCH" request to individual
    When I use endpoint "sobjects/Individual/{individualId}" request to individual with "individualId" fail <badId>
    And I update individual "name" to "change name"
    Then the response status code fail should be <status> to individual
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |
      | null     | 404    |

  @PatchIndividual
  Scenario Outline: PATCH to individual fail body
    Given I build "PATCH" request to individual
    When I use endpoint "sobjects/Individual/{individualId}" request to individual with "individualId"
    And I update individual the <apiName> to <value>
    Then the response status code fail should be <status> to individual
    Examples:
      | apiName   | value    | status |
      | Nameeee   | Account1 | 400    |
      | IsDeleted | Account2 | 400    |
      | null      | Account3 | 400    |
      | Nmme      | null     | 400    |