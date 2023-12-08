package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StringBuilder {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
				
				String text = "document.body.style.zoom='50'";
		js.executeScript(text);
		
		WebElement email = driver.findElement(By.id("input-email"));
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
		
		
		
		StringBuffer text1 = new StringBuffer()
				.append("green")
				.append(".")
				.append("sneha")
				.append("@")
				.append("gmail")
				.append(".")
				.append("com");
		
		java.lang.StringBuilder t = new java.lang.StringBuilder()
				.append("hello");
		
		email.sendKeys(text1,t);	
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		driver.findElement(By.id("input-password")).click();
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		
		
		
				
		
		
		

	}

}
