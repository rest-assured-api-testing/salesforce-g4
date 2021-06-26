Feature: Endpoint Product

  @GetProduct
  Scenario: GET to product
    Given I build "GET" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to object with "productId"
    And I execute the request
    Then the response status code should be "OK" to product

  @PostProduct
  Scenario: POST to product
    Given I build "POST" request to product
    When I use endpoint "sobjects/Product2/" request to with name "product-test"
    Then the response status code should be "CREATED" to product

  @DeleteProduct
  Scenario: POST to product
    Given I build "DELETE" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to object with "productId"
    And I execute the request
    Then the response status code should be "NO_CONTENT" to product

  @PathProduct
  Scenario: POST to product
    Given I build "PATCH" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to object with "productId"
    And I update the "description" to "change description"
    Then the response status code should be "NO_CONTENT" to product