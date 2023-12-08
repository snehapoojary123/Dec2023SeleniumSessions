package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJavaScriptPopUps {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Alert
		//Prompt
		//Confirmation popup
		//Auth popup
		//BrowserWindow Popup/ Adverticement
		//File upload popup
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("hi this is sneha");
		alert.accept();
		//alert.dismiss();
		
		
		

	}

}
