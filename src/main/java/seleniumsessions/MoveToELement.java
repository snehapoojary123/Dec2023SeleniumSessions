package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToELement {

	
		public static void main(String[] args) throws InterruptedException  {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://mrbool.com/");
			
			WebElement mnuLink = driver.findElement(By.xpath("//a[@class='menulink']"));
			List<WebElement> subArticles = driver.findElements(By.xpath("//ul[@class='submenu']//a"));
			
			Actions action = new Actions(driver);
			
			//Thread.sleep(2000);
			action.moveToElement(mnuLink).build().perform();
			for(int i = 0; i <subArticles.size(); i ++) {
				subArticles.get(i).click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='menulink']"));
			Thread.sleep(2000);
			action.moveToElement(mnuLink).build().perform();
			Thread.sleep(2000);
			driver.findElements(By.xpath("//ul[@class='submenu']//a"));
			}
		}
	

}
