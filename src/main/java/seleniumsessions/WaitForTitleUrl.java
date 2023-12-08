package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTitleUrl {

	static WebDriver driver;
	public static void main(String[] args) {
		 driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		String title = waitForTitleContains(10, "Login");
		System.out.println(title);
		
		ElementUtil eleutil = new ElementUtil(driver);
		System.out.println(eleutil.waitForTitleISAndFetch(10, "Account Login"));
		System.out.println(eleutil.waitForURLContainsAndFetch(10, "account/login"));
		System.out.println(eleutil.waitForURLToBeAndFetch(10, "https://naveenautomationlabs.com/opencart/index.php?route=account/login"));
		
		
		

	}
	
	public static String waitForTitleContains(int timeout, String titleFractionValue){
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleContains(titleFractionValue));
			return driver.getTitle();
		}
		
	}


