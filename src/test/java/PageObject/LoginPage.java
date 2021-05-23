package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import command_providers.ActOn;

public class LoginPage {	
	public WebDriver driver;

	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

	private static final By textmail=By.xpath("//*[@id='Email']");	
	private static final By error=By.xpath("//li[normalize-space()='The credentials provided are incorrect']");
	private static final By txtPassword=By.xpath("//*[@id='Password']");
	private static final By btnLogin=By.xpath("//button[normalize-space()='Log in']");
	private static final By lnkLogout=By.xpath("//a[normalize-space()='Logout']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;		
	}

	public LoginPage setUserName(String uname) {
		ActOn.wait(driver, textmail);
		ActOn.element(driver, textmail).setValue(uname);
		LOGGER.info("usenname entered");
		return this;	
	}

	public LoginPage setPassword(String pwd) {
		ActOn.wait(driver, txtPassword);
		ActOn.element(driver, txtPassword).setValue(pwd);
		return this;
	}

	public LoginPage clickLogin() throws InterruptedException {
		ActOn.wait(driver, btnLogin);
		ActOn.element(driver, btnLogin).click();		
		return this;
	}

	public LoginPage verifyPageTitle(String title) {
		ActOn.browser(driver).validateTitle(title);
		LOGGER.info("************* Login Passed *****************");
		return this;
	}

	public LoginPage clickLogout() {
		ActOn.wait(driver, lnkLogout);
		ActOn.element(driver, lnkLogout).click();
		return this;
	}

	public LoginPage invalidLogin() {		
		ActOn.wait(driver, error).waitForElementToBeVisible();
		String value=ActOn.element(driver, error).getTextValue();
		if(value.contains("The credentials provided are incorrect")){
			LOGGER.info("Test is passed");			
		}else {
			LOGGER.info("Test is failed");			
		}		
		return this;
	}
}
