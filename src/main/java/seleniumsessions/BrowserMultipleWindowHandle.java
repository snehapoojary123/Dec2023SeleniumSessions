package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMultipleWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parent = driver.getWindowHandle();
		
		Thread.sleep(3000);
		
		WebElement lkEle = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
		WebElement fbEle = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement twEle = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		WebElement ytEle = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));
		
		lkEle.click();
		fbEle.click();
		twEle.click();
		ytEle.click();
		
		Set<String> handle=driver.getWindowHandles();
		Iterator<String> it =handle.iterator();
		
		while(it.hasNext()) {
			String windoow = it.next();
			driver.switchTo().window(windoow);
			System.out.println(driver.getCurrentUrl());
			if(!windoow.equals(parent)) {
			driver.close();
			}
			driver.switchTo().window(parent);
			
		}
		System.out.println(driver.getCurrentUrl());
		

	}

}
