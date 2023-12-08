package seleniumsessions;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysAndClick {
	static WebDriver driver;
	public static void main(String[] args) {
		 driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		
		WebElement email  = driver.findElement(By.id("input-email"));
		WebElement pwd  = driver.findElement(By.id("input-password"));
		WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
		
		Actions act = new Actions(driver);
		act.sendKeys(email, "green.sneha@gmail.com").build().perform();
		act.sendKeys(pwd, "green.sneha@gmail.com").build().perform();
		act.click(login).build().perform();

	}
	
	public static WebElement getElements(By locator) {
		
		return driver.findElement(locator);
		
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElements(locator), value).build().perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElements(locator)).build().perform();
		
	}

}
