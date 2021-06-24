Feature: Requests for story endpoint to create story in a project

  @CreateProject
  Scenario: Create a Product
    Given I build "POST" request with ID of project with name "Product-test-cucumber"
    When I execute "sobjects/Product2/" request to be create in a product
    Then The response status code should be successful "ok"