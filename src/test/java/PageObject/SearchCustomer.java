package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import command_providers.ActOn;

public class SearchCustomer {
	public WebDriver driver;

	private static final Logger LOGGER = LogManager.getLogger(SearchCustomer.class);

	private final static By search1=By.xpath("//input[@id='SearchEmail']");
	private final static By email=By.xpath("//input[@id='SearchEmail']");
	private final static By search=By.xpath("//button[normalize-space()='Search']");
	private final static By tablerRows=By.xpath("//*[@id='customers-grid']//tbody/tr");
	private final static By tablerColumn=By.xpath("//*[@id='customers-grid']//tbody/tr/td");	
	private final static By firstname=By.xpath("//input[@id='SearchFirstName']");
	private final static By llastname=By.xpath("//input[@id='SearchLastName']");

	public SearchCustomer(WebDriver driver) {
		this.driver=driver;		
	}

	public SearchCustomer setemail(String email1) {	
		ActOn.element(driver, search1).click();
		ActOn.element(driver, email).setValue(email1);
		LOGGER.info("Email is entered");
		return this;		
	}

	public SearchCustomer clicksearch() {		
		ActOn.element(driver, search).click();
		LOGGER.info("Search btn is clicked");
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
		LOGGER.info("Firstname is entered");
		return this;		
	}

	public SearchCustomer setlastname(String lname) {		
		ActOn.element(driver, llastname).setValue(lname);
		LOGGER.info("Lastname is entered");
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

