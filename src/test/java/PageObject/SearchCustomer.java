package PageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import command_providers.ActOn;

public class SearchCustomer {

	public WebDriver driver;

	private static final Logger LOGGER = LogManager.getLogger(SearchCustomer.class);
	
	public SearchCustomer(WebDriver driver) {
		this.driver=driver;		
	}
	private final static By search1=By.xpath("//input[@id='SearchEmail']");
	private final static By email=By.xpath("//input[@id='SearchEmail']");
	private final static By search=By.xpath("//button[normalize-space()='Search']");
	private final static By table=By.xpath("//*[@id=\"customers-grid\"]");
	private final static By tablerRows=By.xpath("//*[@id='customers-grid']//tbody/tr");
	private final static By tablerColumn=By.xpath("//*[@id='customers-grid']//tbody/tr/td");

	
	private final static By firstname=By.xpath("//input[@id='SearchFirstName']");
	private final static By llastname=By.xpath("//input[@id='SearchLastName']");
	
	
	public SearchCustomer setemail(String email1) {	
		ActOn.element(driver, search1).click();
		ActOn.element(driver, email).setValue(email1);
		return this;		
	}

	public SearchCustomer clicksearch() {		
		ActOn.element(driver, search).click();
		return this;		
	}

	public int rownum() {
		ActOn.element(driver, tablerRows).getrow();	
		return 0 ;
	}

	public void colnum() {
		ActOn.element(driver, tablerColumn).getrow();				
	}
	
	public SearchCustomer setfirstname(String fname) {		
		ActOn.element(driver, firstname).setValue(fname);
		return this;		
	}
	
	public SearchCustomer setlastname(String lname) {		
		ActOn.element(driver, llastname).setValue(lname);
		return this;		
	}
	
	
	public boolean searchbyEmail(String email) {
		boolean flag=false;
		for(int i=1;i<=rownum();i++ ) {
			String value=driver.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			if(email.equals(value)) {
				flag=true;
				LOGGER.info("Email is found in the table");
				break;
			}else {
				LOGGER.info("Email is not found in the table");
			}
		}
		return flag;
	}
	
	public boolean searchbyname(String name) {
		boolean flag=false;
		for(int i=1;i<=rownum();i++ ) {
			String namevalue=driver.findElement(By.xpath("//*[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			if(name.equals(namevalue)) {
				flag=true;
				LOGGER.info("Name is found in the table");
				break;
			}else {
				LOGGER.info("Name is not found in the table");
			}
		}
		return flag;
	}
}




















	/*	public WebDriver driver;
	public SearchCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String fname) {
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {

		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}

	public void clickSearch() {
		btnSearch.click();

	}

	public int getNoOfRows() {
		return (tableRows.size());
	}

	public int getNoOfColumns() {
		return (tableColumns.size());
	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
					.getText();



			System.out.println(emailid);

			if (emailid.equals(email)) {
				flag = true;
				break;
			}
		}

		return flag;

	}

	public boolean searchCustomerByName(String Name) {
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"))
					.getText();


			if (Name.equals(name)) {
				flag = true;
				break;
			}
		}

		return flag;

	}*/

