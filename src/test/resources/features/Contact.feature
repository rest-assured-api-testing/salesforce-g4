Feature: Endpoint Contact

  @GetContact
  Scenario: GET to contact
    Given I build "GET" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId"
    And I execute the request contact
    Then the response status code should be "OK" to contact

  @PostContact
  Scenario: POST to contact
    Given I build "POST" request to contact
    When I use endpoint "sobjects/Contact/" request to contact with name "contact-test"
    Then the response status code should be "CREATED" to contact

  @DeleteContact
  Scenario: POST to contact
    Given I build "DELETE" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId"
    And I execute the request contact
    Then the response status code should be "NO_CONTENT" to contact

  @PatchContact
  Scenario: POST to contact
    Given I build "PATCH" request to contact
    When I use endpoint "sobjects/Contact/{contactId}" request to contact with "contactId"
    And I update the contact "lastName" to "change lastname"
    Then the response status code should be "NO_CONTENT" to contact