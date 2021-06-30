Feature: Endpoint Individual

  @GetIndividual
  Scenario: GET to individual
    Given I build "GET" request
    When I use endpoint "sobjects/Individual/{individualId}" request with "individualId"
    And I execute the request
    Then The response status code should be "OK"

  @GetIndividual
  Scenario: GET to individual with schema
    Given I build "GET" request
    When I use endpoint "sobjects/Individual/{individualId}" request with "individualId"
    And I execute the request
    Then The schema should be equals to "schemas/individual.json"

  @GetIndividual
  Scenario Outline: GET to individual fail
    Given I build "GET" request
    When I use endpoint "sobjects/Individual/{individualId}" request with "individualId" and <badId>
    And I execute the request
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PostIndividual
  Scenario: POST to individual
    Given I build "POST" request
    When I use endpoint "sobjects/Individual/" request to individual with name "individual-test"
    Then The response status code should be "CREATED"

  @PostIndividual
  Scenario Outline: POST to individual fail
    Given I build "POST" request
    When I use endpoint "sobjects/Individual/" request with <apiName> and <value> to fail
    Then the response status code fail should be <status>
    Examples:
      | apiName     | value       | status |
      | Name        | Individual1 | 400    |
      | Description | Individual2 | 400    |
      | Firstname   | Individual3 | 400    |
      | LastName    | null        | 201    |
      | null        | Individual4 | 400    |

  @PostIndividual
  Scenario Outline: POST to individual test
    Given I build to "POST" request to object
      | firstName  | <firsName>   |
      | lastName   | <lastName>   |
      | Salutation | <salutation> |
      | BirthDate  | <birthdate>  |
    When I set the "sobjects/Individual" endpoint and send the request with body
    Then the response status code fail should be <status>
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
    Given I build "DELETE" request
    When I use endpoint "sobjects/Individual/{individualId}" request with "individualId"
    And I execute the request
    Then The response status code should be "NO_CONTENT"

  @DeleteIndividual
  Scenario Outline: DELETE to individual fail
    Given I build "DELETE" request
    When I use endpoint "sobjects/Individual/{individualId}" request with "individualId" and <badId>
    And I execute the request
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PatchIndividual
  Scenario: POST to individual
    Given I build "PATCH" request
    When I use endpoint "sobjects/Individual/{individualId}" request with "individualId"
    And I update individual "lastName" to "change lastname"
    Then The response status code should be "NO_CONTENT"

  @PatchIndividual
  Scenario Outline: PATCH to individual fail id
    Given I build "PATCH" request
    When I use endpoint "sobjects/Individual/{individualId}" request with "individualId" and <badId>
    And I update individual "name" to "change name"
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |
      | null     | 404    |

  @PatchIndividual
  Scenario Outline: PATCH to individual fail body
    Given I build "PATCH" request
    When I use endpoint "sobjects/Individual/{individualId}" request with "individualId"
    And I update the <apiName> to <value>
    Then the response status code fail should be <status>
    Examples:
      | apiName   | value    | status |
      | Nameeee   | Account1 | 400    |
      | IsDeleted | Account2 | 400    |
      | null      | Account3 | 400    |
      | Nmme      | null     | 400    |
