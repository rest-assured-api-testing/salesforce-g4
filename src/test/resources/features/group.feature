Feature: Endpoint group

  @GetGroup
  Scenario: GET to group
    Given I build "GET" request
    When I use endpoint "chatter/groups/{groupId}" request with "groupId"
    And I execute the request
    Then The response status code should be "OK"
    And The schema should be equals to "schemas/group.json"

  @PostGroup
  Scenario: GET to group schema when is created
    Given I build "POST" request
    When I use endpoint "chatter/groups/" request to with "group-test" name and "PublicAccess" visibility
    And The schema should be equals to "schemas/group.json"

  @GetGroup
  Scenario Outline: GET to group fail
    Given I build "GET" request
    When I use endpoint "chatter/groups/{groupId}" request with "groupId" and "<wrongId>"
    And I execute the request
    Then The response status code should be "NOT_FOUND"
    And The schema should be equals to "schemas/statusgeneral/notfount.json"
    Examples:
      | wrongId  |
      | 37967387 |
      | d6f5g491 |
      | null     |
      | *-*-*-*  |
      |          |

  @PostGroup
  Scenario: POST to group
    Given I build "POST" request
    When I use endpoint "chatter/groups/" request to with "group-test" name and "PublicAccess" visibility
    Then The response status code should be "CREATED"
    And The schema should be equals to "schemas/group.json"

  @PostGroup
  Scenario: POST to group
    Given I build "POST" request
    When I use endpoint "chatter/groups/" request to with "group-test" name and "PrivateAccess" visibility
    Then The response status code should be "CREATED"
    And The schema should be equals to "schemas/groupcreateprivate.json"

  @DeleteGroup
  Scenario: POST to group
    Given I build "DELETE" request
    When I use endpoint "chatter/groups/{groupId}" request with "groupId"
    And I execute the request
    Then The response status code should be "NO_CONTENT"

  @DeleteGroup
  Scenario Outline: Delete to group fail
    Given I build "DELETE" request
    When I use endpoint "chatter/groups/{groupId}" request with "groupId" and "<wrongId>"
    And I execute the request
    Then The response status code should be "NOT_FOUND"
    And The schema should be equals to "schemas/statusgeneral/notfount.json"
    Examples:
      | wrongId  |
      | 8941179  |
      | 17f4ea61 |
      | null     |
      |          |

  @PatchGroup
  Scenario Outline: PATCH to group
    Given I build "PATCH" request
    When I use endpoint "chatter/groups/{groupId}" request with "groupId"
    And I update the <parameterToUpdate> to <updateDate>
    Then The response status code should be "OK"
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

  @PatchGroup
  Scenario Outline: PATCH to group fail
    Given I build "PATCH" request
    When I use endpoint "chatter/groups/{groupId}" request with "groupId"
    And I update the "<parameterToUpdate>" to "<updateDate>"
    Then The response status code should be "BAD_REQUEST"
    And The schema should be equals to "schemas/statusgeneral/badrequest.json"
    Examples:
      | parameterToUpdate     | updateDate        |
      |                       | change name group |
      | name                  |                   |
      | visibility            | null              |
      | visibility            | Public            |
      | isArchived            |                   |
      | isAutoArchiveDisabled |                   |
      | isBroadcast           |                   |
      | canHaveChatterGuests  | true              |
    