package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

	public static void main(String[] args) {
		
		String browser = "chrome";
		BrowserUtil brutil = new BrowserUtil();
		
		WebDriver driver = brutil.initializeDriver(browser);
		brutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		brutil.getPageTitle();
		brutil.getPageURL();
		
		By txtemail = By.id("input-email");
		By txtpassword = By.id("input-password");
		By linkforgotpassword = By.linkText("Forgotten Password");
		By btnlogin = By.xpath("//input[@type= 'submit']");
		
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.doSendKeys(txtemail, "green.sneh@gmail.com");
		eleutil.doSendKeys(txtpassword, "Test@123");
		String attrvalue = eleutil.getElementAttribute(txtemail, "placeholder");
		System.out.println(attrvalue);
		eleutil.doClick(btnlogin);
		
	}

}
