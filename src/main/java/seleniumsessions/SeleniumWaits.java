package seleniumsessions;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumWaits {

	public static void main(String[] args) {
		/**
		 * static wait: Thread.sleep - will pause application
		 * dynamic wait: will pause application untill element is available
		 * 		Implicit Wait : Global wait for all elements
		 * 		Explicit Wait : Wait for specific element
		 * 			WebDriverWait:
		 * 			FluentWait
		 * 
		 * WebDriverWait(C) -> FluentWait(C) -> Wait(I)
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//will be applied to all webelements at findelements statement
		
		

	}

}
