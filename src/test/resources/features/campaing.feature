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

  @PatchCampaign
  Scenario Outline: PATCH to campaign
    Given I build "PATCH" request to campaign
    When I use endpoint "sobjects/Campaign/{campaignId}" request to campaign with "campaignId"
    And I update to campaign the <parameterToUpdate> to <updateDate>
    Then the response status code should be "NO_CONTENT" to campaign
    Examples:
      | parameterToUpdate | updateDate  |
      | name              | change name |
      | numberSent        | 5           |
      | description       | Hi world    |