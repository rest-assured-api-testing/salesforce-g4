Feature: Requests for group endpoint

  @CreateProject
  Scenario: Create Group
    Given I build "POST" request to create group with name "Test-group" and visibility "PublicAccess"
    When I execute "chatter/groups" request to create a group
    Then the response status code should be successful in order to be "200"