Feature: Endpoint Product

  @GetProduct
  Scenario: GET to product
    Given I build "GET" request
    When I use endpoint "sobjects/Product2/{productId}" request with "productId"
    And I execute the request
    Then The response status code should be "OK"
    And The schema should be equals to "schemas/product.json"

  @GetProduct
  Scenario: GET to product
    Given I build "GET" request
    When I use endpoint "sobjects/Product2/{productId}" request with "productId"
    And I execute the request
    And The schema should be equals to "schemas/product.json"

  @GetProduct
  Scenario Outline: GET to product fail
    Given I build "GET" request
    When I use endpoint "sobjects/Product2/{productId}" request with "productId" and "<wrongId>"
    And I execute the request
    Then The response status code should be "NOT_FOUND"
    And The schema should be equals to "schemas/statusgeneral/notfount.json"
    Examples:
      | wrongId  |
      | 12341415 |
      | a4f724r3 |
      | null     |
      | *-*-*-*  |
      |          |

  @PostProduct
  Scenario: POST to product
    Given I build "POST" request
    When I use endpoint "sobjects/Product2/" request to with name "product-test" to product
    Then The response status code should be "CREATED"
    Then The schema should be equals to "schemas/productcreate.json"

  @DeleteProduct
  Scenario: Delete to product
    Given I build "DELETE" request
    When I use endpoint "sobjects/Product2/{productId}" request with "productId"
    And I execute the request
    Then The response status code should be "NO_CONTENT"

  @DeleteProduct
  Scenario Outline: Delete to product
    Given I build "DELETE" request
    When I use endpoint "sobjects/Product2/{productId}" request with "productId" and "<wrongId>"
    And I execute the request
    Then The response status code should be "NOT_FOUND"
    And The schema should be equals to "schemas/statusgeneral/notfount.json"
    Examples:
      | wrongId  |
      | 8941179  |
      | 17f4ea61 |
      | null     |
      |          |

  @PatchProduct
  Scenario Outline: PATCH to product
    Given I build "PATCH" request
    When I use endpoint "sobjects/Product2/{productId}" request with "productId"
    And I update the <parameterToUpdate> to <updateDate>
    Then The response status code should be "NO_CONTENT"
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
    Given I build "PATCH" request
    When I use endpoint "sobjects/Product2/{productId}" request with "productId"
    And I update the <parameterToUpdate> to "<updateDate>"
    Then The response status code should be "BAD_REQUEST"
    And The schema should be equals to "schemas/statusgeneral/badrequest.json"
    Examples:
      | parameterToUpdate | updateDate    |
      | names             | Pedro, Teresa |
      | name              |               |
      | IsActive          |               |
      | Id                | r9g4q741      |
      | LastModifiedDate  | 174e91q7      |
