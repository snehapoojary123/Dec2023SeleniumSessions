package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class WebDriverBasics {
	
	

	WebDriver driver=null;
	String browser = "chrome";

	// 1. Open browser

	public void launchBrowser() {

		switch (browser) {
		case "chrome":

			driver = new ChromeDriver();

			break;

		case "firefox":

			driver = new FirefoxDriver();

			break;
			
		case "safari":

			driver = new SafariDriver();

			break;
			
		case "edge":

			driver = new EdgeDriver();

			break;
				
		default:
			System.out.println("Invalid Browser: "+ browser);
			break;
		}

		// 2. enter url
		// http/https is important
		driver.get("https://www.amazon.com");

		// 3.get title
		String actualTitle = driver.getTitle();
		System.out.println("Page Title: " + actualTitle);

		// 4.checkpoint to validate the title

		if (actualTitle.equals("Amazon.com. Spend less. Smile more.")) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Automation steps + validation/assertions = Automation Testing

		driver.quit();
		//driver.close();
		driver.getTitle();//: NoSuchSessionException:
	}

	public static void main(String[] args) {
		WebDriverBasics obj = new WebDriverBasics();
				obj.launchBrowser();
	}

}
