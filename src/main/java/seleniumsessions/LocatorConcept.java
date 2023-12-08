package seleniumsessions;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		//create a web element + perform action( click, sendKeys,getTtext, isDisplayed..
		
		//create a web element: create a locator
		
		driver =  new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		
		//1st approach
//		driver.findElement(By.id("input-email")).sendKeys("green.sneha@gmail.com");
//		
//		driver.findElement(By.id("input-password")).sendKeys("Test@123");
//		
//		driver.findElement(By.linkText("Forgotten Password"));
//		
//		driver.findElement(By.tagName("submit")).click();
		
		//2nd approach
//		WebElement emailID = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailID.sendKeys("green.sneha@gmail.com");
//		password.sendKeys("Test@123");
		
		//3rd By Locator
		
		
//		By emailid = By.id("input-email");
//		WebElement eid = driver.findElement(emailid);
//		eid.sendKeys("green.sneha@gmail.com");
//		
//		By pwd = By.id("input-password");
//		WebElement pw = driver.findElement(pwd);
//		pw.sendKeys("Test@123");
		
		//4. By Locator + generic method
//		
//		By emailid = By.id("input-email");
//		getElement(emailid).sendKeys("green.sneha@gmail.com");
//		
//		
//		By pwd = By.id("input-password");
//		getElement(pwd).sendKeys("Test@123");
		
		//5. By Locator  + generic methods for findelement and actions
		
//		By emailid = By.id("input-email");
//		doSendKeys(emailid, "green.sneha@gmail.com");
//		
//		By pwd = By.id("input-password");
//		doSendKeys(pwd, "Test@123");
		
		
//		
		//6. By Locator + generic methods for findelement and actions in Element util class
		
		
		By emailid = By.id("input-email");
		By pwd = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailid, "green.sneha@gmail.com");
		eleUtil.doSendKeys(pwd, "Test@123");
		
		
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		driver.findElement(By.linkText("Forgotten Password")).click();
		
		By txtpwd = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/label");
		
		By txtfp = By.linkText("Forgotten Password");
		
		
	 	String lblpwd = doElementGetText(txtpwd);
		String lblfp = doElementGetText(txtfp);
	 	System.out.println(lblpwd);
		System.out.println(lblfp);
		
		
		
		
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
		
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

}
