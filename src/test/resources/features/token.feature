Feature: Requests for token

  @CreateProject
  Scenario: Get a token
    When I execute toke request
    Then The new token should be type "Bearer"