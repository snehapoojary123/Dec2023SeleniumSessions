package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageTest {

	public static void main(String[] args) {
		
		String browserName="chrome";
		BrowserUtil brwUtil = new BrowserUtil();
		WebDriver driver =brwUtil.initializeDriver(browserName);
		brwUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		brwUtil.getPageTitle();
		brwUtil.getPageURL();
		
		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmpassword = By.id("input-confirm");
		By chkprivacypolicy = By.name("agree");
		By btnContinue = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By lblacccreated = By.tagName("h1");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstname, "Sneha");
		eleUtil.doSendKeys(lastname, "Poojary");
		eleUtil.doSendKeys(email, "green.sneh@gmail.com");
		eleUtil.doSendKeys(telephone, "8765807758");
		eleUtil.doSendKeys(password, "Test@123");
		eleUtil.doSendKeys(confirmpassword, "Test@123");
		eleUtil.doClick(chkprivacypolicy);
		eleUtil.doClick(btnContinue);
		String txtacccreated = eleUtil.getElementGetText(lblacccreated);
		System.out.println(txtacccreated);
		
		
		brwUtil.quitBrowser();
		
	}

}
