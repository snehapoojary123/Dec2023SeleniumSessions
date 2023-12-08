package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept2 {

	
		
		static WebDriver driver;

		public static void main(String[] args) {
			
			
			//create a web element + perform action( click, sendKeys,getTtext, isDisplayed..
			
			//create a web element: create a locator
			
			driver =  new ChromeDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
			driver.manage().window().maximize();
			
			driver.findElement(By.name(null));
	}

}
