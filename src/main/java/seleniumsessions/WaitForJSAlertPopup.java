package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForJSAlertPopup {
	static WebDriver driver;
	public static void main(String[] args) {
		 driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		//Alert alert =waitForAlertPresent(10);
		String text = getAlertText(10);
		System.out.println(text);
		enterPromptText(10, "Hi i am sneha");
		acceptAlert(10);
		
		

	}

	public static Alert waitForAlertPresent(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public static String getAlertText(int timeout) {
		return waitForAlertPresent(timeout).getText();
		
	}
	
	public static void acceptAlert(int timeout) {
		waitForAlertPresent(timeout).accept();;
		
	}
	public static void dismissAlert(int timeout) {
		waitForAlertPresent(timeout).dismiss();;
		
	}
	public static void enterPromptText(int timeout, String value) {
		waitForAlertPresent(timeout).sendKeys(value);
		
	}
}
