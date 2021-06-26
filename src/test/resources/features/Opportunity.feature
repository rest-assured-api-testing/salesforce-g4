Feature: Endpoint Opportunity

  @GetOpportunity
  Scenario: GET to opportunity
    Given I build "GET" request to opportunity
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request to opportunity with "opportunityId"
    And I execute the request opportunity
    Then the response status code should be "OK" to opportunity

  @PostOpportunity
  Scenario: POST to opportunity
    Given I build "POST" request to opportunity
    When I use endpoint "sobjects/Opportunity/" request to opportunity with name "opportunity-test"
    Then the response status code should be "CREATED" to opportunity

  @DeleteOpportunity
  Scenario: POST to opportunity
    Given I build "DELETE" request to opportunity
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request to opportunity with "opportunityId"
    And I execute the request opportunity
    Then the response status code should be "NO_CONTENT" to opportunity

  @PatchOpportunity
  Scenario: POST to opportunity
    Given I build "PATCH" request to opportunity
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request to opportunity with "opportunityId"
    And I update the opportunity "lastName" to "change lastname"
    Then the response status code should be "NO_CONTENT" to opportunity