Feature: Endpoint Campaign

  @GetCampaign
  Scenario: GET to campaign
    Given I build "GET" request
    When I use endpoint "sobjects/Campaign/{campaignId}" request with "campaignId"
    And I execute the request
    Then The response status code should be "OK"
    And The schema should be equals to "schemas/campaign.json"

  @PostCampaign
  Scenario: POST to campaign
    Given I build "POST" request
    When I use endpoint "sobjects/Campaign/" to campaign request to with name "campaign-test"
    Then The response status code should be "CREATED"
    Then The schema should be equals to "schemas/campaigncreate.json"

  @DeleteCampaign
  Scenario: Delete to campaign
    Given I build "DELETE" request
    When I use endpoint "sobjects/Campaign/{campaignId}" request with "campaignId"
    And I execute the request
    Then The response status code should be "NO_CONTENT"

  @DeleteCampaign
  Scenario Outline: Delete to campaign fail
    Given I build "DELETE" request
    When I use endpoint "sobjects/Campaign/{campaignId}" request with "campaignId" and "<wrongId>"
    And I execute the request
    Then The response status code should be "NOT_FOUND"
    Examples:
      | wrongId |
      | 749100  |
      | 9af1r79 |
      | null    |
      |         |

  @PatchCampaign
  Scenario Outline: PATCH to campaign
    Given I build "PATCH" request
    When I use endpoint "sobjects/Campaign/{campaignId}" request with "campaignId"
    And I update the <parameterToUpdate> to <updateDate>
    Then The response status code should be "NO_CONTENT"
    Examples:
      | parameterToUpdate | updateDate  |
      | name              | 你好，世界       |
      | name              | Привет мир  |
      | name              | change name |
      | description       | Hi world    |
      | description       | 你好          |
      | numberSent        | 5           |
      | expectedResponse  | 57          |
      | status            | in progress |
      | status            | completed   |
      | status            | planned     |
      | isActive          | true        |
      | isActive          | false       |

  @PatchCampaign
  Scenario Outline: PATCH to campaign fail
    Given I build "PATCH" request
    When I use endpoint "sobjects/Campaign/{campaignId}" request with "campaignId"
    And I update the "<parameterToUpdate>" to "<updateDate>"
    Then The response status code should be "BAD_REQUEST"
    Examples:
      | parameterToUpdate | updateDate  |
      | names             | Rene, Camen |
      | name              |             |
      | description       |             |
      | descriptions      | 你好         |
      | numberSent        | -5          |
      | numberSent        | 12sent      |
      | expectedResponse  | -400        |
      | status            | doing       |
      | status            |             |
      | isActive          |             |
