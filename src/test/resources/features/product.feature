Feature: Endpoint Product

  @GetProduct
  Scenario: GET to product
    Given I build "GET" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to object with "productId"
    And I execute the request
    Then the response status code should be "OK" to product

  @GetProduct
  Scenario: GET to product
    Given I build "GET" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to object with "productId"
    And I execute the request
    Then The schema to product should be equals to "schemas/product.json"

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

  @PatchProduct
  Scenario Outline: POST to product
    Given I build "PATCH" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to object with "productId"
    And I update the <parameterToUpdate> to <updateDate>
    Then the response status code should be "NO_CONTENT" to product

    Examples:
      | parameterToUpdate | updateDate         |
      | description       | change description |
      | name              | change name        |
      | name              | 1010352            |
      | IsActive          | true               |
      | IsActive          | false              |
      | ProductCode       | 54as984re          |
      | ProductCode       | 984038             |

  @PostProduct
  Scenario: POST to product fail
    Given I build "POST" request to product
    When I use endpoint "sobjects/Product2/" request to with name ""
    Then the response status code should be "BAD_REQUEST" to product

  @PostProduct
  Scenario: POST to product fail
    Given I build "POST" request to product
    When I use endpoint "sobjects/Product2/" request to with name " "
    Then the response status code should be "BAD_REQUEST" to product

    