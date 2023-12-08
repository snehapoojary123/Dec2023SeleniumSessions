package seleniumsessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class CustomCSSSelector {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		
		
		//#id
		
		//tag#id
		//input#input-email
		
		//class
		//.classname
		//input.form-control.input-lg
		
		//tag#id.classname
		//tag.classname#id
		
		
		//other attribute
		//tag[attr='value'] //input[type='submit']
		
		//multiple attr
		//tag[attr='value'][attr2='value']...
		
		//text() is not supported in css
		
		//contains
		//input[attr*='value']
		
		//starts with
		//input[attr^='value']
		
		//ends with
		//input[attr$='value']
		
		//parent to child
		//parent tag child tag (space if not directly associated)
		//parent tag> child tag > child tag is directly associated
		
		//child to parent not allowed
		// or - comma (,) can be used to select multiple tags
		
		//	input#usrname,submit#button
		
		driver.get("https://app.hubspot.com/login");
		
		int size = driver.findElements(By.cssSelector("input#username,#password,#loginBtn")).size();
		
		System.out.println(size);
		
		//exclude element
		//input.form-control:not(input[name='search'])
		// first-child or forst-of-type  last-child or last-of-type
		//:nth-of-type(2)

	}

}
