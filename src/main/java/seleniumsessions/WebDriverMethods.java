package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String pageSource = driver.getPageSource();
		//System.out.println(pageSource);
		if(pageSource.contains("Gateway")) {
			System.out.println("pass");
			
		}else {
			System.out.println("fail");
		}
		driver.quit();
	}

}
