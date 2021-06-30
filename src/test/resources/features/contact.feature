Feature: Endpoint Contact

  @GetContact
  Scenario: GET to contact
    Given I build "GET" request
    When I use endpoint "sobjects/Contact/{contactId}" request with "contactId"
    And I execute the request
    Then The response status code should be "OK"

  @GetContact
  Scenario: GET to contact with schema
    Given I build "GET" request
    When I use endpoint "sobjects/Contact/{contactId}" request with "contactId"
    And I execute the request
    Then The schema should be equals to "schemas/contact.json"

  @GetContact
  Scenario Outline: GET to contact fail
    Given I build "GET" request
    When I use endpoint "sobjects/Contact/{contactId}" request with "contactId" and <badId>
    And I execute the request
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PostContact
  Scenario: POST to contact
    Given I build "POST" request
    When I use endpoint "sobjects/Contact/" request to contact with name "contact-test"
    Then The response status code should be "CREATED"

  @PostContact
  Scenario Outline: POST to contact fail
    Given I build "POST" request
    When I use endpoint "sobjects/Contact/" request with <apiName> and <value> to fail
    Then the response status code fail should be <status>
    Examples:
      | apiName     | value    | status |
      | Name        | Contact1 | 400    |
      | Description | Contact2 | 400    |
      | Firstname   | Contact3 | 400    |
      | LastName    | null     | 201    |
      | null        | Contact4 | 400    |

  @PostContact
  Scenario Outline: POST to contact test
    Given I build to "POST" request to contact object
      | firstName  | <firsName>   |
      | lastName   | <lastName>   |
      | Salutation | <salutation> |
      | BirthDate  | <birthdate>  |
    When I set the "sobjects/Individual" endpoint and send the request with contact body
    Then the response status code fail should be <status> to contact
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

  @DeleteContact
  Scenario: POST to contact
    Given I build "DELETE" request
    When I use endpoint "sobjects/Contact/{contactId}" request with "contactId"
    And I execute the request
    Then The response status code should be "NO_CONTENT"

  @DeleteContact
  Scenario Outline: DELETE to contact fail
    Given I build "DELETE" request
    When I use endpoint "sobjects/Contact/{contactId}" request with "contactId" and <badId>
    And I execute the request
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PatchContact
  Scenario: POST to contact
    Given I build "PATCH" request
    When I use endpoint "sobjects/Contact/{contactId}" request with "contactId"
    And I update contact "lastName" to "change lastname"
    Then The response status code should be "NO_CONTENT"

  @PatchContact
  Scenario Outline: PATCH to contact fail id
    Given I build "PATCH" request
    When I use endpoint "sobjects/Contact/{contactId}" request with "contactId" and <badId>
    And I update contact "name" to "change name"
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PatchContact
  Scenario Outline: PATCH to contact fail body
    Given I build "PATCH" request
    When I use endpoint "sobjects/Contact/{contactId}" request with "contactId"
    And I update the <apiName> to <value>
    Then the response status code fail should be <status>
    Examples:
      | apiName   | value    | status |
      | Nameeee   | Account1 | 400    |
      | IsDeleted | Account2 | 400    |
      | null      | Account3 | 400    |
      | Nmme      | null     | 400    |
