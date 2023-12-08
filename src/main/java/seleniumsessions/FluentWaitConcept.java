package seleniumsessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		driver.manage().window().maximize();
		 By freeTrial = By.xpath("//a[text()='Free trial']");
		 
		 waitForElementPresentWithFluentWait(10, 2, freeTrial).click();
		 
		
		
		

	}
	
	public static WebElement waitForElementPresentWithFluentWait(int timeOut, int pollingInterval, By locator) {
		
		 Wait<WebDriver> wait =new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(timeOut))
				 .ignoring(NoSuchElementException.class)
				 .ignoring(StaleElementReferenceException.class)
				 .pollingEvery(Duration.ofSeconds(pollingInterval))
				 .withMessage("Element not found..");
		 
		 return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}

}
