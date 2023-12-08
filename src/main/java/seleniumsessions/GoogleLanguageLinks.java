package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleLanguageLinks {

	
		
		public static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			String browser = "chrome";
			BrowserUtil brutil = new BrowserUtil();
			driver = brutil.initializeDriver(browser);
			driver.get("https://www.google.com");
			
			By leftfooterlinks = By.xpath("//div[@class ='KxwPGc AghGtd']/a");
			By googleSearch = By.id("APjFqb");
			By searchSuggestions = By.xpath("//li[@role='presentation']//div[@class='wM6W7d']/span");
			
			//List<WebElement>leftlinks=getElements(leftfooterlinks);
			
			ElementUtil eleutil = new ElementUtil(driver);
			List<String> listtext = eleutil.getElementsTextList(leftfooterlinks);
			System.out.println(listtext);
			//List<String> suggestionlist = eleutil.getElementsTextList(searchSuggestions);
			eleutil.doSendKeys(googleSearch, "Naveen Automation Labs");
			Thread.sleep(3000);
			eleutil.selectDropdownByValue(searchSuggestions, "Naveen Automation labs github");
			
	}
		
		public static List<WebElement> getElements(By locator) {
			return driver.findElements(locator);
		}

}
