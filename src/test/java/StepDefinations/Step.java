package StepDefinations;

import org.openqa.selenium.WebDriver;
import PageObject.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step {	

	WebDriver driver=Hooks.driver;

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String user, String pass) {
		new LoginPage(driver)
		.setUserName(user)
		.setPassword(pass);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		new LoginPage(driver)
		.clickLogin();	   
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {	
		new LoginPage(driver)
		.verifyPageTitle(title);	    
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		new LoginPage(driver).clickLogout();	   
	}
	
	@Then("Login in failed")
	public void failedLogin() {
		new LoginPage(driver).invalidLogin();
		
			   
	}
	




	/*@Then("^Page Title should be {string}$")
	public void page_Title_should_be(String title) throws InterruptedException {
		if(driver.getPageSource().contains("Login was unsuccessful"))
		{
			logger.info("************* Login failed *****************");
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("************* Login Passed *****************");
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000); 
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		logger.info("************* clciking on logout *****************");
		lp.clickLogout();
		Thread.sleep(3000);

	}


	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {
		addCust=new CustomerPage(driver);
		logger.info("********* Verifying Dashboad page title after login successful **************");
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle()); 
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("********* Clicking on customer main menu **************");
		addCust.clickOnCustomersMenu();   
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("********* Clicking on customer sub menu **************");
		addCust.clickOnCustomersMenuItem(); 
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		 addCust.clickOnAddnew();
		  Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle()); 
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomestring() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer roles
		// Add the customer to 'Guests' or 'Registered' customer role
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);

		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Pavan");
		addCust.setLastName("Kumar");
		addCust.setDob("7/05/1985"); // Format: D/MM/YYY
		addCust.setCompanyName("busyQA");
		addCust.setAdminContent("This is for testing.........");
	}


	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		logger.info("********* Saving customer details **************");   
		addCust.clickOnSave();
		   Thread.sleep(2000);  
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));  
	}

	@When("Enter customer EMail")
	public void enter_customer_EMail() {
		searchcust=new SearchCustomer(driver);
		logger.info("********* Searching customer details by Email **************");
		searchcust.setEmail("victoria_victoria@nopCommerce.com");  
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchcust.clickSearch();
		Thread.sleep(3000); 
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
		boolean status=searchcust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}




	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		logger.info("********* Searching customer details by Name **************");
		searchcust=new SearchCustomer(driver);
		searchcust.setFirstName("Victoria");  
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName() {
		searchcust.setLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table() {
		boolean status=searchcust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);

	}*/


}
