package seleniumsessions;

import org.openqa.selenium.WebDriver;

import javax.swing.text.Document;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecuter {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver= new ChromeDriver();
		 driver.get("https://www.google.com/");
		 JavascriptExecutor js =  (JavascriptExecutor)driver;
		 String title = js.executeScript("return document.title;").toString();
		 System.out.println(title);
		 
		 js.executeScript("alert('hi this is my alert');");

	}

}
