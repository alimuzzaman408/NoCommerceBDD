package command_providers;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
	public WebDriver driver;
    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserActions openBrowser(String url) {
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        return this;
    }

    public BrowserActions closeBrowser() {
        driver.quit();
        return this;
    }
    public BrowserActions validateTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        return this;
    }


    public BrowserActions scrollDown(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);

        return this;
    }


}
