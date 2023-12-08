package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementExceptionConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		
//		WebElement email = driver.findElement(By.id("input-email"));
//				email.sendKeys("sneha");
//		driver.navigate().refresh();
//		email = driver.findElement(By.id("input-email"));
//		email.sendKeys("radha");
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	//	Thread.sleep(3000);
		
		List<WebElement> ele = driver.findElements(By.xpath("//footer//a"));
		
//		for(WebElement e : ele) {
//			e.click();
//			driver.navigate().back();
//			driver.findElements(By.xpath("//div[text()='Get to Know Us']/..//a"));
//			//driver.navigate().back();
//		}

		for ( int i =0; i <ele.size(); i++) {
			
			ele.get(i).click();
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			
			
		}
	}

}
