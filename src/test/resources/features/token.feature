Feature: Endpoint Token

  @GetToken
  Scenario: Get a token
    When I execute token request
    Then The new token should be type "Bearer"

  @GetToken
  Scenario: Get a token
    When I execute token request
    Then The response token should be schema "schemas/token.json"

  @PostToken
  Scenario: Get a token
    When I execute token request
    Then The response status code should be "OK" to token
