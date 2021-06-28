Feature: Endpoint group

  @GetGroup
  Scenario: GET to group
    Given I build "GET" request to group
    When I use endpoint "chatter/groups/{groupId}" request to group with "groupId"
    And I execute the request group
    Then the response status code should be "OK" to group
    And The schema to group should be equals to "schemas/group.json"

  @PostGroup
  Scenario: GET to group schema when is created
    Given I build "POST" request to group
    When I use endpoint "chatter/groups/" request to with name "group-test" and visibility "PublicAccess"
    And The schema to group should be equals to "schemas/group.json"

  @GetGroup
  Scenario Outline: GET to group fail
    Given I build "GET" request to group
    When I use endpoint "chatter/groups/{groupId}" request to group with "groupId" and "<wrongId>"
    And I execute the request group
    Then the response status code should be "NOT_FOUND" to group
    And The schema to group should be equals to "schemas/statusgeneral/notfount.json"
    Examples:
      | wrongId  |
      | 37967387 |
      | d6f5g491 |
      | null     |
      | *-*-*-*  |
      |          |

  @PostGroup
  Scenario: POST to group
    Given I build "POST" request to group
    When I use endpoint "chatter/groups/" request to with name "group-test" and visibility "PublicAccess"
    Then the response status code should be "CREATED" to group
    And The schema to group should be equals to "schemas/group.json"

  @PostGroup
  Scenario: POST to group
    Given I build "POST" request to group
    When I use endpoint "chatter/groups/" request to with name "group-test" and visibility "PrivateAccess"
    Then the response status code should be "CREATED" to group
    And The schema to group should be equals to "schemas/groupcreateprivate.json"

  @DeleteGroup
  Scenario: POST to group
    Given I build "DELETE" request to group
    When I use endpoint "chatter/groups/{groupId}" request to group with "groupId"
    And I execute the request group
    Then the response status code should be "NO_CONTENT" to group

  @DeleteGroup
  Scenario Outline: Delete to group fail
    Given I build "DELETE" request to group
    When I use endpoint "chatter/groups/{groupId}" request to group with "groupId" and "<wrongId>"
    And I execute the request group
    Then the response status code should be "NOT_FOUND" to group
    And The schema to group should be equals to "schemas/statusgeneral/notfount.json"
    Examples:
      | wrongId  |
      | 8941179  |
      | 17f4ea61 |
      | null     |
      |          |

  @PatchGroup
  Scenario Outline: PATCH to group
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

  @PatchGroup
  Scenario Outline: PATCH to group fail
    Given I build "PATCH" request to group
    When I use endpoint "chatter/groups/{groupId}" request to group with "groupId"
    And I update group the "<parameterToUpdate>" to "<updateDate>"
    Then the response status code should be "BAD_REQUEST" to group
    And The schema to group should be equals to "schemas/statusgeneral/badrequest.json"
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
    