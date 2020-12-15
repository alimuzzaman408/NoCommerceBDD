package StepDefinations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.CustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomer;

public class Base {	
public  WebDriver driver;
public Logger logger;
public Properties configProp;
public LoginPage lp;
public CustomerPage addCust;
public SearchCustomer searchcust;

public static String randomestring(){
	String generatedString1 = RandomStringUtils.randomAlphabetic(5);
	return (generatedString1);
}








}
