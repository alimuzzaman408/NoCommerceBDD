Feature: Customers 
Background: 
    When User opens URL 
	And User enters Email as "admin@yourstore.com" and Password as "admin" 
	And Click on Login 
	Then User can view Dashboad 
	When User click on customers Menu 
	And click on customers Menu Item 
	
@PositiveTesting
Scenario: Add new Customer 
	And click on Add new button 
	Then User can view Add new customer page 
	When User enter customer info 
	And click on Save button 
	Then User can view confirmation message "The new customer has been added successfully." 
	
@PositiveTesting
Scenario: Search Customer by EMailID 
	And Enter customer EMail
	When Click on search button
	Then User should found Email in the Search table
		
@PositiveTesting
Scenario: Search Customer by Name 
	And Enter customer FirstName
	And Enter customer LastName
	When Click on search button
	Then User should found Name in the Search table
	 
