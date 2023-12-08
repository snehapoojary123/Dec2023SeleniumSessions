package seleniumsessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

public class HeadlessBrowser {

	public static void main(String[] args) {
		
		//browser is not visible
		//headess - testing is happening behind the scene
		//fater execution
		//sanity test case
		//complex scenarios might not work
		//screenshots will be taken
		
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		co.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		
	}

}
