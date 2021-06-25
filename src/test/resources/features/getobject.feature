Feature: Requests for get endpoint to object
  description

  @GetObject
  Scenario: Get a object
    Given I build "GET" request to any object
    When I execute "sobjects/Product2/{productId}" request to object with "productId"
    Then the response status code should be "OK" to object
