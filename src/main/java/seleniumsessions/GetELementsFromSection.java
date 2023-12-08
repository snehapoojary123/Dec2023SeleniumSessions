package seleniumsessions;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetELementsFromSection {

	static WebDriver driver;

	public static void main(String[] args) {
		
		//find all links
		//print the count
		//print the text of each link
		
		String browser = "chrome";
		
		BrowserUtil brutil = new BrowserUtil();
		
		driver = brutil.initializeDriver(browser);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By linklist = By.xpath("//aside[@id='column-right']//a");
		
		
		ElementUtil eleutil = new ElementUtil(driver);
//		List<WebElement> listlink = eleutil.getElements(linklist);
//		for(WebElement e: listlink) {
//		String linktext = e.getText();
//		System.out.println(linktext);
//		}
		eleutil.getTotalElementCount(linklist);
		eleutil.getOfElementAttributeList(linklist, "href");
		List<String> listlink= getElementsTextList(linklist);
		System.out.println(listlink);

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String> getElementsTextList(By locator) {
		List<String> elementText = new ArrayList<String>();
		List<WebElement>textlist =getElements(locator);
		for(WebElement e:textlist ) {
			elementText.add(e.getText());
		}
		return elementText;
	}

}
