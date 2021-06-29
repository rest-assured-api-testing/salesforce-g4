Feature: Endpoint Campaign

  @GetCampaign
  Scenario: GET to campaign
    Given I build "GET" request to campaign
    When I use endpoint "sobjects/Campaign/{campaignId}" request to campaign with "campaignId"
    And I execute the request to campaign
    Then the response status code should be "OK" to campaign
    And The schema to campaign should be equals to "schemas/campaign.json"

  @PostCampaign
  Scenario: POST to campaign
    Given I build "POST" request to campaign
    When I use endpoint "sobjects/Campaign/" to campaign request to with name "campaign-test"
    Then the response status code should be "CREATED" to campaign
    Then The schema to campaign should be equals to "schemas/campaigncreate.json"

  @DeleteCampaign
  Scenario: Delete to campaign
    Given I build "DELETE" request to campaign
    When I use endpoint "sobjects/Campaign/{campaignId}" request to campaign with "campaignId"
    And I execute the request to campaign
    Then the response status code should be "NO_CONTENT" to campaign

  @DeleteCampaign
  Scenario Outline: Delete to campaign
    Given I build "DELETE" request to campaign
    When I use endpoint "sobjects/Campaign/{campaignId}" request to campaign with "campaignId" and "<wrongId>"
    And I execute the request to campaign
    Then the response status code should be "NOT_FOUND" to campaign
    Examples:
      | wrongId |
      | 749100  |
      | 9af1r79 |
      | null    |
      |         |

  @PatchCampaign
  Scenario Outline: PATCH to campaign
    Given I build "PATCH" request to campaign
    When I use endpoint "sobjects/Campaign/{campaignId}" request to campaign with "campaignId"
    And I update to campaign the <parameterToUpdate> to <updateDate>
    Then the response status code should be "NO_CONTENT" to campaign
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
  Scenario Outline: PATCH to campaign
    Given I build "PATCH" request to campaign
    When I use endpoint "sobjects/Campaign/{campaignId}" request to campaign with "campaignId"
    And I update to campaign the "<parameterToUpdate>" to "<updateDate>"
    Then the response status code should be "BAD_REQUEST" to campaign
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
