package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIFrame {

	static WebDriver driver;
	public static void main(String[] args)  {
		 driver= new ChromeDriver();
		 driver.get("https://selectorshub.com/iframe-scenario/");
		 driver.manage().window().maximize();
		 
		
		 driver.switchTo().frame("pact1");
		 
		
		driver.findElement(By.id("inp_val")).sendKeys("hello sneha ");
		 driver.switchTo().frame("pact2");
		 driver.findElement(By.id("jex")).sendKeys("hello shobha ");
		 driver.switchTo().frame("pact3");
		 driver.findElement(By.id("glaf")).sendKeys("hello shweeta ");
//		 driver.switchTo().parentFrame();
//		 driver.findElement(By.id("jex")).sendKeys("hello sanjeeva ");
//		 driver.switchTo().parentFrame();
//		 driver.findElement(By.id("inp_val")).sendKeys("hello rama ");
		 
		 driver.switchTo().parentFrame();
		 driver.findElement(By.id("jex")).sendKeys("hello shobhavati ");
		 driver.switchTo().parentFrame();
		 driver.findElement(By.id("inp_val")).sendKeys("hello shobhavati ");
		 driver.switchTo().frame("pact2");
		 
		 
		 
		 
		
		
		 

	}

}
