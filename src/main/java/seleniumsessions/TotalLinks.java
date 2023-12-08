package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		
		//find all links
		//print the count
		//print the text of each link
		
		String browser = "chrome";
		
		BrowserUtil brutil = new BrowserUtil();
		
		driver = brutil.initializeDriver(browser);
		driver.get("https://www.amazn.com");
		List <WebElement> linklist=  driver.findElements(By.tagName("a"));
		
		System.out.println("Count of links is: "+ linklist.size());
		
		int count = 0;
		for(WebElement e: linklist) {
			String text = e.getText();
			System.out.println(count + " "+ text);
			count++;
		}
		
//		for (int i =0; i <linklist.size(); i++) {
//			String text = linklist.get(i).getText();
//			System.out.println(text);
//			
//		}

	}

}
