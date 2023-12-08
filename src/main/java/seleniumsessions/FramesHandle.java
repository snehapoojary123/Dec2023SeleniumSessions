package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesHandle {
	static WebDriver driver;
	public static void main(String[] args) {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		waitForFrameAndSwitchByIdOrName(10, "main");
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);

	}
	
	public static void waitForFrameAndSwitchByIdOrName(int timeout, String IdOrName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdOrName));
		
	}
	public static void waitForFrameAndSwitchByIndex(int timeout, int farmeIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(farmeIndex));
		
	}
	
	public static void waitForFrameAndSwitchByFrameElement(int timeout, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		
	}
	
	public static void waitForFrameAndSwitchByLocatort(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		
	}

}
