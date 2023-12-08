package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsConcept {
	
	//Sel4.x

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement ele = driver.findElement(By.partialLinkText("Cranbrook, Canada"));
		
		String left= driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		String right= driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		String above= driver.findElement(with(By.tagName("p")).above(ele)).getText();
		String below= driver.findElement(with(By.tagName("p")).below(ele)).getText();
		String near= driver.findElement(with(By.tagName("p")).near(ele)).getText();
		
		System.out.println(left);
		System.out.println(right);
		System.out.println(above);
		System.out.println(below);
		System.out.println(near);
		

	}

}
