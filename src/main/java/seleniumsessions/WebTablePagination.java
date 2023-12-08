package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		
		while(true) {
			
			if(driver.findElements(By.xpath("//td[text()='India']")).size()>0) {
				selectCountry("India");
				//break;
			}
		//	else {
				WebElement next = driver.findElement(By.linkText("Next"));
				if(next.getAttribute("class").contains("disabled")) {
					System.out.println("Country not found");
					break;
				}
				next.click();
				
				
			//}
		}
	}
	private static void selectCountry(String countryName) {
		
		List<WebElement> country = driver.findElements(By.xpath("//td[text()='"+countryName+"']/..//input[@type='checkbox']"));
		for(WebElement e: country) {
			e.click();
		}
		
		
	}

}
