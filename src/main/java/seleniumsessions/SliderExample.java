package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderExample {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 driver= new ChromeDriver();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));
		
//		slider.click();
//		slider.click();
		
		int width = slider.getSize().getWidth();
		System.out.println(width);
		
	
		
		Actions act = new Actions(driver);
		act.moveToElement(slider, (width/2)-400, 0).click().build().perform();
	
		

	}

}
