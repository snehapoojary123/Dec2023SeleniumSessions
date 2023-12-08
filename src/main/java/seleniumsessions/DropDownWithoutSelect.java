package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownWithoutSelect {

	public static WebDriver driver;

	public static void main(String[] args) {
		
		String browser = "chrome";
		BrowserUtil brutil = new BrowserUtil();
		driver = brutil.initializeDriver(browser);
		driver.get("https://www.orangehrm.com/en/30-day-free-trial/");
		
		By country = By.id("Form_getForm_Country");
		By countryoptions = By.xpath("//select[@id='Form_getForm_Country']/option");
		
//		List<WebElement> countrylist = driver.findElements(countryoptions);
//		for(WebElement e: countrylist) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equalsIgnoreCase("brazil")) {
//				e.click();
//				break;
//			}
//		}
		
		selectDropdownByValue(countryoptions, "japan");
		

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void selectDropdownByValue(By locator, String expValue) {
		List<WebElement> dropdownlist = getElements(locator);
		for(WebElement e: dropdownlist) {
			String text = e.getText();
			if(text.equalsIgnoreCase(expValue)) {
				e.click();
				break;
			}
		}
		
	}

}
