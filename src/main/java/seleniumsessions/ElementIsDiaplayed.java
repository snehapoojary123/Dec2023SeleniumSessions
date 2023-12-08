package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementIsDiaplayed {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		String browser = "chrome";
		
		BrowserUtil brutil = new BrowserUtil();
		
		driver = brutil.initializeDriver(browser);
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		By imgLogo = By.cssSelector("#logo > a > img");
		By search = By.name("search");
		By  btnsearch = By.cssSelector("#search > span > button");
		
		if(doIsEmenlenyDisplayed(imgLogo)) {
			System.out.println("img is present-- pass");
		}
		
		if(doIsEmenlenyDisplayed(search)) {
			doSendKeys(search, "MacBook");
			doClick(btnsearch);
		}
		
	}
	
	public static WebElement getWebElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getWebElement(locator).sendKeys(value);
	}
	
	public static boolean doIsEmenlenyDisplayed(By locator) {
		return getWebElement(locator).isDisplayed();
	}
	
	public static void doClick(By locator) {
		getWebElement(locator).click();
	}

}
