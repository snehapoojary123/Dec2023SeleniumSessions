package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksAttribute {

	static WebDriver driver;

	public static void main(String[] args) {
		
		//find all links
		//print the count
		//print the text of each link
		
		String browser = "chrome";
		
		BrowserUtil brutil = new BrowserUtil();
		
		driver = brutil.initializeDriver(browser);
		driver.get("https://www.amazn.com");
		By link = By.tagName("a");
		List<WebElement> linklist = getElements(link);
		
		//System.out.println("link count: "+ linklist.size());
//		for(WebElement e: linklist) {
//			String attr = e.getAttribute("href");
//			String text = e.getText();
//			System.out.println(text+"       "+attr);
//			
//		}
		getTotalElementCount(link);
		
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.getOfElementAttributeList(link, "href");

	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static int  getTotalElementCount(By locator) {
		
		int elecount =  getElements(locator).size();
		System.out.println("Total elements for locator- "+locator+ " is- "+ elecount);
		return elecount;
	}

}
