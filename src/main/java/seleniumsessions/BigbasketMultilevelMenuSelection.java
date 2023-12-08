package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigbasketMultilevelMenuSelection {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		
		Thread.sleep(3000);
		
		//button[contains(@id,'headlessui-menu-button-:Rn69b6')]
		
		selectProductLevel4("Bakery, Cakes & Dairy", "Cookies, Rusk & Khari", "Khari & Cream Rolls");
		
		
		
		
		

	}
	
	public static void selectProductLevel4(String l2, String l3, String l4) throws InterruptedException {
		
		By mainmenu = By.xpath("//*[@id=\"siteLayout\"]/header[2]/div[2]/div[1]/div/div");
		WebElement category = driver.findElement(mainmenu);
		category.click();
		Thread.sleep(2000);
		
		By bakery = By.linkText(l2);
		
		By breads = By.linkText(l3);
		
		By buns = By.linkText(l4);
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(bakery)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(breads)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(buns)).click().build().perform();
		
	}

}
