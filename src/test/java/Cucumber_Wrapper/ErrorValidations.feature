Feature: Error Validation 

@ErrorValidations
Scenario Outline: Negative Test of ErrorLoginValidation 
	Given I Landed on Ecommerce Page
	When User Logged in with Username "<username>" and Password "<password>"
	Then "Incorrect email or password." message is Displayed on LoginPage
	Examples:
    | username            | password        | ProductName |
    | menda@gmail.com     | Rajkumar@28   	| ZARA COAT 3 |
    
    