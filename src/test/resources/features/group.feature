Feature: Endpoint group

  @GetGroup
  Scenario: GET to group
    Given I build "GET" request to group
    When I use endpoint "chatter/groups/{groupId}" request to group with "groupId"
    And I execute the request group
    Then the response status code should be "OK" to group

  @PostGroup
  Scenario: POST to group
    Given I build "POST" request to group
    When I use endpoint "chatter/groups/" request to with name "group-test" and visibility "PublicAccess"
    Then the response status code should be "CREATED" to group

  @DeleteGroup
  Scenario: POST to group
    Given I build "DELETE" request to group
    When I use endpoint "chatter/groups/{groupId}" request to group with "groupId"
    And I execute the request group
    Then the response status code should be "NO_CONTENT" to group

  @PatchGroup
  Scenario Outline: POST to group
    Given I build "PATCH" request to group
    When I use endpoint "chatter/groups/{groupId}" request to group with "groupId"
    And I update group the <parameterToUpdate> to <updateDate>
    Then the response status code should be "OK" to group

    Examples:
      | parameterToUpdate     | updateDate         |
      | description           | change description |
      | name                  | change name group  |
      | name                  | 101035sd2          |
      | visibility            | PrivateAccess      |
      | visibility            | PublicAccess       |
      | isArchived            | false              |
      | isArchived            | true               |
      | isAutoArchiveDisabled | false              |
      | isAutoArchiveDisabled | true               |
      | isBroadcast           | false              |
      | isBroadcast           | true               |
      | canHaveChatterGuests  | false              |
