package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMConcept {

	static WebDriver driver;
	public static void main(String[] args)  {
		 driver= new ChromeDriver();
		 driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		 
		 JavascriptExecutor js =  (JavascriptExecutor)driver;
		 String JSPath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		WebElement pizza =  (WebElement)js.executeScript(JSPath);
		pizza.sendKeys("cheeseburst pizza");

	}

}
