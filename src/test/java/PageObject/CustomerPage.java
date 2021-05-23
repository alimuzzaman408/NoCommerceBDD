package PageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import command_providers.ActOn;

public class CustomerPage {
	public WebDriver driver;

	private static final Logger LOGGER = LogManager.getLogger(CustomerPage.class);

	private final static By lnkCustomers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	private final static By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	private final static By btnAddnew=By.xpath("//a[normalize-space()='Add new']"); //Add new
	private final static By txtEmail=By.xpath("//input[@id='Email']");
	private final static By txtPassword=By.xpath("//input[@id='Password']");
	private final static By txtFirstName=By.xpath("//input[@id='FirstName']");
	private final static By rdMaleGender=By.id("Gender_Male");
	private final static By rdFeMaleGender=By.id("Gender_Female");
	private final static By txtLastName=By.xpath("//input[@id='LastName']");
	private final static By txtDob=By.xpath("//input[@id='DateOfBirth']");
	private final static By txtcustomerRoles=By.xpath("//*[@id='VendorId']/preceding::div[@role='listbox'][1]");
	private final static By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	private final static By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	private final static By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	private final static By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	private final static By lstitemForumModerator=By.xpath("//li[contains(text(),'Forum Moderators')]");
	private final static By deleteRegister=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]");
	private final static By txtCompanyName=By.xpath("//input[@id='Company']");
	private final static By txtAdminComment=By.xpath("//textarea[@id='AdminComment']");
	private final static By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	private final static By btnSave=By.xpath("//button[@name='save']");

	public CustomerPage(WebDriver driver){
		this.driver=driver;
	}

	//Actions Methods
	public CustomerPage clickOnCustomersMenu() {
		ActOn.element(driver, lnkCustomers_menu).click();
		LOGGER.info("customer button clicked");
		return this;
	}

	public CustomerPage clickOnCustomersMenuItem() {
		ActOn.element(driver, lnkCustomers_menuitem).click();
		LOGGER.info("customer_item button clicked");
		return this;
	}

	public CustomerPage clickOnAddnew() {
		ActOn.element(driver, btnAddnew).click();
		LOGGER.info("Add button clicked");
		return this;	
	}
	
	public String generaterandomstring() {	
		String randomstring=RandomStringUtils.randomAlphabetic(5);
		return randomstring;
		
	}

	public CustomerPage setEmail(){
		String email=generaterandomstring()+"@gmail.com";
		ActOn.element(driver, txtEmail).setValue(email);
		LOGGER.info("Email is enttered");
		return this;
	}

	public CustomerPage setPassword(String password){
		ActOn.element(driver, txtPassword).setValue(password);
		LOGGER.info("Password is enttered");
		return this;
	}

	public CustomerPage setFirstName(String fname){
		ActOn.element(driver, txtFirstName).setValue(fname);
		LOGGER.info("First_name is enttered");
		return this;
	}

	public CustomerPage setLastName(String lname){
		ActOn.element(driver, txtLastName).setValue(lname);
		LOGGER.info("Lastname is enttered");
		return this;
	}

	public CustomerPage setGender(String gender){
		if(gender.equals("Male"))
		{
			ActOn.element(driver, rdMaleGender).click();
			LOGGER.info("Male is clicked");
		}
		else if(gender.equals("Female"))
		{
			ActOn.element(driver, rdFeMaleGender).click();
			LOGGER.info("Female is clicked");
		}
		else
		{
			ActOn.element(driver, rdMaleGender).click();//Default
			LOGGER.info("Male is clicked");
		}
		return this;
	}

	public CustomerPage setDob(String dob){
		ActOn.element(driver, txtDob).setValue(dob);
		LOGGER.info("Date is entered");
		return this;
	}

	public CustomerPage setCompanyName(String comname){
		ActOn.element(driver, txtCompanyName).setValue(comname);
		LOGGER.info("Company name is entered");
		return this;
	}

	public CustomerPage setCustomerRoles(String role) throws InterruptedException {
		//If role is vendors should not delete Register as per req.
		if(!role.equals("Vendors")) {
			ActOn.element(driver, deleteRegister).click();
		}
		ActOn.element(driver, txtcustomerRoles).click();
		Thread.sleep(2000);

		WebElement listitem;
		if(role.equals("Administrators")){			
			listitem=driver.findElement(lstitemAdministrators); 
		}
		else if(role.equals("Guests")){			
			listitem=driver.findElement(lstitemGuests);
		}
		else if(role.equals("Registered")){
			listitem=driver.findElement(lstitemRegistered);
		}
		else if(role.equals("Vendors")){
			listitem=driver.findElement(lstitemVendors);
		}

		else if(role.equals("Forum Moderators")){
			listitem=driver.findElement(lstitemForumModerator);
		}
		else{
			listitem=	(WebElement) ActOn.element(driver, lstitemGuests);
		}

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", listitem);
		return this;
	}

	public CustomerPage setManagerOfVendor(String value){		
		Select drp=new Select(driver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
		return this;
	}

	public CustomerPage setAdminComment(String content){
		ActOn.element(driver, txtAdminComment).setValue(content);
		return this;
	}

	public CustomerPage clickOnSave()
	{
		ActOn.element(driver, btnSave).click();
		return this;
	}
}
