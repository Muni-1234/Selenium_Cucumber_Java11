Feature: Orange HRM Application
  I want to Login for my HRM Application feature file

  Background: 
    Given User Launch chrome Browser

  @UAT
  Scenario: Orange HRM Login Application with Static Test Data
    When User Launch URL "https://opensource-demo.orangehrmlive.com/"
    And User Enters User as "Admin" and Password as "admin123"
    And Click on Login
    When User Click on Welcome Admin Link
    And Click on Logout Link
    And Close Browser

  @SIT
  Scenario: Orange HRM Login Application with Config Properties file Test Data
    When User Launch URL from Properties file
    And User Enters UserName and Password from Properties file
    And Click on Login
    When User Click on Welcome Admin Link
    And Click on Logout Link
    And Close Browser

  @SIT
  Scenario Outline: Orange HRM Login Application with Data Table
    When User Launch URL <URL>
    And User Enters User as <UserName> and Password as <Password>
    And Click on Login
    When User Click on Welcome Admin Link
    And Click on Logout Link
    And Close Browser

    Examples: 
      | URL                                          | UserName | Password   |
      | "https://opensource-demo.orangehrmlive.com/" | "Admin"  | "admin123" |
