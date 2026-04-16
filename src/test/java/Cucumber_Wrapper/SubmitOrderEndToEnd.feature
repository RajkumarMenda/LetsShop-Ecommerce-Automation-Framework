Feature: Purchase the order from Ecommerce Website

	Background:
	Given I Landed on Ecommerce Page
@SubmitOrder
Scenario Outline: Positive Test of Submitting the order
	Given User Logged in with Username "<username>" and Password "<password>"
	When User add the product "<ProductName>" to cart
	And Checkout the product "<ProductName>" and sumbit the order
	Then "THANKYOU FOR THE ORDER." message is Displayed on ConfirmationPage
	Examples:
    | username            | password        | ProductName |
    | menda@gmail.com     | Rajkumar@2818   | ZARA COAT 3 |
    