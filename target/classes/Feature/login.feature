
@smokeTest
Feature: Login Action 
  Scenario: To Test Login Page
    Given user opens the login page
    When user enters username and password
    |	Admin	|	admin123	|
    Then user login successfully
    And user verifies login page
    Then user logout
    
    
#Feature: Login Action 
  #Scenario: To Test Login Page
    #Given User opens the login page
    #When user enters "Admin" and "admin123"
    #Then user login successfully
    #And user verifies login page
    #Then user logout
    #
    #
    #Feature: Login Action 
  #Scenario Outline: To Test Login Page
    #Given User opens the login page
    #When user enters "<userName>" and "<password>"
    #Then user login successfully
    #And user verifies login page
    #Then user logout
#
#	Examples:
#	| userName	| password	|
#	|	Admin			|	admin123	|
  