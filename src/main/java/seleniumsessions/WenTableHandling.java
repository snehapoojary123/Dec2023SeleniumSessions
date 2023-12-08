package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WenTableHandling {
	
	static WebDriver driver;
	static String name;

	public static void main(String[] args) throws InterruptedException {
		String browser ="chrome";
		String url ="https://classic.freecrm.com/index.html";
		
		BrowserUtil brutil = new BrowserUtil();
			
		driver = brutil.initializeDriver(browser);
		brutil.launchURL(url);
		
		
		By username = By.xpath("//input[@name='username']");
		By password = By.xpath("//input[@name='password']");
		By login = By.xpath("//input[@type='submit']");
		By contacts = By.xpath("//a[text()='Contacts']");
		By iframe = By.xpath("//frame[@name='mainpanel']");
		
		
		
		
		ElementUtil eleutil = new ElementUtil(driver);
		
		Thread.sleep(4000);
		eleutil.doSendKeys(username, "snehapoojarytest");
		eleutil.doSendKeys(password, "Test@123");
		eleutil.doClick(login);
		
		Thread.sleep(4000);
		driver.switchTo().frame(eleutil.getElement(iframe));
		eleutil.doClick(contacts);
		
		
		
		selectUser("shweeta poojary");
		System.out.println(getUserCompanyName("dheer lekhrajani"));
		
		
		
		
		
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	
	public static void selectUser(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@name='contact_id']"))
		.click();

		
	}
	
	public static String getUserCompanyName(String name) {
		
		return driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/following-sibling::td/a[@context='company']"))
				.getText();

		
	}

}
