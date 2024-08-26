package StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import PageObject.CustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomer;
import Utilites.ReadConfigFiles;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step {

	WebDriver driver = Hooks.driver;

	@When("User opens URL")
	public void user_opens_url() {
		driver.get(ReadConfigFiles.getPropertyValues("url"));
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String user, String pass) {
		new LoginPage(driver).setUserName(user).setPassword(pass);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		new LoginPage(driver).clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		new LoginPage(driver).verifyPageTitle(title);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		new LoginPage(driver).clickLogout();
	}

	@Then("Login in failed")
	public void failedLogin() {
		new LoginPage(driver).invalidLogin();
	}

	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {
		Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		new CustomerPage(driver).clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		new CustomerPage(driver).clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		new CustomerPage(driver).clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		new CustomerPage(driver).setEmail().setPassword("test123").setCustomerRoles("Guests")
				.setManagerOfVendor("Vendor 2").setGender("Male").setFirstName("Ali").setLastName("Mohammad")
				.setDob("7/12/1980").setCompanyName("vision").setAdminComment("Hey this is zerin");
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		new CustomerPage(driver).clickOnSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']"))
				.getText().contains("The new customer has been added successfully"));
	}

//search email in table
	@When("Enter customer EMail")
	public void enter_customer_EMail() {
		new SearchCustomer(driver).setemail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		new SearchCustomer(driver).clicksearch();
		Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() {
		new SearchCustomer(driver).searchbyEmail("victoria_victoria@nopCommerce.com");
	}

	// search name in table
	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		new SearchCustomer(driver).setfirstname("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName() {
		new SearchCustomer(driver).setlastname("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table() {
		new SearchCustomer(driver).searchbyname("Victoria Terces");
//		boolean status=searchcust.searchCustomerByName();
//		Assert.assertEquals(true, status);
	}
}
