Feature: Endpoint Opportunity

  @GetOpportunity
  Scenario: GET to opportunity
    Given I build "GET" request
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request with "opportunityId"
    And I execute the request
    Then The response status code should be "OK"

  @GetOpportunity
  Scenario: GET to opportunity with schema
    Given I build "GET" request
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request with "opportunityId"
    And I execute the request
    Then The schema should be equals to "schemas/opportunity.json"

  @GetOpportunity
  Scenario Outline: GET to opportunity fail
    Given I build "GET" request
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request with "opportunityId" and <badId>
    And I execute the request
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PostOpportunity
  Scenario: POST to opportunity
    Given I build "POST" request
    When I use endpoint "sobjects/Opportunity/" request to opportunity with name "opportunity-test"
    Then The response status code should be "CREATED"

  @PostOpportunity
  Scenario Outline: POST to opportunity fail
    Given I build "POST" request
    When I use endpoint "sobjects/Contact/" request to opportunity with <apiName1> <apiName2> <apiName3> and <value1> <value2> <value3>
    Then the response status code fail should be <status>
    Examples:
      | apiName1 | apiName2  | apiName3  | value1       | value2       | value3       | status |
      | Name     | CloseDate | null      | opportunity1 | 2021-06-21   | null         | 400    |
      | Name     | null      | StageName | opportunity1 | null         | CloseDate    | 400    |
      | null     | CloseDate | StageName | null         | opportunity1 | CloseDate    | 400    |
      | Name     | null      | null      | opportunity1 | null         | null         | 400    |
      | Name     | queryable | StageName | opportunity1 | true         | CloseDate    | 400    |
      | null     | CloseDate | StageName | null         | opportunity1 | CloseDate    | 400    |
      | Name     | CloseDate | StageName | opportunity1 | 2021/06/21   | CloseDate    | 400    |
      | Name     | CloseDate | StageName | opportunity1 | 2021-06-21   | opportunity1 | 400    |
      | null     | null      | null      | opportunity1 | 2021-06-21   | opportunity1 | 400    |
      | Name     | CloseDate | StageName | null         | null         | null         | 400    |


  @DeleteOpportunity
  Scenario: POST to opportunity
    Given I build "DELETE" request
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request with "opportunityId"
    And I execute the request
    Then The response status code should be "NO_CONTENT"

  @DeleteOpportunity
  Scenario Outline: DELETE to opportunity fail
    Given I build "DELETE" request
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request with "opportunityId" and <badId>
    And I execute the request
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PatchOpportunity
  Scenario: POST to opportunity
    Given I build "PATCH" request
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request with "opportunityId"
    And I update opportunity "NewOpportunity" to "change Opportunity"
    Then The response status code should be "NO_CONTENT"

  @PatchOpportunity
  Scenario Outline: PATCH to opportunity fail id
    Given I build "PATCH" request
    When I use endpoint "sobjects/Opportunity/{opportunityId}" request with "opportunityId" and <badId>
    And I update opportunity "name" to "change name"
    Then the response status code fail should be <status>
    Examples:
      | badId    | status |
      | 12341415 | 404    |
      | null     | 404    |

  @PatchOpportunity
  Scenario Outline: PATCH to opportunity fail body
    Given I build "PATCH" request
    When I use endpoint "sobjects/Contact/{opportunityId}" request with "opportunityId"
    And I update the <apiName> to <value>
    Then the response status code fail should be <status>
    Examples:
      | apiName   | value        | status |
      | Nameeee   | Opportunity1 | 404    |
      | IsDeleted | Opportunity2 | 404    |
      | null      | Opportunity3 | 404    |
      | Name      | null         | 404    |
      | CloseDate | null         | 404    |
      | StageName | null         | 404    |
      | null      | null         | 404    |
      | CloseDate | 2025/06/21   | 404    |