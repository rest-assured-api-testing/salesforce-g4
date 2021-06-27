Feature: Endpoint Product

  @GetProduct
  Scenario: GET to product
    Given I build "GET" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to product with "productId"
    And I execute the request
    Then the response status code should be "OK" to product

  @GetProduct
  Scenario: GET to product
    Given I build "GET" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to product with "productId"
    And I execute the request
    Then The schema to product should be equals to "schemas/product.json"

  @GetProduct
  Scenario Outline: GET to product fail
    Given I build "GET" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to product with "productId" and "<wrongId>"
    And I execute the request
    Then the response status code should be "NOT_FOUND" to product
    Examples:
      | wrongId  |
      | 12341415 |
      | a4f724r3 |
      | null     |
      | *-*-*-*  |
      |          |

  @PostProduct
  Scenario: POST to product
    Given I build "POST" request to product
    When I use endpoint "sobjects/Product2/" request to with name "product-test"
    Then the response status code should be "CREATED" to product

  @DeleteProduct
  Scenario: Delete to product
    Given I build "DELETE" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to product with "productId"
    And I execute the request
    Then the response status code should be "NO_CONTENT" to product

  @DeleteProduct
  Scenario Outline: Delete to product
    Given I build "DELETE" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to product with "productId" and "<wrongId>"
    And I execute the request
    Then the response status code should be "NOT_FOUND" to product
    Examples:
      | wrongId  |
      | 8941179  |
      | 17f4ea61 |
      | null     |
      |          |

  @PatchProduct
  Scenario Outline: PATCH to product
    Given I build "PATCH" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to product with "productId"
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

  @PatchProduct
  Scenario Outline: PATCH to product fail
    Given I build "PATCH" request to product
    When I use endpoint "sobjects/Product2/{productId}" request to product with "productId"
    And I update the <parameterToUpdate> to "<updateDate>"
    Then the response status code should be "BAD_REQUEST" to product
    Examples:
      | parameterToUpdate | updateDate    |
      | names             | Pedro, Teresa |
      | name              |               |
      | IsActive          |               |
      | Id                | r9g4q741      |
      | LastModifiedDate  | 174e91q7      |
