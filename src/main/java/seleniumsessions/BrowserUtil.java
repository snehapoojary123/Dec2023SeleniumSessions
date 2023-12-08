package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the driver based on given browser name
	 * 
	 * @param browserName
	 * @return This returns the specific browser driver
	 */

	public WebDriver initializeDriver(String browserName) {
		System.out.println("Browser Name is: " + browserName);

		switch (browserName.toLowerCase().trim()) {
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
			System.out.println("Invalid Browser: " + browserName);
			break;

		}
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().deleteAllCookies();
		return driver;

	}

	/**
	 * To launch the url
	 * 
	 * @param url
	 */
	public void launchURL(String url) {
		if (url == null) {
			System.out.println("Inavlid url, url cannot be null" + url);

		}
		if (url.indexOf("https") == 0) {
			driver.get(url);
		}
	}

	/**
	 * 
	 * @return the page title
	 */
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		return title;
	}

	/**
	 * 
	 * @returns the current page URL
	 */
	public String getPageURL() {
		String pageURL = driver.getCurrentUrl();
		System.out.println("page URL is: " + pageURL);
		return pageURL;
	}
	/**
	 * to close the browser
	 * check browser is not null
	 */
	public void closeBrowser() {
		if(driver!=null) {
			driver.close();
		}
	}
	
	public void quitBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
