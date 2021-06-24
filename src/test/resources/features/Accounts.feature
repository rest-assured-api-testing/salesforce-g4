Feature: Objects

Scenario Get a Account
Given I need "GET" request
When I find "Account/{accountId}" request
Then the response status coded is "OK"