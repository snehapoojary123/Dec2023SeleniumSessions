package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickhandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement btn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		List<WebElement> mnuItem = driver.findElements(By.cssSelector(".context-menu-list span"));
		
		Actions sct = new Actions(driver);
		sct.contextClick(btn).build().perform();
		
		
		
		for(WebElement e : mnuItem) {
			String text = e.getText();
			System.out.println(text);
			e.click();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			sct.contextClick(btn).build().perform();
			}
		}

	}


