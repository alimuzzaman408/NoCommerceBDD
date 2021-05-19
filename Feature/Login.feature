Feature: Login feature testing in application
Background:
When User opens URL "http://admin-demo.nopcommerce.com/login" 

@PositiveTesting
Scenario: Successful Login with Valid Credentials 	
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Log out link 
	Then Page Title should be "Your store. Login" 
		
@PositiveScenerio
Scenario Outline: Login with valid Data Driven Testing
	And User enters Email as "<email>" and Password as "<password>" 
	And Click on Login 
	Then Page Title should be "Dashboard / nopCommerce administration" 
	When User click on Log out link 
	Then Page Title should be "Your store. Login" 
	
	Examples: 
		| email | password |
		| admin@yourstore.com	|	admin |
		| admin@yourstore.com	|	admin |	
		| admin@yourstore.com	|	admin |
		| admin@yourstore.com	|	admin |
				
@NegativeScenerio
Scenario Outline: Login with invalid Data Driven Testing 
	And User enters Email as "<email>" and Password as "<password>" 
	And Click on Login 
	Then Login in failed	
	Examples: 
		| email | password |
		| admin@yourstore.com	|	admin1 |
		| admin@yourstore.com	|	admin2 |	
		| admin@yourstore.com	|	admin3 |
		| admin@yourstore.com	|	admin4 |		
		
		
		
		
		
