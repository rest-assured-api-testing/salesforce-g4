Feature: Endpoint Token

  @GetToken
  Scenario: Get a token
    Given I build "POST" request to token
    When I execute token request
    Then The response status code should be "OK" to token
    And The new token should be type "Bearer"
    And The response token should be schema "schemas/token.json"

  @GetToken
  Scenario: Get a token
    Given I build "POST" request to token
    When I execute token request
    And The response token should be schema "schemas/token.json"

  @PostToken
  Scenario: Get a token
    Given I build "POST" request to token
    When I execute token request
    Then The response status code should be "OK" to token
    And The response token should be schema "schemas/token.json"
