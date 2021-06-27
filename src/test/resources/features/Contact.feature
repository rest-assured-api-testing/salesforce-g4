Feature: Endpoint Contact

  @GetContact
  Scenario: GET to contact
    Given I build "GET" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId"
    And I execute the request contact
    Then the response status code should be "OK" to contact

  @GetContact
  Scenario: GET to contact with schema
    Given I build "GET" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId"
    And I execute the request contact
    Then The schema to contact should be equals to "schemas/contact.json"

  @GetContact
  Scenario Outline: GET to contact fail
    Given I build "GET" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId" fail <badId>
    And I execute the request contact fail
    Then the response status code fail should be <status> to contact
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |


  @PostContact
  Scenario: POST to contact
    Given I build "POST" request to contact
    When I use endpoint "sobjects/Contact/" request to contact with name "contact-test"
    Then the response status code should be "CREATED" to contact

  @PostContact
  Scenario Outline: POST to contact fail
    Given I build "POST" request to contact
    When I use endpoint "sobjects/Contact/" request to contact with <apiName> and <value>
    Then the response status code fail should be <status> to contact
    Examples:
      | apiName     | value    | status |
      | Name        | Contact1 | 400    |
      | Description | Contact2 | 400    |
      | Firstname   | Contact3 | 400    |
      | LastName    | null     | 201    |
      | null        | Contact4 | 400    |

  @DeleteContact
  Scenario: POST to contact
    Given I build "DELETE" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId"
    And I execute the request contact
    Then the response status code should be "NO_CONTENT" to contact

  @DeleteContact
  Scenario Outline: DELETE to contact fail
    Given I build "DELETE" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId" fail <badId>
    And I execute the request contact
    Then the response status code fail should be <status> to contact
    Examples:
      | badId |status|
      | 12341415 | 404 |
      | null     | 404|

  @PatchContact
  Scenario: POST to contact
    Given I build "PATCH" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId"
    And I update contact "lastName" to "change lastname"
    Then the response status code should be "NO_CONTENT" to contact

  @PatchContact
  Scenario Outline: PATCH to contact fail id
    Given I build "PATCH" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId" fail <badId>
    And I update contact "name" to "change name"
    Then the response status code fail should be <status> to contact
    Examples:
      | badId |status|
      | 12341415 | 404 |
      | null     | 404|

  @PatchContact
  Scenario Outline: PATCH to contact fail body
    Given I build "PATCH" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId"
    And I update contact the <apiName> to <value>
    Then the response status code fail should be <status> to contact
    Examples:
      | apiName      | value    | status|
      | Nameeee      | Account1 | 400 |
      | IsDeleted    | Account2 | 400 |
      | null         | Account3 | 400 |
      | Nmme         | null     | 400 |
